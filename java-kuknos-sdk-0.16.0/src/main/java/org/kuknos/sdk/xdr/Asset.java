// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union Asset switch (AssetType type)
//  {
//  case ASSET_TYPE_NATIVE: // Not credit
//      void;
//  
//  case ASSET_TYPE_CREDIT_ALPHANUM4:
//      struct
//      {
//          AssetCode4 assetCode;
//          AccountID issuer;
//      } alphaNum4;
//  
//  case ASSET_TYPE_CREDIT_ALPHANUM12:
//      struct
//      {
//          AssetCode12 assetCode;
//          AccountID issuer;
//      } alphaNum12;
//  
//      // add other asset types here in the future
//  };

//  ===========================================================================
public class Asset implements XdrElement {
  public Asset () {}
  AssetType type;
  public AssetType getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(AssetType value) {
    this.type = value;
  }
  private AssetAlphaNum4 alphaNum4;
  public AssetAlphaNum4 getAlphaNum4() {
    return this.alphaNum4;
  }
  public void setAlphaNum4(AssetAlphaNum4 value) {
    this.alphaNum4 = value;
  }
  private AssetAlphaNum12 alphaNum12;
  public AssetAlphaNum12 getAlphaNum12() {
    return this.alphaNum12;
  }
  public void setAlphaNum12(AssetAlphaNum12 value) {
    this.alphaNum12 = value;
  }
  public static void encode(XdrDataOutputStream stream, Asset encodedAsset) throws IOException {
  //Xdrgen::AST::Identifier
  //AssetType
  stream.writeInt(encodedAsset.getDiscriminant().getValue());
  switch (encodedAsset.getDiscriminant()) {
  case ASSET_TYPE_NATIVE:
  break;
  case ASSET_TYPE_CREDIT_ALPHANUM4:
  AssetAlphaNum4.encode(stream, encodedAsset.alphaNum4);
  break;
  case ASSET_TYPE_CREDIT_ALPHANUM12:
  AssetAlphaNum12.encode(stream, encodedAsset.alphaNum12);
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static Asset decode(XdrDataInputStream stream) throws IOException {
  Asset decodedAsset = new Asset();
  AssetType discriminant = AssetType.decode(stream);
  decodedAsset.setDiscriminant(discriminant);
  switch (decodedAsset.getDiscriminant()) {
  case ASSET_TYPE_NATIVE:
  break;
  case ASSET_TYPE_CREDIT_ALPHANUM4:
  decodedAsset.alphaNum4 = AssetAlphaNum4.decode(stream);
  break;
  case ASSET_TYPE_CREDIT_ALPHANUM12:
  decodedAsset.alphaNum12 = AssetAlphaNum12.decode(stream);
  break;
  }
    return decodedAsset;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.alphaNum4, this.alphaNum12, this.type);
  }
  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof Asset)) {
      return false;
    }

    Asset other = (Asset) object;
    return Objects.equal(this.alphaNum4, other.alphaNum4) && Objects.equal(this.alphaNum12, other.alphaNum12) && Objects.equal(this.type, other.type);
  }

  public static class AssetAlphaNum4 {
    public AssetAlphaNum4 () {}
    private AssetCode4 assetCode;
    public AssetCode4 getAssetCode() {
      return this.assetCode;
    }
    public void setAssetCode(AssetCode4 value) {
      this.assetCode = value;
    }
    private AccountID issuer;
    public AccountID getIssuer() {
      return this.issuer;
    }
    public void setIssuer(AccountID value) {
      this.issuer = value;
    }
    public static void encode(XdrDataOutputStream stream, AssetAlphaNum4 encodedAssetAlphaNum4) throws IOException{
      AssetCode4.encode(stream, encodedAssetAlphaNum4.assetCode);
      AccountID.encode(stream, encodedAssetAlphaNum4.issuer);
    }
    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }
    public static AssetAlphaNum4 decode(XdrDataInputStream stream) throws IOException {
      AssetAlphaNum4 decodedAssetAlphaNum4 = new AssetAlphaNum4();
      decodedAssetAlphaNum4.assetCode = AssetCode4.decode(stream);
      decodedAssetAlphaNum4.issuer = AccountID.decode(stream);
      return decodedAssetAlphaNum4;
    }
    @Override
    public int hashCode() {
      return Objects.hashCode(this.assetCode, this.issuer);
    }
    @Override
    public boolean equals(Object object) {
      if (object == null || !(object instanceof AssetAlphaNum4)) {
        return false;
      }

      AssetAlphaNum4 other = (AssetAlphaNum4) object;
      return Objects.equal(this.assetCode, other.assetCode) && Objects.equal(this.issuer, other.issuer);
    }

  }
  public static class AssetAlphaNum12 {
    public AssetAlphaNum12 () {}
    private AssetCode12 assetCode;
    public AssetCode12 getAssetCode() {
      return this.assetCode;
    }
    public void setAssetCode(AssetCode12 value) {
      this.assetCode = value;
    }
    private AccountID issuer;
    public AccountID getIssuer() {
      return this.issuer;
    }
    public void setIssuer(AccountID value) {
      this.issuer = value;
    }
    public static void encode(XdrDataOutputStream stream, AssetAlphaNum12 encodedAssetAlphaNum12) throws IOException{
      AssetCode12.encode(stream, encodedAssetAlphaNum12.assetCode);
      AccountID.encode(stream, encodedAssetAlphaNum12.issuer);
    }
    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }
    public static AssetAlphaNum12 decode(XdrDataInputStream stream) throws IOException {
      AssetAlphaNum12 decodedAssetAlphaNum12 = new AssetAlphaNum12();
      decodedAssetAlphaNum12.assetCode = AssetCode12.decode(stream);
      decodedAssetAlphaNum12.issuer = AccountID.decode(stream);
      return decodedAssetAlphaNum12;
    }
    @Override
    public int hashCode() {
      return Objects.hashCode(this.assetCode, this.issuer);
    }
    @Override
    public boolean equals(Object object) {
      if (object == null || !(object instanceof AssetAlphaNum12)) {
        return false;
      }

      AssetAlphaNum12 other = (AssetAlphaNum12) object;
      return Objects.equal(this.assetCode, other.assetCode) && Objects.equal(this.issuer, other.issuer);
    }

  }
}
