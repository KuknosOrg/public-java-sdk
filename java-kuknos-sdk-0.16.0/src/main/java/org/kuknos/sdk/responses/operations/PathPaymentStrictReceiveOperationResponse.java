package org.kuknos.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.OperationsRequestBuilder;
import org.kuknos.sdk.Asset;

import java.util.List;

/**
 * Represents PATH_PAYMENT_STRICT_RECEIVE operation response.
 *
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/operation.html" target="_blank">Operation documentation</a>
 * @see OperationsRequestBuilder
 * @see Server#operations()
 */
public class PathPaymentStrictReceiveOperationResponse extends PathPaymentBaseOperationResponse {
  @SerializedName("source_max")
  protected final String sourceMax;

  public PathPaymentStrictReceiveOperationResponse(String amount, String sourceAmount, String sourceMax, String from, String to, String assetType, String assetCode, String assetIssuer, String sourceAssetType, String sourceAssetCode, String sourceAssetIssuer, List<Asset> path) {
    super(amount, sourceAmount, from, to, assetType, assetCode, assetIssuer, sourceAssetType, sourceAssetCode, sourceAssetIssuer, path);
    this.sourceMax = sourceMax;
  }


  public String getSourceMax() {
    return sourceMax;
  }
}