package org.kuknos.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EffectsRequestBuilder;
import org.kuknos.sdk.Asset;
import org.kuknos.sdk.Predicate;

/**
 * Represents claimable_balance_claimant_created effect response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see EffectsRequestBuilder
 * @see Server#effects()
 */
public class ClaimableBalanceClaimantCreatedEffectResponse extends EffectResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("amount")
  protected final String amount;
  @SerializedName("balance_id")
  protected final String balanceId;
  @SerializedName("predicate")
  protected final Predicate predicate;

  public ClaimableBalanceClaimantCreatedEffectResponse(String assetString, String amount, String balanceId, Predicate predicate) {
    this.assetString = assetString;
    this.amount = amount;
    this.balanceId = balanceId;
    this.predicate = predicate;
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

  public Predicate getPredicate() {
    return predicate;
  }
}
