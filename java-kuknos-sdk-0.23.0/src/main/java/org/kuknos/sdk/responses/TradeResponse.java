package org.kuknos.sdk.responses;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.TradesRequestBuilder;
import org.kuknos.sdk.Asset;
import org.kuknos.sdk.Price;
;

/**
 * Represents trades response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/endpoints/trades.html" target="_blank">Trades documentation</a>
 * @see TradesRequestBuilder
 * @see Server#trades()
 */
public class TradeResponse extends Response implements Pageable {
    @SerializedName("id")
    private final String id;
    @SerializedName("paging_token")
    private final String pagingToken;
    @SerializedName("ledger_close_time")
    private final String ledgerCloseTime;

    @SerializedName("offer_id")
    private final String offerId;

    @SerializedName("base_is_seller")
    protected final boolean baseIsSeller;

    @SerializedName("base_account")
    protected final String baseAccount;
    @SerializedName("base_offer_id")
    private final String baseOfferId;
    @SerializedName("base_amount")
    protected final String baseAmount;
    @SerializedName("base_asset_type")
    protected final String baseAssetType;
    @SerializedName("base_asset_code")
    protected final String baseAssetCode;
    @SerializedName("base_asset_issuer")
    protected final String baseAssetIssuer;

    @SerializedName("counter_account")
    protected final String counterAccount;
    @SerializedName("counter_offer_id")
    private final String counterOfferId;
    @SerializedName("counter_amount")
    protected final String counterAmount;
    @SerializedName("counter_asset_type")
    protected final String counterAssetType;
    @SerializedName("counter_asset_code")
    protected final String counterAssetCode;
    @SerializedName("counter_asset_issuer")
    protected final String counterAssetIssuer;

    @SerializedName("price")
    protected final Price price;

    @SerializedName("_links")
    private TradeResponse.Links links;

    public TradeResponse(String id, String pagingToken, String ledgerCloseTime, String offerId, boolean baseIsSeller, String baseAccount, String baseOfferId, String baseAmount, String baseAssetType, String baseAssetCode, String baseAssetIssuer, String counterAccount, String counterOfferId, String counterAmount, String counterAssetType, String counterAssetCode, String counterAssetIssuer, Price price) {
        this.id = id;
        this.pagingToken = pagingToken;
        this.ledgerCloseTime = ledgerCloseTime;
        this.offerId = offerId;
        this.baseIsSeller = baseIsSeller;
        this.baseAccount = baseAccount;
        this.baseOfferId = baseOfferId;
        this.baseAmount = baseAmount;
        this.baseAssetType = baseAssetType;
        this.baseAssetCode = baseAssetCode;
        this.baseAssetIssuer = baseAssetIssuer;
        this.counterAccount = counterAccount;
        this.counterOfferId = counterOfferId;
        this.counterAmount = counterAmount;
        this.counterAssetType = counterAssetType;
        this.counterAssetCode = counterAssetCode;
        this.counterAssetIssuer = counterAssetIssuer;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getPagingToken() {
        return pagingToken;
    }

    public String getLedgerCloseTime() {
        return ledgerCloseTime;
    }

    public String getOfferId() {
        return offerId;
    }

    public boolean isBaseSeller() {
        return baseIsSeller;
    }

    public String getBaseOfferId() {
        return baseOfferId;
    }

    public String getBaseAccount() {
        return baseAccount;
    }

    public String getBaseAmount() {
        return baseAmount;
    }

    public Asset getBaseAsset() {
        return Asset.create(this.baseAssetType, this.baseAssetCode, this.baseAssetIssuer);
    }

    public String getBaseAssetType() {
        return baseAssetType;
    }

    public String getBaseAssetCode() {
        return baseAssetCode;
    }

    public String getBaseAssetIssuer() {
        return baseAssetIssuer;
    }

    public String getCounterAccount() {
        return counterAccount;
    }

    public String getCounterOfferId() {
        return counterOfferId;
    }

    public Asset getCounterAsset() {
        return Asset.create(this.counterAssetType, this.counterAssetCode, this.counterAssetIssuer);
    }

    public String getCounterAmount() {
        return counterAmount;
    }

    public String getCounterAssetType() {
        return counterAssetType;
    }

    public String getCounterAssetCode() {
        return counterAssetCode;
    }

    public String getCounterAssetIssuer() {
        return counterAssetIssuer;
    }

    public Price getPrice() {
        return price;
    }

    public Links getLinks() {
        return links;
    }

    /**
     * Links connected to a trade.
     */
    public static class Links {
        @SerializedName("base")
        private final Link base;
        @SerializedName("counter")
        private final Link counter;
        @SerializedName("operation")
        private final Link operation;

        public Links(Link base, Link counter, Link operation) {
            this.base = base;
            this.counter = counter;
            this.operation = operation;
        }

        public Link getBase() {
            return base;
        }

        public Link getCounter() {
            return counter;
        }

        public Link getOperation() {
            return operation;
        }
    }
}
