// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  struct ClaimClaimableBalanceOp
//  {
//      ClaimableBalanceID balanceID;
//  };

//  ===========================================================================
public class ClaimClaimableBalanceOp implements XdrElement {
  public ClaimClaimableBalanceOp () {}
  private ClaimableBalanceID balanceID;
  public ClaimableBalanceID getBalanceID() {
    return this.balanceID;
  }
  public void setBalanceID(ClaimableBalanceID value) {
    this.balanceID = value;
  }
  public static void encode(XdrDataOutputStream stream, ClaimClaimableBalanceOp encodedClaimClaimableBalanceOp) throws IOException{
    ClaimableBalanceID.encode(stream, encodedClaimClaimableBalanceOp.balanceID);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static ClaimClaimableBalanceOp decode(XdrDataInputStream stream) throws IOException {
    ClaimClaimableBalanceOp decodedClaimClaimableBalanceOp = new ClaimClaimableBalanceOp();
    decodedClaimClaimableBalanceOp.balanceID = ClaimableBalanceID.decode(stream);
    return decodedClaimClaimableBalanceOp;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.balanceID);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ClaimClaimableBalanceOp)) {
      return false;
    }

    ClaimClaimableBalanceOp other = (ClaimClaimableBalanceOp) object;
    return Objects.equal(this.balanceID, other.balanceID);
  }

  public static final class Builder {
    private ClaimableBalanceID balanceID;

    public Builder balanceID(ClaimableBalanceID balanceID) {
      this.balanceID = balanceID;
      return this;
    }

    public ClaimClaimableBalanceOp build() {
      ClaimClaimableBalanceOp val = new ClaimClaimableBalanceOp();
      val.setBalanceID(balanceID);
      return val;
    }
  }
}
