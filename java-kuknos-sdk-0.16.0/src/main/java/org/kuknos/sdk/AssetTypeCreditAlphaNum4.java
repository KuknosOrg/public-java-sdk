package org.kuknos.sdk;

import org.kuknos.sdk.xdr.Asset;
import org.kuknos.sdk.xdr.AssetCode4;
import org.kuknos.sdk.xdr.AssetType;
import org.kuknos.sdk.xdr.*;

/**
 * Represents all assets with codes 1-4 characters long.
 * @see <a href="https://www.stellar.org/developers/learn/concepts/assets.html" target="_blank">Assets</a>
 */
public final class AssetTypeCreditAlphaNum4 extends AssetTypeCreditAlphaNum {

  /**
   * Class constructor
   * @param code Asset code
   * @param issuer Asset issuer
   */
  public AssetTypeCreditAlphaNum4(String code, String issuer) {
    super(code, issuer);
    if (code.length() < 1 || code.length() > 4) {
      throw new AssetCodeLengthInvalidException();
    }
  }

  @Override
  public String getType() {
    return "credit_alphanum4";
  }

  @Override
  public Asset toXdr() {
    Asset xdr = new Asset();
    xdr.setDiscriminant(AssetType.ASSET_TYPE_CREDIT_ALPHANUM4);
    Asset.AssetAlphaNum4 credit = new Asset.AssetAlphaNum4();
    AssetCode4 assetCode4 = new AssetCode4();
    assetCode4.setAssetCode4(Util.paddedByteArray(mCode, 4));
    credit.setAssetCode(assetCode4);
    credit.setIssuer(StrKey.encodeToXDRAccountId(mIssuer));
    xdr.setAlphaNum4(credit);
    return xdr;
  }
}
