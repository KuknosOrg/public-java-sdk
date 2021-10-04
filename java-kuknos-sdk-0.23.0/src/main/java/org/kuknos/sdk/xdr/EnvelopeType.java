// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;


// === xdr source ============================================================

//  enum EnvelopeType
//  {
//      ENVELOPE_TYPE_TX_V0 = 0,
//      ENVELOPE_TYPE_SCP = 1,
//      ENVELOPE_TYPE_TX = 2,
//      ENVELOPE_TYPE_AUTH = 3,
//      ENVELOPE_TYPE_SCPVALUE = 4,
//      ENVELOPE_TYPE_TX_FEE_BUMP = 5,
//      ENVELOPE_TYPE_OP_ID = 6
//  };

//  ===========================================================================
public enum EnvelopeType implements XdrElement {
  ENVELOPE_TYPE_TX_V0(0),
  ENVELOPE_TYPE_SCP(1),
  ENVELOPE_TYPE_TX(2),
  ENVELOPE_TYPE_AUTH(3),
  ENVELOPE_TYPE_SCPVALUE(4),
  ENVELOPE_TYPE_TX_FEE_BUMP(5),
  ENVELOPE_TYPE_OP_ID(6),
  ;
  private int mValue;

  EnvelopeType(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  public static EnvelopeType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return ENVELOPE_TYPE_TX_V0;
      case 1: return ENVELOPE_TYPE_SCP;
      case 2: return ENVELOPE_TYPE_TX;
      case 3: return ENVELOPE_TYPE_AUTH;
      case 4: return ENVELOPE_TYPE_SCPVALUE;
      case 5: return ENVELOPE_TYPE_TX_FEE_BUMP;
      case 6: return ENVELOPE_TYPE_OP_ID;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, EnvelopeType value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
}
