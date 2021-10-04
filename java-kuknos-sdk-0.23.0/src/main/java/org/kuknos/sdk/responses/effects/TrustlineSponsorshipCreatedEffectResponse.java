package org.kuknos.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EffectsRequestBuilder;
import org.kuknos.sdk.Asset;

/**
 * Represents trustline_sponsorship_created effect response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see EffectsRequestBuilder
 * @see Server#effects()
 */
public class TrustlineSponsorshipCreatedEffectResponse extends EffectResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("sponsor")
  protected final String sponsor;

  public TrustlineSponsorshipCreatedEffectResponse(String assetString, String sponsor) {
    this.assetString = assetString;
    this.sponsor = sponsor;
  }

  public String getAssetString() {
    return assetString;
  }

  public Asset getAsset() {
    return Asset.create(assetString);
  }

  public String getSponsor() {
    return sponsor;
  }
}
