package org.kuknos.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.OperationsRequestBuilder;

/**
 * Represents AccountMerge operation response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/operation.html" target="_blank">Operation documentation</a>
 * @see OperationsRequestBuilder
 * @see Server#operations()
 */
public class AccountMergeOperationResponse extends OperationResponse {
  @SerializedName("account")
  protected final String account;
  @SerializedName("into")
  protected final String into;

  AccountMergeOperationResponse(String account, String into) {
    this.account = account;
    this.into = into;
  }

  public String getAccount() {
    return account;
  }

  public String getInto() {
    return into;
  }
}
