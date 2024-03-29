package org.kuknos.sdk;

import com.google.common.base.Objects;

import org.kuknos.sdk.xdr.DecoratedSignature;
import org.kuknos.sdk.xdr.EnvelopeType;
import org.kuknos.sdk.xdr.Hash;
import org.kuknos.sdk.xdr.Int64;
import org.kuknos.sdk.xdr.SequenceNumber;
import org.kuknos.sdk.xdr.TransactionEnvelope;
import org.kuknos.sdk.xdr.TransactionSignaturePayload;
import org.kuknos.sdk.xdr.TransactionV0;
import org.kuknos.sdk.xdr.TransactionV0Envelope;
import org.kuknos.sdk.xdr.TransactionV1Envelope;
import org.kuknos.sdk.xdr.Uint32;
import org.kuknos.sdk.xdr.XdrDataOutputStream;
import org.kuknos.sdk.xdr.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents <a href="https://www.stellar.org/developers/learn/concepts/transactions.html" target="_blank">Transaction</a> in Stellar network.
 */
public class Transaction extends AbstractTransaction {
  private final long mFee;
  public static final long TIMEOUT_TR = 30;
  private final String mSourceAccount;
  private final long mSequenceNumber;
  private final Operation[] mOperations;
  private final Memo mMemo;
  private final TimeBounds mTimeBounds;
  private EnvelopeType envelopeType = EnvelopeType.ENVELOPE_TYPE_TX_V0;

  Transaction(
          String sourceAccount,
          long fee,
          long sequenceNumber,
          Operation[] operations,
          Memo memo,
          TimeBounds timeBounds,
          Network network
  ) {
    super(network);
    this.mSourceAccount = checkNotNull(sourceAccount, "sourceAccount cannot be null");
    this.mSequenceNumber = checkNotNull(sequenceNumber, "sequenceNumber cannot be null");
    this.mOperations = checkNotNull(operations, "operations cannot be null");
    checkArgument(operations.length > 0, "At least one operation required");

    this.mFee = fee;
    this.mMemo = memo != null ? memo : Memo.none();
    this.mTimeBounds = timeBounds;
  }

  // setEnvelopeType is only used in tests which is why this method is package protected
  void setEnvelopeType(EnvelopeType envelopeType) {
    this.envelopeType = envelopeType;
  }

