// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  struct ClaimOfferAtom
//  {
//      // emitted to identify the offer
//      AccountID sellerID; // Account that owns the offer
//      int64 offerID;
//  
//      // amount and asset taken from the owner
//      Asset assetSold;
//      int64 amountSold;
//  
//      // amount and asset sent to the owner
//      Asset assetBought;
//      int64 amountBought;
//  };

//  ===========================================================================
public class ClaimOfferAtom implements XdrElement {
  public ClaimOfferAtom () {}
  private AccountID sellerID;
  public AccountID getSellerID() {
    return this.sellerID;
  }
  public void setSellerID(AccountID value) {
    this.sellerID = value;
  }
  private Int64 offerID;
  public Int64 getOfferID() {
    return this.offerID;
  }
  public void setOfferID(Int64 value) {
    this.offerID = value;
  }
  private Asset assetSold;
  public Asset getAssetSold() {
    return this.assetSold;
  }
  public void setAssetSold(Asset value) {
    this.assetSold = value;
  }
  private Int64 amountSold;
  public Int64 getAmountSold() {
    return this.amountSold;
  }
  public void setAmountSold(Int64 value) {
    this.amountSold = value;
  }
  private Asset assetBought;
  public Asset getAssetBought() {
    return this.assetBought;
  }
  public void setAssetBought(Asset value) {
    this.assetBought = value;
  }
  private Int64 amountBought;
  public Int64 getAmountBought() {
    return this.amountBought;
  }
  public void setAmountBought(Int64 value) {
    this.amountBought = value;
  }
  public static void encode(XdrDataOutputStream stream, ClaimOfferAtom encodedClaimOfferAtom) throws IOException{
    AccountID.encode(stream, encodedClaimOfferAtom.sellerID);
    Int64.encode(stream, encodedClaimOfferAtom.offerID);
    Asset.encode(stream, encodedClaimOfferAtom.assetSold);
    Int64.encode(stream, encodedClaimOfferAtom.amountSold);
    Asset.encode(stream, encodedClaimOfferAtom.assetBought);
    Int64.encode(stream, encodedClaimOfferAtom.amountBought);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static ClaimOfferAtom decode(XdrDataInputStream stream) throws IOException {
    ClaimOfferAtom decodedClaimOfferAtom = new ClaimOfferAtom();
    decodedClaimOfferAtom.sellerID = AccountID.decode(stream);
    decodedClaimOfferAtom.offerID = Int64.decode(stream);
    decodedClaimOfferAtom.assetSold = Asset.decode(stream);
    decodedClaimOfferAtom.amountSold = Int64.decode(stream);
    decodedClaimOfferAtom.assetBought = Asset.decode(stream);
    decodedClaimOfferAtom.amountBought = Int64.decode(stream);
    return decodedClaimOfferAtom;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.sellerID, this.offerID, this.assetSold, this.amountSold, this.assetBought, this.amountBought);
  }
  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof ClaimOfferAtom)) {
      return false;
    }

    ClaimOfferAtom other = (ClaimOfferAtom) object;
    return Objects.equal(this.sellerID, other.sellerID) && Objects.equal(this.offerID, other.offerID) && Objects.equal(this.assetSold, other.assetSold) && Objects.equal(this.amountSold, other.amountSold) && Objects.equal(this.assetBought, other.assetBought) && Objects.equal(this.amountBought, other.amountBought);
  }
}
