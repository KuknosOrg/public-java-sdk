// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union CreateClaimableBalanceResult switch (CreateClaimableBalanceResultCode code)
//  {
//  case CREATE_CLAIMABLE_BALANCE_SUCCESS:
//      ClaimableBalanceID balanceID;
//  default:
//      void;
//  };

//  ===========================================================================
public class CreateClaimableBalanceResult implements XdrElement {
  public CreateClaimableBalanceResult () {}
  CreateClaimableBalanceResultCode code;
  public CreateClaimableBalanceResultCode getDiscriminant() {
    return this.code;
  }
  public void setDiscriminant(CreateClaimableBalanceResultCode value) {
    this.code = value;
  }
  private ClaimableBalanceID balanceID;
  public ClaimableBalanceID getBalanceID() {
    return this.balanceID;
  }
  public void setBalanceID(ClaimableBalanceID value) {
    this.balanceID = value;
  }

  public static final class Builder {
    private CreateClaimableBalanceResultCode discriminant;
    private ClaimableBalanceID balanceID;

    public Builder discriminant(CreateClaimableBalanceResultCode discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder balanceID(ClaimableBalanceID balanceID) {
      this.balanceID = balanceID;
      return this;
    }

    public CreateClaimableBalanceResult build() {
      CreateClaimableBalanceResult val = new CreateClaimableBalanceResult();
      val.setDiscriminant(discriminant);
      val.setBalanceID(balanceID);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, CreateClaimableBalanceResult encodedCreateClaimableBalanceResult) throws IOException {
  //Xdrgen::AST::Identifier
  //CreateClaimableBalanceResultCode
  stream.writeInt(encodedCreateClaimableBalanceResult.getDiscriminant().getValue());
  switch (encodedCreateClaimableBalanceResult.getDiscriminant()) {
  case CREATE_CLAIMABLE_BALANCE_SUCCESS:
  ClaimableBalanceID.encode(stream, encodedCreateClaimableBalanceResult.balanceID);
  break;
  default:
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static CreateClaimableBalanceResult decode(XdrDataInputStream stream) throws IOException {
  CreateClaimableBalanceResult decodedCreateClaimableBalanceResult = new CreateClaimableBalanceResult();
  CreateClaimableBalanceResultCode discriminant = CreateClaimableBalanceResultCode.decode(stream);
  decodedCreateClaimableBalanceResult.setDiscriminant(discriminant);
  switch (decodedCreateClaimableBalanceResult.getDiscriminant()) {
  case CREATE_CLAIMABLE_BALANCE_SUCCESS:
  decodedCreateClaimableBalanceResult.balanceID = ClaimableBalanceID.decode(stream);
  break;
  default:
  break;
  }
    return decodedCreateClaimableBalanceResult;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.balanceID, this.code);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof CreateClaimableBalanceResult)) {
      return false;
    }

    CreateClaimableBalanceResult other = (CreateClaimableBalanceResult) object;
    return Objects.equal(this.balanceID, other.balanceID) && Objects.equal(this.code, other.code);
  }
}
