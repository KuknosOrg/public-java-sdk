package org.kuknos.sdk.responses;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.OffersRequestBuilder;
import org.kuknos.sdk.Asset;

/**
 * Represents offer response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/offer.html" target="_blank">Offer documentation</a>
 * @see OffersRequestBuilder
 * @see Server#offers()
 */
public class OfferResponse extends Response implements Pageable {
  @SerializedName("id")
  private final Long id;
  @SerializedName("paging_token")
  private final String pagingToken;
  @SerializedName("seller")
  private final String seller;
  @SerializedName("selling")
  private final Asset selling;
  @SerializedName("buying")
  private final Asset buying;
  @SerializedName("amount")
  private final String amount;
  @SerializedName("price_r")
  private final Price_r price_r;
  @SerializedName("price")
  private final String price;
  @SerializedName("last_modified_ledger")
  private final Integer lastModifiedLedger;
  @SerializedName("last_modified_time")
  private final String lastModifiedTime;
  @SerializedName("_links")
  private final Links links;

  public OfferResponse(Long id, String pagingToken, String seller, Asset selling, Asset buying, String amount,Price_r price_r, String price, Integer lastModifiedLedger, String lastModifiedTime, Links links) {
    this.id = id;
    this.pagingToken = pagingToken;
    this.seller = seller;
    this.selling = selling;
    this.buying = buying;
    this.amount = amount;
    this.price_r = price_r;
    this.price = price;
    this.lastModifiedLedger = lastModifiedLedger;
    this.lastModifiedTime = lastModifiedTime;
    this.links = links;
  }

  public Long getId() {
    return id;
  }

  public String getPagingToken() {
    return pagingToken;
  }

  public String getSeller() {
    return seller;
  }

  public Asset getSelling() {
    return selling;
  }

  public Asset getBuying() {
    return buying;
  }

  public String getAmount() {
    return amount;
  }

  public Price_r getPrice_r() {
    return price_r;
  }

  public String getPrice() {
    return price;
  }

  public Integer getLastModifiedLedger() {
    return lastModifiedLedger;
  }

  // Can be null if ledger adding an offer has not been ingested yet.
  public String getLastModifiedTime() {
    return lastModifiedTime;
  }

  public Links getLinks() {
    return links;
  }

  /**
   * Links connected to ledger.
   */
  public static class Links {
    @SerializedName("self")
    private final Link self;
    @SerializedName("offer_maker")
    private final Link offerMaker;

    public Links(Link self, Link offerMaker) {
      this.self = self;
      this.offerMaker = offerMaker;
    }

    public Link getSelf() {
      return self;
    }

    public Link getOfferMaker() {
      return offerMaker;
    }
  }

  public static class Price_r{
    @SerializedName("n")
    private int n;
    @SerializedName("d")
    private int d;

    public Price_r(int n, int d) {
      this.n = n;
      this.d = d;
    }

    public int getN() {
      return n;
    }

    public void setN(int n) {
      this.n = n;
    }

    public int getD() {
      return d;
    }

    public void setD(int d) {
      this.d = d;
    }
  }
}
