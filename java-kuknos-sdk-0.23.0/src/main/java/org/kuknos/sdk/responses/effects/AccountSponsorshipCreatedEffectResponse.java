package org.kuknos.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EffectsRequestBuilder;

/**
 * Represents account_sponsorship_created effect response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see EffectsRequestBuilder
 * @see Server#effects()
 */
public class AccountSponsorshipCreatedEffectResponse extends EffectResponse {
  @SerializedName("sponsor")
  private final String sponsor;

  public AccountSponsorshipCreatedEffectResponse(String sponsor) {
    this.sponsor = sponsor;
  }

  public String getSponsor() {
    return sponsor;
  }
}