  @Override
  public byte[] signatureBase() {
    try {
      TransactionSignaturePayload payload = new TransactionSignaturePayload();
      TransactionSignaturePayload.TransactionSignaturePayloadTaggedTransaction taggedTransaction = new TransactionSignaturePayload.TransactionSignaturePayloadTaggedTransaction();
      taggedTransaction.setDiscriminant(EnvelopeType.ENVELOPE_TYPE_TX);
      taggedTransaction.setTx(this.toV1Xdr());
      Hash hash = new Hash();
      hash.setHash(mNetwork.getNetworkId());
      payload.setNetworkId(hash);
      payload.setTaggedTransaction(taggedTransaction);
      ByteArrayOutputStream txOutputStream = new ByteArrayOutputStream();
      XdrDataOutputStream xdrOutputStream = new XdrDataOutputStream(txOutputStream);
      payload.encode(xdrOutputStream);
      return txOutputStream.toByteArray();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  public String getSourceAccount() {
    return mSourceAccount;
  }

  public long getSequenceNumber() {
    return mSequenceNumber;
  }

  public Memo getMemo() {
    return mMemo;
  }
  
  /**
   * @return TimeBounds, or null (representing no time restrictions)
   */
  public TimeBounds getTimeBounds() {
    return mTimeBounds;
  }

  /**
   * Returns fee paid for transaction in stroops (1 stroop = 0.0000001 XLM).
   */
  public long getFee() {
    return mFee;
  }

  /**
   * Returns operations in this transaction.
   */
  public Operation[] getOperations() {
    return mOperations;
  }

  /**
   * Generates Transaction XDR object.
   */
  private TransactionV0 toXdr() {
    // fee
    Uint32 fee = new Uint32();
    fee.setUint32((int)mFee);
    // sequenceNumber
    Int64 sequenceNumberUint = new Int64();
    sequenceNumberUint.setInt64(mSequenceNumber);
    SequenceNumber sequenceNumber = new SequenceNumber();
    sequenceNumber.setSequenceNumber(sequenceNumberUint);
    // operations
    org.kuknos.sdk.xdr.Operation[] operations = new org.kuknos.sdk.xdr.Operation[mOperations.length];
    for (int i = 0; i < mOperations.length; i++) {
      operations[i] = mOperations[i].toXdr();
    }
    // ext
    TransactionV0.TransactionV0Ext ext = new TransactionV0.TransactionV0Ext();
    ext.setDiscriminant(0);

    TransactionV0 transaction = new TransactionV0();
    transaction.setFee(fee);
    transaction.setSeqNum(sequenceNumber);
    transaction.setSourceAccountEd25519(StrKey.encodeToXDRAccountId(this.mSourceAccount).getAccountID().getEd25519());
    transaction.setOperations(operations);
    transaction.setMemo(mMemo.toXdr());
    transaction.setTimeBounds(mTimeBounds == null ? null : mTimeBounds.toXdr());
    transaction.setExt(ext);
    return transaction;
  }

  private org.kuknos.sdk.xdr.Transaction toV1Xdr() {

    // fee
    Uint32 fee = new Uint32();
    fee.setUint32((int)mFee);
    // sequenceNumber
    Int64 sequenceNumberUint = new Int64();
    sequenceNumberUint.setInt64(mSequenceNumber);
    SequenceNumber sequenceNumber = new SequenceNumber();
    sequenceNumber.setSequenceNumber(sequenceNumberUint);
    // operations
    org.kuknos.sdk.xdr.Operation[] operations = new org.kuknos.sdk.xdr.Operation[mOperations.length];
    for (int i = 0; i < mOperations.length; i++) {
      operations[i] = mOperations[i].toXdr();
    }
    // ext
    org.kuknos.sdk.xdr.Transaction.TransactionExt ext = new org.kuknos.sdk.xdr.Transaction.TransactionExt();
    ext.setDiscriminant(0);


    org.kuknos.sdk.xdr.Transaction v1Tx = new org.kuknos.sdk.xdr.Transaction();
    v1Tx.setFee(fee);
    v1Tx.setSeqNum(sequenceNumber);
    v1Tx.setSourceAccount(StrKey.encodeToXDRMuxedAccount(mSourceAccount));
    v1Tx.setOperations(operations);
    v1Tx.setMemo(mMemo.toXdr());
    v1Tx.setTimeBounds(mTimeBounds == null ? null : mTimeBounds.toXdr());
    v1Tx.setExt(ext);

    return v1Tx;
  }

  public static Transaction fromV0EnvelopeXdr(TransactionV0Envelope envelope, Network network) {
    int mFee = envelope.getTx().getFee().getUint32();
    Long mSequenceNumber = envelope.getTx().getSeqNum().getSequenceNumber().getInt64();
    Memo mMemo = Memo.fromXdr(envelope.getTx().getMemo());
    TimeBounds mTimeBounds = TimeBounds.fromXdr(envelope.getTx().getTimeBounds());

    Operation[] mOperations = new Operation[envelope.getTx().getOperations().length];
    for (int i = 0; i < envelope.getTx().getOperations().length; i++) {
      mOperations[i] = Operation.fromXdr(envelope.getTx().getOperations()[i]);
    }

    Transaction transaction = new Transaction(
        StrKey.encodeStellarAccountId(envelope.getTx().getSourceAccountEd25519().getUint256()),
        mFee,
        mSequenceNumber,
        mOperations,
        mMemo,
        mTimeBounds,
        network
    );

    for (DecoratedSignature signature : envelope.getSignatures()) {
      transaction.mSignatures.add(signature);
    }

    return transaction;
  }

  public static Transaction fromV1EnvelopeXdr(TransactionV1Envelope envelope, Network network) {
    int mFee = envelope.getTx().getFee().getUint32();
    Long mSequenceNumber = envelope.getTx().getSeqNum().getSequenceNumber().getInt64();
    Memo mMemo = Memo.fromXdr(envelope.getTx().getMemo());
    TimeBounds mTimeBounds = TimeBounds.fromXdr(envelope.getTx().getTimeBounds());

    Operation[] mOperations = new Operation[envelope.getTx().getOperations().length];
    for (int i = 0; i < envelope.getTx().getOperations().length; i++) {
      mOperations[i] = Operation.fromXdr(envelope.getTx().getOperations()[i]);
    }

    Transaction transaction = new Transaction(
        StrKey.encodeStellarMuxedAccount(envelope.getTx().getSourceAccount()),
        mFee,
        mSequenceNumber,
        mOperations,
        mMemo,
        mTimeBounds,
        network
    );

    for (DecoratedSignature signature : envelope.getSignatures()) {
      transaction.mSignatures.add(signature);
    }

    return transaction;
  }

  /**
   * Generates TransactionEnvelope XDR object.
   */
  @Override
  public TransactionEnvelope toEnvelopeXdr() {
    TransactionEnvelope xdr = new TransactionEnvelope();
    DecoratedSignature[] signatures = new DecoratedSignature[mSignatures.size()];
    signatures = mSignatures.toArray(signatures);

    if (this.envelopeType == EnvelopeType.ENVELOPE_TYPE_TX) {
      TransactionV1Envelope v1Envelope = new TransactionV1Envelope();
      xdr.setDiscriminant(EnvelopeType.ENVELOPE_TYPE_TX);
      v1Envelope.setTx(this.toV1Xdr());
      v1Envelope.setSignatures(signatures);
      xdr.setV1(v1Envelope);
    } else if (this.envelopeType == EnvelopeType.ENVELOPE_TYPE_TX_V0) {
      TransactionV0Envelope v0Envelope = new TransactionV0Envelope();
      xdr.setDiscriminant(EnvelopeType.ENVELOPE_TYPE_TX_V0);
      v0Envelope.setTx(this.toXdr());
      v0Envelope.setSignatures(signatures);
      xdr.setV0(v0Envelope);
    } else {
      throw new RuntimeException("invalid envelope type: "+this.envelopeType);
    }

    return xdr;
  }

  /**
   * Builds a new Transaction object.
   */
  public static class Builder {
    private final TransactionBuilderAccount mSourceAccount;
    private Memo mMemo;
    private TimeBounds mTimeBounds;
    List<Operation> mOperations;
    private boolean timeoutSet;
    private Integer mBaseFee;
    private Network mNetwork;

    public static final long TIMEOUT_INFINITE = 0;

    /**
     * Construct a new transaction builder.
     * @param sourceAccount The source account for this transaction. This account is the account
     * who will use a sequence number. When build() is called, the account object's sequence number
     * will be incremented.
     */
    public Builder(TransactionBuilderAccount sourceAccount, Network network) {
      checkNotNull(sourceAccount, "sourceAccount cannot be null");
      mSourceAccount = sourceAccount;
      mOperations = Collections.synchronizedList(new ArrayList<Operation>());
      mNetwork = checkNotNull(network, "Network cannot be null");
    }

    public int getOperationsCount() {
      return mOperations.size();
    }

    /**
     * Adds a new <a href="https://www.stellar.org/developers/learn/concepts/list-of-operations.html" target="_blank">operation</a> to this transaction.
     * @param operation
     * @return Builder object so you can chain methods.
     * @see Operation
     */
    public Builder addOperation(Operation operation) {
      checkNotNull(operation, "operation cannot be null");
      mOperations.add(operation);
      return this;
    }

    /**
     * Adds a <a href="https://www.stellar.org/developers/learn/concepts/transactions.html" target="_blank">memo</a> to this transaction.
     * @param memo
     * @return Builder object so you can chain methods.
     * @see Memo
     */
    public Builder addMemo(Memo memo) {
      if (mMemo != null) {
        throw new RuntimeException("Memo has been already added.");
      }
      checkNotNull(memo, "memo cannot be null");
      mMemo = memo;
      return this;
    }
    
    /**
     * Adds a <a href="https://www.stellar.org/developers/learn/concepts/transactions.html" target="_blank">time-bounds</a> to this transaction.
     * @param timeBounds
     * @return Builder object so you can chain methods.
     * @see TimeBounds
     */
    public Builder addTimeBounds(TimeBounds timeBounds) {
      if (mTimeBounds != null) {
        throw new RuntimeException("TimeBounds has been already added.");
      }
      checkNotNull(timeBounds, "timeBounds cannot be null");
      mTimeBounds = timeBounds;
      return this;
    }

    /**
     * Because of the distributed nature of the Stellar network it is possible that the status of your transaction
     * will be determined after a long time if the network is highly congested.
     * If you want to be sure to receive the status of the transaction within a given period you should set the
     * {@link TimeBounds} with <code>maxTime</code> on the transaction (this is what <code>setTimeout</code> does
     * internally; if there's <code>minTime</code> set but no <code>maxTime</code> it will be added).
     * Call to <code>Builder.setTimeout</code> is required if Transaction does not have <code>max_time</code> set.
     * If you don't want to set timeout, use <code>TIMEOUT_INFINITE</code>. In general you should set
     * <code>TIMEOUT_INFINITE</code> only in smart contracts.
     * Please note that Horizon may still return <code>504 Gateway Timeout</code> error, even for short timeouts.
     * In such case you need to resubmit the same transaction again without making any changes to receive a status.
     * This method is using the machine system time (UTC), make sure it is set correctly.
     * @param timeout Timeout in seconds.
     * @see TimeBounds
     * @return
     */
    public Builder setTimeout(long timeout) {
      if (mTimeBounds != null && mTimeBounds.getMaxTime() > 0) {
        throw new RuntimeException("TimeBounds.max_time has been already set - setting timeout would overwrite it.");
      }

      if (timeout < 0) {
        throw new RuntimeException("timeout cannot be negative");
      }

      timeoutSet = true;
      if (timeout > 0) {
        long timeoutTimestamp = System.currentTimeMillis() / 1000L + timeout;
        if (mTimeBounds == null) {
          mTimeBounds = new TimeBounds(0, timeoutTimestamp);
        } else {
          mTimeBounds = new TimeBounds(mTimeBounds.getMinTime(), timeoutTimestamp);
        }
      }

      return this;
    }

    public Builder setBaseFee(int baseFee) {
      if (baseFee < MIN_BASE_FEE) {
        throw new IllegalArgumentException("baseFee cannot be smaller than the BASE_FEE (" + MIN_BASE_FEE + "): " + baseFee);
      }

      this.mBaseFee = baseFee;
      return this;
    }

    /**
     * Builds a transaction. It will increment sequence number of the source account.
     */
    public Transaction build() {
      // Ensure setTimeout called or maxTime is set
      if ((mTimeBounds == null || mTimeBounds != null && mTimeBounds.getMaxTime() == 0) && !timeoutSet) {
        throw new RuntimeException("TimeBounds has to be set or you must call setTimeout(TIMEOUT_INFINITE).");
      }

      if (mBaseFee == null) {
        throw new RuntimeException("mBaseFee has to be set. you must call setBaseFee().");
      }

      if (mNetwork == null) {
        throw new NoNetworkSelectedException();
      }

      Operation[] operations = new Operation[mOperations.size()];
      operations = mOperations.toArray(operations);
      Transaction transaction = new Transaction(
              mSourceAccount.getAccountId(),
              operations.length * mBaseFee,
              mSourceAccount.getIncrementedSequenceNumber(),
              operations,
              mMemo,
              mTimeBounds,
              mNetwork
      );
      // Increment sequence number when there were no exceptions when creating a transaction
      mSourceAccount.incrementSequenceNumber();
      return transaction;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
            this.mFee,
            this.mSourceAccount,
            this.mSequenceNumber,
            Arrays.hashCode(this.mOperations),
            this.mMemo,
            this.mTimeBounds,
            this.mSignatures,
            this.mNetwork
    );
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof Transaction)) {
      return false;
    }

    Transaction other = (Transaction) object;
    return Objects.equal(this.mFee, other.mFee) &&
            Objects.equal(this.mSourceAccount, other.mSourceAccount) &&
            Objects.equal(this.mSequenceNumber, other.mSequenceNumber) &&
            Arrays.equals(this.mOperations, other.mOperations) &&
            Objects.equal(this.mMemo, other.mMemo) &&
            Objects.equal(this.mTimeBounds, other.mTimeBounds) &&
            Objects.equal(this.mNetwork, other.mNetwork) &&
            Objects.equal(this.mSignatures, other.mSignatures);
  }
}
