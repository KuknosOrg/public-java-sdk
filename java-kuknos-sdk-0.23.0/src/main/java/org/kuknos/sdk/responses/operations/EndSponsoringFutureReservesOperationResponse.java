package org.kuknos.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.OperationsRequestBuilder;

/**
 * Represents EndSponsoringFutureReserves operation response.
 * @see OperationsRequestBuilder
 * @see Server#operations()
 */
public class EndSponsoringFutureReservesOperationResponse extends OperationResponse {
  @SerializedName("begin_sponsor")
  private final String beginSponsor;

  public EndSponsoringFutureReservesOperationResponse(String beginSponsor) {
    this.beginSponsor = beginSponsor;
  }

  public String getBeginSponsor() {
    return beginSponsor;
  }
}
