package org.kuknos.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EffectsRequestBuilder;

/**
 * Represents claimable_balance_sponsorship_created effect response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see EffectsRequestBuilder
 * @see Server#effects()
 */
public class ClaimableBalanceSponsorshipCreatedEffectResponse extends EffectResponse {
  @SerializedName("sponsor")
  private final String sponsor;

  @SerializedName("balance_id")
  private final String balanceId;

  public ClaimableBalanceSponsorshipCreatedEffectResponse(String balanceId, String sponsor) {
    this.balanceId = balanceId;
    this.sponsor = sponsor;
  }

  public String getSponsor() {
    return sponsor;
  }

  public String getBalanceId() {
    return balanceId;
  }
}
