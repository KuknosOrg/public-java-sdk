package org.kuknos.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EffectsRequestBuilder;
import org.kuknos.sdk.Asset;

/**
 * Represents claimable_balance_created effect response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see EffectsRequestBuilder
 * @see Server#effects()
 */
public class ClaimableBalanceCreatedEffectResponse extends EffectResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("amount")
  protected final String amount;
  @SerializedName("balance_id")
  protected final String balanceId;

  public ClaimableBalanceCreatedEffectResponse(String assetString, String amount, String balanceId) {
    this.assetString = assetString;
    this.amount = amount;
    this.balanceId = balanceId;
  }

  public String getAssetString() {
    return assetString;
  }

  public Asset getAsset() {
    return Asset.create(assetString);
  }

  public String getAmount() {
    return amount;
  }

  public String getBalanceId() {
    return balanceId;
  }
}
