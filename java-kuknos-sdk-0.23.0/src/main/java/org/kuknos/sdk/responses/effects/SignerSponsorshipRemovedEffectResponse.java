package org.kuknos.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EffectsRequestBuilder;

/**
 * Represents signer_sponsorship_removed effect response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see EffectsRequestBuilder
 * @see Server#effects()
 */
public class SignerSponsorshipRemovedEffectResponse extends EffectResponse {
  @SerializedName("former_sponsor")
  private final String formerSponsor;
  @SerializedName("signer")
  private final String signer;

  public SignerSponsorshipRemovedEffectResponse(String signer, String formerSponsor) {
    this.signer = signer;
    this.formerSponsor = formerSponsor;
  }

  public String getSigner() {
    return signer;
  }
  public String getFormerSponsor() {
    return formerSponsor;
  }

}
