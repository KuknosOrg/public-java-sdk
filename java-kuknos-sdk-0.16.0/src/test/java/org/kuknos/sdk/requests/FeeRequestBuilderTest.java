package org.kuknos.sdk.requests;

import okhttp3.HttpUrl;
import org.junit.Test;
import org.kuknos.sdk.Server;

import static org.junit.Assert.assertEquals;

public class FeeRequestBuilderTest {
    @Test
    public void testBuilder() {
        Server server = new Server("https://horizon-testnet.stellar.org");
        HttpUrl uri = server.feeStats().buildUri();
        assertEquals("https://horizon-testnet.stellar.org/fee_stats", uri.toString());
    }
}
