package org.kuknos.sdk.responses.operations;

import com.google.common.base.Optional;
import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.OperationsRequestBuilder;

/**
 * Represents RevokeSponsorship operation response.
 * @see OperationsRequestBuilder
 * @see Server#operations()
 */
public class RevokeSponsorshipOperationResponse extends OperationResponse {
  @SerializedName("account_id")
  private final String accountId;

  @SerializedName("claimable_balance_id")
  private final String claimableBalanceId;

  @SerializedName("data_account_id")
  private final String dataAccountId;

  @SerializedName("data_name")
  private final String dataName;

  @SerializedName("offer_id")
  private final String offerId;

  @SerializedName("trustline_account_id")
  private final String trustlineAccountId;

  @SerializedName("trustline_asset")
  private final String trustlineAsset;

  @SerializedName("signer_account_id")
  private final String signerAccountId;

  @SerializedName("signer_key")
  private final String signerKey;


  public RevokeSponsorshipOperationResponse(String accountId, String claimableBalanceId, String dataAccountId, String dataName, String offerId, String trustlineAccountId, String trustlineAsset, String signerAccountId, String signerKey) {
    this.accountId = accountId;
    this.claimableBalanceId = claimableBalanceId;
    this.dataAccountId = dataAccountId;
    this.dataName = dataName;
    this.offerId = offerId;
    this.trustlineAccountId = trustlineAccountId;
    this.trustlineAsset = trustlineAsset;
    this.signerAccountId = signerAccountId;
    this.signerKey = signerKey;
  }

  public Optional<String> getAccountId() {
    return Optional.fromNullable(accountId);
  }

  public Optional<String> getClaimableBalanceId() {
    return Optional.fromNullable(claimableBalanceId);
  }

  public Optional<String> getDataAccountId() {
    return Optional.fromNullable(dataAccountId);
  }

  public Optional<String> getDataName() {
    return Optional.fromNullable(dataName);
  }

  public Optional<String> getOfferId() {
    return Optional.fromNullable(offerId);
  }

  public Optional<String> getTrustlineAccountId() {
    return Optional.fromNullable(trustlineAccountId);
  }

  public Optional<String> getTrustlineAsset() {
    return Optional.fromNullable(trustlineAsset);
  }

  public Optional<String> getSignerAccountId() {
    return Optional.fromNullable(signerAccountId);
  }

  public Optional<String> getSignerKey() {
    return Optional.fromNullable(signerKey);
  }

}
