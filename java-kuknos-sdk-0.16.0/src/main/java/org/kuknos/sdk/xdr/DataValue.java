// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import java.util.Arrays;

// === xdr source ============================================================

//  typedef opaque DataValue<64>;

//  ===========================================================================
public class DataValue implements XdrElement {
  private byte[] DataValue;
  public byte[] getDataValue() {
    return this.DataValue;
  }
  public void setDataValue(byte[] value) {
    this.DataValue = value;
  }
  public static void encode(XdrDataOutputStream stream, DataValue  encodedDataValue) throws IOException {
  int DataValuesize = encodedDataValue.DataValue.length;
  stream.writeInt(DataValuesize);
  stream.write(encodedDataValue.getDataValue(), 0, DataValuesize);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static DataValue decode(XdrDataInputStream stream) throws IOException {
    DataValue decodedDataValue = new DataValue();
  int DataValuesize = stream.readInt();
  decodedDataValue.DataValue = new byte[DataValuesize];
  stream.read(decodedDataValue.DataValue, 0, DataValuesize);
    return decodedDataValue;
  }
  @Override
  public int hashCode() {
    return Arrays.hashCode(this.DataValue);
  }
  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof DataValue)) {
      return false;
    }

    DataValue other = (DataValue) object;
    return Arrays.equals(this.DataValue, other.DataValue);
  }
}
