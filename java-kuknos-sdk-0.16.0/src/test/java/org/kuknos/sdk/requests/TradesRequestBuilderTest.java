package org.kuknos.sdk.requests;

import okhttp3.HttpUrl;
import org.junit.Test;
import org.kuknos.sdk.Asset;
import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.RequestBuilder;

import static org.junit.Assert.assertEquals;

public class TradesRequestBuilderTest {
    @Test
    public void testTrades() {
        Server server = new Server("https://horizon-testnet.stellar.org");
        HttpUrl uri = server.trades()
                .baseAsset(Asset.createNonNativeAsset("EUR", "GAUPA4HERNBDPVO4IUA3MJXBCRRK5W54EVXTDK6IIUTGDQRB6D5W242W"))
                .counterAsset(Asset.createNonNativeAsset("USD", "GDRRHSJMHXDTQBT4JTCILNGF5AS54FEMTXL7KOLMF6TFTHRK6SSUSUZZ"))
                .cursor("13537736921089")
                .limit(200)
                .order(RequestBuilder.Order.ASC)
                .buildUri();

        assertEquals("https://horizon-testnet.stellar.org/trades?" +
                "base_asset_type=credit_alphanum4&" +
                "base_asset_code=EUR&" +
                "base_asset_issuer=GAUPA4HERNBDPVO4IUA3MJXBCRRK5W54EVXTDK6IIUTGDQRB6D5W242W&" +
                "counter_asset_type=credit_alphanum4&" +
                "counter_asset_code=USD&" +
                "counter_asset_issuer=GDRRHSJMHXDTQBT4JTCILNGF5AS54FEMTXL7KOLMF6TFTHRK6SSUSUZZ&" +
                "cursor=13537736921089&" +
                "limit=200&" +
                "order=asc", uri.toString());
    }

    @Test
    public void testTradesForAccount() {
        Server server = new Server("https://horizon-testnet.stellar.org");
        HttpUrl uri = server.trades()
                .forAccount("GDRRHSJMHXDTQBT4JTCILNGF5AS54FEMTXL7KOLMF6TFTHRK6SSUSUZZ")
                .cursor("13537736921089")
                .limit(200)
                .order(RequestBuilder.Order.ASC)
                .buildUri();

        assertEquals("https://horizon-testnet.stellar.org/accounts/GDRRHSJMHXDTQBT4JTCILNGF5AS54FEMTXL7KOLMF6TFTHRK6SSUSUZZ/trades?" +
                "cursor=13537736921089&" +
                "limit=200&" +
                "order=asc", uri.toString());

    }
}
