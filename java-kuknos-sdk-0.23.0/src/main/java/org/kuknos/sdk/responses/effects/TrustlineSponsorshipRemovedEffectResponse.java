package org.kuknos.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EffectsRequestBuilder;
import org.kuknos.sdk.Asset;

/**
 * Represents trustline_sponsorship_removed effect response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see EffectsRequestBuilder
 * @see Server#effects()
 */
public class TrustlineSponsorshipRemovedEffectResponse extends EffectResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("former_sponsor")
  protected final String formerSponsor;

  public TrustlineSponsorshipRemovedEffectResponse(String assetString, String formerSponsor) {
    this.assetString = assetString;
    this.formerSponsor = formerSponsor;
  }

  public String getAssetString() {
    return assetString;
  }

  public Asset getAsset() {
    return Asset.create(assetString);
  }

  public String getFormerSponsor() {
    return formerSponsor;
  }
}
