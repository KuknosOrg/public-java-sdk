// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import java.util.Arrays;

// === xdr source ============================================================

//  typedef opaque uint256[32];

//  ===========================================================================
public class Uint256 implements XdrElement {
  private byte[] uint256;

  public Uint256() {}

  public Uint256(byte[] uint256) {
    this.uint256 = uint256;
  }

  public byte[] getUint256() {
    return this.uint256;
  }

  public void setUint256(byte[] value) {
    this.uint256 = value;
  }

  public static void encode(XdrDataOutputStream stream, Uint256  encodedUint256) throws IOException {
    int uint256size = encodedUint256.uint256.length;
    stream.write(encodedUint256.getUint256(), 0, uint256size);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static Uint256 decode(XdrDataInputStream stream) throws IOException {
    Uint256 decodedUint256 = new Uint256();
    int uint256size = 32;
    decodedUint256.uint256 = new byte[uint256size];
    stream.read(decodedUint256.uint256, 0, uint256size);
    return decodedUint256;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.uint256);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Uint256)) {
      return false;
    }

    Uint256 other = (Uint256) object;
    return Arrays.equals(this.uint256, other.uint256);
  }
}