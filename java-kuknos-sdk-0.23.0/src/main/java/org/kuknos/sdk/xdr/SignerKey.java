// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union SignerKey switch (SignerKeyType type)
//  {
//  case SIGNER_KEY_TYPE_ED25519:
//      uint256 ed25519;
//  case SIGNER_KEY_TYPE_PRE_AUTH_TX:
//      /* SHA-256 Hash of TransactionSignaturePayload structure */
//      uint256 preAuthTx;
//  case SIGNER_KEY_TYPE_HASH_X:
//      /* Hash of random 256 bit preimage X */
//      uint256 hashX;
//  };

//  ===========================================================================
public class SignerKey implements XdrElement {
  public SignerKey () {}
  SignerKeyType type;
  public SignerKeyType getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(SignerKeyType value) {
    this.type = value;
  }
  private Uint256 ed25519;
  public Uint256 getEd25519() {
    return this.ed25519;
  }
  public void setEd25519(Uint256 value) {
    this.ed25519 = value;
  }
  private Uint256 preAuthTx;
  public Uint256 getPreAuthTx() {
    return this.preAuthTx;
  }
  public void setPreAuthTx(Uint256 value) {
    this.preAuthTx = value;
  }
  private Uint256 hashX;
  public Uint256 getHashX() {
    return this.hashX;
  }
  public void setHashX(Uint256 value) {
    this.hashX = value;
  }

  public static final class Builder {
    private SignerKeyType discriminant;
    private Uint256 ed25519;
    private Uint256 preAuthTx;
    private Uint256 hashX;

    public Builder discriminant(SignerKeyType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder ed25519(Uint256 ed25519) {
      this.ed25519 = ed25519;
      return this;
    }

    public Builder preAuthTx(Uint256 preAuthTx) {
      this.preAuthTx = preAuthTx;
      return this;
    }

    public Builder hashX(Uint256 hashX) {
      this.hashX = hashX;
      return this;
    }

    public SignerKey build() {
      SignerKey val = new SignerKey();
      val.setDiscriminant(discriminant);
      val.setEd25519(ed25519);
      val.setPreAuthTx(preAuthTx);
      val.setHashX(hashX);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, SignerKey encodedSignerKey) throws IOException {
  //Xdrgen::AST::Identifier
  //SignerKeyType
  stream.writeInt(encodedSignerKey.getDiscriminant().getValue());
  switch (encodedSignerKey.getDiscriminant()) {
  case SIGNER_KEY_TYPE_ED25519:
  Uint256.encode(stream, encodedSignerKey.ed25519);
  break;
  case SIGNER_KEY_TYPE_PRE_AUTH_TX:
  Uint256.encode(stream, encodedSignerKey.preAuthTx);
  break;
  case SIGNER_KEY_TYPE_HASH_X:
  Uint256.encode(stream, encodedSignerKey.hashX);
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static SignerKey decode(XdrDataInputStream stream) throws IOException {
  SignerKey decodedSignerKey = new SignerKey();
  SignerKeyType discriminant = SignerKeyType.decode(stream);
  decodedSignerKey.setDiscriminant(discriminant);
  switch (decodedSignerKey.getDiscriminant()) {
  case SIGNER_KEY_TYPE_ED25519:
  decodedSignerKey.ed25519 = Uint256.decode(stream);
  break;
  case SIGNER_KEY_TYPE_PRE_AUTH_TX:
  decodedSignerKey.preAuthTx = Uint256.decode(stream);
  break;
  case SIGNER_KEY_TYPE_HASH_X:
  decodedSignerKey.hashX = Uint256.decode(stream);
  break;
  }
    return decodedSignerKey;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.ed25519, this.preAuthTx, this.hashX, this.type);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SignerKey)) {
      return false;
    }

    SignerKey other = (SignerKey) object;
    return Objects.equal(this.ed25519, other.ed25519) && Objects.equal(this.preAuthTx, other.preAuthTx) && Objects.equal(this.hashX, other.hashX) && Objects.equal(this.type, other.type);
  }
}
