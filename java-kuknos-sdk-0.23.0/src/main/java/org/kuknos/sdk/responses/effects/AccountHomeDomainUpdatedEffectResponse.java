package org.kuknos.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EffectsRequestBuilder;

/**
 * Represents account_home_domain_updated effect response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see EffectsRequestBuilder
 * @see Server#effects()
 */
public class AccountHomeDomainUpdatedEffectResponse extends EffectResponse {
  @SerializedName("home_domain")
  protected final String homeDomain;

  AccountHomeDomainUpdatedEffectResponse(String homeDomain) {
    this.homeDomain = homeDomain;
  }

  public String getHomeDomain() {
    return homeDomain;
  }
}
