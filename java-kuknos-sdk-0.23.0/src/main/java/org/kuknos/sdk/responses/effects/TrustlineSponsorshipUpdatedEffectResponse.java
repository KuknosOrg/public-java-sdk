package org.kuknos.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EffectsRequestBuilder;
import org.kuknos.sdk.Asset;

/**
 * Represents trustline_sponsorship_updated effect response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see EffectsRequestBuilder
 * @see Server#effects()
 */
public class TrustlineSponsorshipUpdatedEffectResponse extends EffectResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("former_sponsor")
  protected final String formerSponsor;
  @SerializedName("new_sponsor")
  protected final String newSponsor;

  public TrustlineSponsorshipUpdatedEffectResponse(String assetString, String formerSponsor, String newSponsor) {
    this.assetString = assetString;
    this.formerSponsor = formerSponsor;
    this.newSponsor = newSponsor;
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
  public String getNewSponsor() {
    return newSponsor;
  }
}
