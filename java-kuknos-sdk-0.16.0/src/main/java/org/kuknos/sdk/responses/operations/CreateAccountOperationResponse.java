package org.kuknos.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.OperationsRequestBuilder;

/**
 * Represents CreateAccount operation response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/operation.html" target="_blank">Operation documentation</a>
 * @see OperationsRequestBuilder
 * @see Server#operations()
 */
public class CreateAccountOperationResponse extends OperationResponse {
  @SerializedName("account")
  protected final String account;
  @SerializedName("funder")
  protected final String funder;
  @SerializedName("starting_balance")
  protected final String startingBalance;

  CreateAccountOperationResponse(String funder, String startingBalance, String account) {
    this.funder = funder;
    this.startingBalance = startingBalance;
    this.account = account;
  }

  public String getAccount() {
    return account;
  }

  public String getStartingBalance() {
    return startingBalance;
  }

  public String getFunder() {
    return funder;
  }
}
