// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import java.util.Arrays;

// === xdr source ============================================================

//  typedef opaque SignatureHint[4];

//  ===========================================================================
public class SignatureHint implements XdrElement {
  private byte[] SignatureHint;

  public SignatureHint() {}

  public SignatureHint(byte[] SignatureHint) {
    this.SignatureHint = SignatureHint;
  }

  public byte[] getSignatureHint() {
    return this.SignatureHint;
  }

  public void setSignatureHint(byte[] value) {
    this.SignatureHint = value;
  }

  public static void encode(XdrDataOutputStream stream, SignatureHint  encodedSignatureHint) throws IOException {
    int SignatureHintsize = encodedSignatureHint.SignatureHint.length;
    stream.write(encodedSignatureHint.getSignatureHint(), 0, SignatureHintsize);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static SignatureHint decode(XdrDataInputStream stream) throws IOException {
    SignatureHint decodedSignatureHint = new SignatureHint();
    int SignatureHintsize = 4;
    decodedSignatureHint.SignatureHint = new byte[SignatureHintsize];
    stream.read(decodedSignatureHint.SignatureHint, 0, SignatureHintsize);
    return decodedSignatureHint;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.SignatureHint);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SignatureHint)) {
      return false;
    }

    SignatureHint other = (SignatureHint) object;
    return Arrays.equals(this.SignatureHint, other.SignatureHint);
  }
}
