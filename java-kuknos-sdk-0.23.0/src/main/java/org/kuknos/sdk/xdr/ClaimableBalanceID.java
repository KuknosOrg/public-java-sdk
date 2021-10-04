// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union ClaimableBalanceID switch (ClaimableBalanceIDType type)
//  {
//  case CLAIMABLE_BALANCE_ID_TYPE_V0:
//      Hash v0;
//  };

//  ===========================================================================
public class ClaimableBalanceID implements XdrElement {
  public ClaimableBalanceID () {}
  ClaimableBalanceIDType type;
  public ClaimableBalanceIDType getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(ClaimableBalanceIDType value) {
    this.type = value;
  }
  private Hash v0;
  public Hash getV0() {
    return this.v0;
  }
  public void setV0(Hash value) {
    this.v0 = value;
  }

  public static final class Builder {
    private ClaimableBalanceIDType discriminant;
    private Hash v0;

    public Builder discriminant(ClaimableBalanceIDType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder v0(Hash v0) {
      this.v0 = v0;
      return this;
    }

    public ClaimableBalanceID build() {
      ClaimableBalanceID val = new ClaimableBalanceID();
      val.setDiscriminant(discriminant);
      val.setV0(v0);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, ClaimableBalanceID encodedClaimableBalanceID) throws IOException {
  //Xdrgen::AST::Identifier
  //ClaimableBalanceIDType
  stream.writeInt(encodedClaimableBalanceID.getDiscriminant().getValue());
  switch (encodedClaimableBalanceID.getDiscriminant()) {
  case CLAIMABLE_BALANCE_ID_TYPE_V0:
  Hash.encode(stream, encodedClaimableBalanceID.v0);
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static ClaimableBalanceID decode(XdrDataInputStream stream) throws IOException {
  ClaimableBalanceID decodedClaimableBalanceID = new ClaimableBalanceID();
  ClaimableBalanceIDType discriminant = ClaimableBalanceIDType.decode(stream);
  decodedClaimableBalanceID.setDiscriminant(discriminant);
  switch (decodedClaimableBalanceID.getDiscriminant()) {
  case CLAIMABLE_BALANCE_ID_TYPE_V0:
  decodedClaimableBalanceID.v0 = Hash.decode(stream);
  break;
  }
    return decodedClaimableBalanceID;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.v0, this.type);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ClaimableBalanceID)) {
      return false;
    }

    ClaimableBalanceID other = (ClaimableBalanceID) object;
    return Objects.equal(this.v0, other.v0) && Objects.equal(this.type, other.type);
  }
}
