package org.kuknos.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.OperationsRequestBuilder;

/**
 * Represents BumpSequence operation response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/operation.html" target="_blank">Operation documentation</a>
 * @see OperationsRequestBuilder
 * @see Server#operations()
 */
public class BumpSequenceOperationResponse extends OperationResponse {
    @SerializedName("bump_to")
    protected final Long bumpTo;

    public BumpSequenceOperationResponse(Long bumpTo) {
        this.bumpTo = bumpTo;
    }

    public Long getBumpTo() {
        return bumpTo;
    }
}
