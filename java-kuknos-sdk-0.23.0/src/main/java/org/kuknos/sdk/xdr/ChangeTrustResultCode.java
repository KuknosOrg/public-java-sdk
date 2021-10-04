// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;


// === xdr source ============================================================

//  enum ChangeTrustResultCode
//  {
//      // codes considered as "success" for the operation
//      CHANGE_TRUST_SUCCESS = 0,
//      // codes considered as "failure" for the operation
//      CHANGE_TRUST_MALFORMED = -1,     // bad input
//      CHANGE_TRUST_NO_ISSUER = -2,     // could not find issuer
//      CHANGE_TRUST_INVALID_LIMIT = -3, // cannot drop limit below balance
//                                       // cannot create with a limit of 0
//      CHANGE_TRUST_LOW_RESERVE =
//          -4, // not enough funds to create a new trust line,
//      CHANGE_TRUST_SELF_NOT_ALLOWED = -5 // trusting self is not allowed
//  };

//  ===========================================================================
public enum ChangeTrustResultCode implements XdrElement {
  CHANGE_TRUST_SUCCESS(0),
  CHANGE_TRUST_MALFORMED(-1),
  CHANGE_TRUST_NO_ISSUER(-2),
  CHANGE_TRUST_INVALID_LIMIT(-3),
  CHANGE_TRUST_LOW_RESERVE(-4),
  CHANGE_TRUST_SELF_NOT_ALLOWED(-5),
  ;
  private int mValue;

  ChangeTrustResultCode(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  public static ChangeTrustResultCode decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return CHANGE_TRUST_SUCCESS;
      case -1: return CHANGE_TRUST_MALFORMED;
      case -2: return CHANGE_TRUST_NO_ISSUER;
      case -3: return CHANGE_TRUST_INVALID_LIMIT;
      case -4: return CHANGE_TRUST_LOW_RESERVE;
      case -5: return CHANGE_TRUST_SELF_NOT_ALLOWED;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, ChangeTrustResultCode value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
}
