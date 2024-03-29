// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  struct TransactionSignaturePayload
//  {
//      Hash networkId;
//      union switch (EnvelopeType type)
//      {
//      // Backwards Compatibility: Use ENVELOPE_TYPE_TX to sign ENVELOPE_TYPE_TX_V0
//      case ENVELOPE_TYPE_TX:
//          Transaction tx;
//      case ENVELOPE_TYPE_TX_FEE_BUMP:
//          FeeBumpTransaction feeBump;
//      }
//      taggedTransaction;
//  };

//  ===========================================================================
public class TransactionSignaturePayload implements XdrElement {
  public TransactionSignaturePayload () {}
  private Hash networkId;
  public Hash getNetworkId() {
    return this.networkId;
  }
  public void setNetworkId(Hash value) {
    this.networkId = value;
  }
  private TransactionSignaturePayloadTaggedTransaction taggedTransaction;
  public TransactionSignaturePayloadTaggedTransaction getTaggedTransaction() {
    return this.taggedTransaction;
  }
  public void setTaggedTransaction(TransactionSignaturePayloadTaggedTransaction value) {
    this.taggedTransaction = value;
  }
  public static void encode(XdrDataOutputStream stream, TransactionSignaturePayload encodedTransactionSignaturePayload) throws IOException{
    Hash.encode(stream, encodedTransactionSignaturePayload.networkId);
    TransactionSignaturePayloadTaggedTransaction.encode(stream, encodedTransactionSignaturePayload.taggedTransaction);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static TransactionSignaturePayload decode(XdrDataInputStream stream) throws IOException {
    TransactionSignaturePayload decodedTransactionSignaturePayload = new TransactionSignaturePayload();
    decodedTransactionSignaturePayload.networkId = Hash.decode(stream);
    decodedTransactionSignaturePayload.taggedTransaction = TransactionSignaturePayloadTaggedTransaction.decode(stream);
    return decodedTransactionSignaturePayload;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.networkId, this.taggedTransaction);
  }
  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof TransactionSignaturePayload)) {
      return false;
    }

    TransactionSignaturePayload other = (TransactionSignaturePayload) object;
    return Objects.equal(this.networkId, other.networkId) && Objects.equal(this.taggedTransaction, other.taggedTransaction);
  }

  public static class TransactionSignaturePayloadTaggedTransaction {
    public TransactionSignaturePayloadTaggedTransaction () {}
    EnvelopeType type;
    public EnvelopeType getDiscriminant() {
      return this.type;
    }
    public void setDiscriminant(EnvelopeType value) {
      this.type = value;
    }
    private Transaction tx;
    public Transaction getTx() {
      return this.tx;
    }
    public void setTx(Transaction value) {
      this.tx = value;
    }
    private FeeBumpTransaction feeBump;
    public FeeBumpTransaction getFeeBump() {
      return this.feeBump;
    }
    public void setFeeBump(FeeBumpTransaction value) {
      this.feeBump = value;
    }
    public static void encode(XdrDataOutputStream stream, TransactionSignaturePayloadTaggedTransaction encodedTransactionSignaturePayloadTaggedTransaction) throws IOException {
    //Xdrgen::AST::Identifier
    //EnvelopeType
    stream.writeInt(encodedTransactionSignaturePayloadTaggedTransaction.getDiscriminant().getValue());
    switch (encodedTransactionSignaturePayloadTaggedTransaction.getDiscriminant()) {
    case ENVELOPE_TYPE_TX:
    Transaction.encode(stream, encodedTransactionSignaturePayloadTaggedTransaction.tx);
    break;
    case ENVELOPE_TYPE_TX_FEE_BUMP:
    FeeBumpTransaction.encode(stream, encodedTransactionSignaturePayloadTaggedTransaction.feeBump);
    break;
    }
    }
    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }
    public static TransactionSignaturePayloadTaggedTransaction decode(XdrDataInputStream stream) throws IOException {
    TransactionSignaturePayloadTaggedTransaction decodedTransactionSignaturePayloadTaggedTransaction = new TransactionSignaturePayloadTaggedTransaction();
    EnvelopeType discriminant = EnvelopeType.decode(stream);
    decodedTransactionSignaturePayloadTaggedTransaction.setDiscriminant(discriminant);
    switch (decodedTransactionSignaturePayloadTaggedTransaction.getDiscriminant()) {
    case ENVELOPE_TYPE_TX:
    decodedTransactionSignaturePayloadTaggedTransaction.tx = Transaction.decode(stream);
    break;
    case ENVELOPE_TYPE_TX_FEE_BUMP:
    decodedTransactionSignaturePayloadTaggedTransaction.feeBump = FeeBumpTransaction.decode(stream);
    break;
    }
      return decodedTransactionSignaturePayloadTaggedTransaction;
    }
    @Override
    public int hashCode() {
      return Objects.hashCode(this.tx, this.feeBump, this.type);
    }
    @Override
    public boolean equals(Object object) {
      if (object == null || !(object instanceof TransactionSignaturePayloadTaggedTransaction)) {
        return false;
      }

      TransactionSignaturePayloadTaggedTransaction other = (TransactionSignaturePayloadTaggedTransaction) object;
      return Objects.equal(this.tx, other.tx) && Objects.equal(this.feeBump, other.feeBump) && Objects.equal(this.type, other.type);
    }

  }
}
