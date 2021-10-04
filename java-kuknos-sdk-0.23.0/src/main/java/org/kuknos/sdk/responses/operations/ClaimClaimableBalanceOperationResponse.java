package org.kuknos.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.OperationsRequestBuilder;

/**
 * Represents ClaimClaimableBalance operation response.
 * @see OperationsRequestBuilder
 * @see Server#operations()
 */
public class ClaimClaimableBalanceOperationResponse extends OperationResponse {
  @SerializedName("balance_id")
  private final String balanceId;
  @SerializedName("claimant")
  protected final String claimant;

  public ClaimClaimableBalanceOperationResponse(String balanceId, String claimant) {
    this.balanceId = balanceId;
    this.claimant = claimant;
  }

  public String getBalanceId() {
    return balanceId;
  }

  public String getClaimant() {
    return claimant;
  }
}
