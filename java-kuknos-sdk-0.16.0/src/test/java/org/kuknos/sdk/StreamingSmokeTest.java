package org.kuknos.sdk;

import com.google.common.base.Optional;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EventListener;
import org.kuknos.sdk.requests.SSEStream;
import org.kuknos.sdk.responses.TradeResponse;

import java.util.concurrent.atomic.AtomicInteger;

public class StreamingSmokeTest {

  @Test
  @Ignore // lets not run this by default for now
  public void shouldStreamPaymentsFromTestNet() {
    final AtomicInteger events = new AtomicInteger();
    Server server = new Server("https://horizon-testnet.stellar.org/");
    SSEStream<TradeResponse> manager = null;
    try {
        manager = server.trades().limit(100).stream(new EventListener<TradeResponse>() {
          @Override
          public void onEvent(TradeResponse r) {
            events.incrementAndGet();
          }
          @Override
          public void onFailure(Optional<Throwable> error, Optional<Integer> responseCode) {
          }
        });

        try {
          Thread.sleep(30000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        manager.close();
      int eventCount = events.get();
      Assert.assertTrue(eventCount >0);

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      Assert.assertTrue(events.get() == eventCount);

    } finally {
      if(manager != null) {
        manager.close();
      }
    }
  }
}
