// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;
import java.util.Arrays;

// === xdr source ============================================================

//  struct TransactionV1Envelope
//  {
//      Transaction tx;
//      /* Each decorated signature is a signature over the SHA256 hash of
//       * a TransactionSignaturePayload */
//      DecoratedSignature signatures<20>;
//  };

//  ===========================================================================
public class TransactionV1Envelope implements XdrElement {
  public TransactionV1Envelope () {}
  private Transaction tx;
  public Transaction getTx() {
    return this.tx;
  }
  public void setTx(Transaction value) {
    this.tx = value;
  }
  private DecoratedSignature[] signatures;
  public DecoratedSignature[] getSignatures() {
    return this.signatures;
  }
  public void setSignatures(DecoratedSignature[] value) {
    this.signatures = value;
  }
  public static void encode(XdrDataOutputStream stream, TransactionV1Envelope encodedTransactionV1Envelope) throws IOException{
    Transaction.encode(stream, encodedTransactionV1Envelope.tx);
    int signaturessize = encodedTransactionV1Envelope.getSignatures().length;
    stream.writeInt(signaturessize);
    for (int i = 0; i < signaturessize; i++) {
      DecoratedSignature.encode(stream, encodedTransactionV1Envelope.signatures[i]);
    }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static TransactionV1Envelope decode(XdrDataInputStream stream) throws IOException {
    TransactionV1Envelope decodedTransactionV1Envelope = new TransactionV1Envelope();
    decodedTransactionV1Envelope.tx = Transaction.decode(stream);
    int signaturessize = stream.readInt();
    decodedTransactionV1Envelope.signatures = new DecoratedSignature[signaturessize];
    for (int i = 0; i < signaturessize; i++) {
      decodedTransactionV1Envelope.signatures[i] = DecoratedSignature.decode(stream);
    }
    return decodedTransactionV1Envelope;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.tx, Arrays.hashCode(this.signatures));
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof TransactionV1Envelope)) {
      return false;
    }

    TransactionV1Envelope other = (TransactionV1Envelope) object;
    return Objects.equal(this.tx, other.tx) && Arrays.equals(this.signatures, other.signatures);
  }

  public static final class Builder {
    private Transaction tx;
    private DecoratedSignature[] signatures;

    public Builder tx(Transaction tx) {
      this.tx = tx;
      return this;
    }

    public Builder signatures(DecoratedSignature[] signatures) {
      this.signatures = signatures;
      return this;
    }

    public TransactionV1Envelope build() {
      TransactionV1Envelope val = new TransactionV1Envelope();
      val.setTx(tx);
      val.setSignatures(signatures);
      return val;
    }
  }
}
