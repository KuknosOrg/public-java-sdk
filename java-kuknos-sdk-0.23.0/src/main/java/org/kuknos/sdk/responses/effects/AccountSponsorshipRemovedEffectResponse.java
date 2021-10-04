package org.kuknos.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EffectsRequestBuilder;

/**
 * Represents account_sponsorship_removed effect response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see EffectsRequestBuilder
 * @see Server#effects()
 */
public class AccountSponsorshipRemovedEffectResponse extends EffectResponse {
  @SerializedName("former_sponsor")
  private final String formerSponsor;

  public AccountSponsorshipRemovedEffectResponse(String formerSponsor) {
    this.formerSponsor = formerSponsor;
  }

  public String getFormerSponsor() {
    return formerSponsor;
  }
}
