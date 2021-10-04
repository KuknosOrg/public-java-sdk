// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;


// === xdr source ============================================================

//  enum AssetType
//  {
//      ASSET_TYPE_NATIVE = 0,
//      ASSET_TYPE_CREDIT_ALPHANUM4 = 1,
//      ASSET_TYPE_CREDIT_ALPHANUM12 = 2
//  };

//  ===========================================================================
public enum AssetType implements XdrElement {
  ASSET_TYPE_NATIVE(0),
  ASSET_TYPE_CREDIT_ALPHANUM4(1),
  ASSET_TYPE_CREDIT_ALPHANUM12(2),
  ;
  private int mValue;

  AssetType(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  public static AssetType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return ASSET_TYPE_NATIVE;
      case 1: return ASSET_TYPE_CREDIT_ALPHANUM4;
      case 2: return ASSET_TYPE_CREDIT_ALPHANUM12;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, AssetType value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
}
