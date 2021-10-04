package org.stellar.sdk.xdr;

import org.junit.Test;
import org.kuknos.sdk.InflationOperation;

import static org.junit.Assert.assertTrue;

import org.kuknos.sdk.Operation;
import org.kuknos.sdk.Transaction;
import org.kuknos.sdk.Network;


public class InflationDecodeTest {

    @Test
    public void testDecodeInflationOperation() throws Exception {
        Transaction tx = (Transaction) Transaction.fromEnvelopeXdr(
                "AAAAAALC+FwxReetNDfMNvY5LOS1qSe7QqrfQPS28dnIV95NAAAAZAAAAAAAAATSAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQAAAAAAAAAJAAAAAAAAAAA=",
                 Network.TESTNET
        );
        Operation[] ops = tx.getOperations();
        assertTrue(ops[0] instanceof InflationOperation);
    }
}
