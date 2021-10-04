package org.kuknos.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.OperationsRequestBuilder;

/**
 * Represents BeginSponsoringFutureReserves operation response.
 * @see OperationsRequestBuilder
 * @see Server#operations()
 */
public class BeginSponsoringFutureReservesOperationResponse extends OperationResponse {
  @SerializedName("sponsored_id")
  private final String sponsoredId;

  public BeginSponsoringFutureReservesOperationResponse(String sponsoredId) {
    this.sponsoredId = sponsoredId;
  }

  public String getSponsoredId() {
    return sponsoredId;
  }
}
