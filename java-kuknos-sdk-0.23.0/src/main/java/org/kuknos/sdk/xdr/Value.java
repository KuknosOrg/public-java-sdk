// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import java.util.Arrays;

// === xdr source ============================================================

//  typedef opaque Value<>;

//  ===========================================================================
public class Value implements XdrElement {
  private byte[] Value;

  public Value() {}

  public Value(byte[] Value) {
    this.Value = Value;
  }

  public byte[] getValue() {
    return this.Value;
  }

  public void setValue(byte[] value) {
    this.Value = value;
  }

  public static void encode(XdrDataOutputStream stream, Value  encodedValue) throws IOException {
    int Valuesize = encodedValue.Value.length;
    stream.writeInt(Valuesize);
    stream.write(encodedValue.getValue(), 0, Valuesize);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static Value decode(XdrDataInputStream stream) throws IOException {
    Value decodedValue = new Value();
    int Valuesize = stream.readInt();
    decodedValue.Value = new byte[Valuesize];
    stream.read(decodedValue.Value, 0, Valuesize);
    return decodedValue;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.Value);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Value)) {
      return false;
    }

    Value other = (Value) object;
    return Arrays.equals(this.Value, other.Value);
  }
}
