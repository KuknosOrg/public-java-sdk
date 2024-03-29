package org.kuknos.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EffectsRequestBuilder;

/**
 * Represents signer_sponsorship_created effect response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see EffectsRequestBuilder
 * @see Server#effects()
 */
public class SignerSponsorshipCreatedEffectResponse extends EffectResponse {
  @SerializedName("sponsor")
  private final String sponsor;
  @SerializedName("signer")
  private final String signer;

  public SignerSponsorshipCreatedEffectResponse(String signer, String sponsor) {
    this.signer = signer;
    this.sponsor = sponsor;
  }

  public String getSponsor() {
    return sponsor;
  }
  public String getSigner() {
    return signer;
  }
}
