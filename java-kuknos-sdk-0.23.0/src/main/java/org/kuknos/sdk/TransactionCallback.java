package org.kuknos.sdk;


import org.kuknos.sdk.responses.SubmitTransactionResponse;

public interface TransactionCallback {
    public void callback(SubmitTransactionResponse.Extras.ResultCodes resultCodes, String transaction);
}
