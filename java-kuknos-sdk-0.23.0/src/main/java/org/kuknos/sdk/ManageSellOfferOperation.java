package org.kuknos.sdk;

import com.google.common.base.Objects;

import org.kuknos.sdk.xdr.Int64;
import org.kuknos.sdk.xdr.ManageSellOfferOp;
import org.kuknos.sdk.xdr.OperationType;
import org.kuknos.sdk.xdr.*;


import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents <a href="https://www.stellar.org/developers/learn/concepts/list-of-operations.html#manage-sell-offer" target="_blank">ManageSellOffer</a> operation.
 * @see <a href="https://www.stellar.org/developers/learn/concepts/list-of-operations.html" target="_blank">List of Operations</a>
 */
public class ManageSellOfferOperation extends Operation {

    private final org.kuknos.sdk.Asset selling;
    private final org.kuknos.sdk.Asset buying;
    private final String amount;
    private final String price;
    private final long offerId;

    private ManageSellOfferOperation(org.kuknos.sdk.Asset selling, org.kuknos.sdk.Asset buying, String amount, String price, long offerId) {
        this.selling = checkNotNull(selling, "selling cannot be null");
        this.buying = checkNotNull(buying, "buying cannot be null");
        this.amount = checkNotNull(amount, "amount cannot be null");
        this.price = checkNotNull(price, "price cannot be null");
        // offerId can be null
        this.offerId = offerId;
    }

    /**
     * The asset being sold in this operation
     */
    public org.kuknos.sdk.Asset getSelling() {
        return selling;
    }

    /**
     * The asset being bought in this operation
     */
    public org.kuknos.sdk.Asset getBuying() {
        return buying;
    }

    /**
     * Amount of selling being sold.
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Price of 1 unit of selling in terms of buying.
     */
    public String getPrice() {
        return price;
    }

    /**
     * The ID of the offer.
     */
    public long getOfferId() {
        return offerId;
    }

    @Override
    org.kuknos.sdk.xdr.Operation.OperationBody toOperationBody() {
        ManageSellOfferOp op = new ManageSellOfferOp();
        op.setSelling(selling.toXdr());
        op.setBuying(buying.toXdr());
        Int64 amount = new Int64();
        amount.setInt64(Operation.toXdrAmount(this.amount));
        op.setAmount(amount);
        Price price = Price.fromString(this.price);
        op.setPrice(price.toXdr());
        Int64 offerId = new Int64();
        offerId.setInt64(Long.valueOf(this.offerId));
        op.setOfferID(offerId);

        org.kuknos.sdk.xdr.Operation.OperationBody body = new org.kuknos.sdk.xdr.Operation.OperationBody();
        body.setDiscriminant(OperationType.MANAGE_SELL_OFFER);
        body.setManageSellOfferOp(op);

        return body;
    }

    /**
     * Builds ManageSellOffer operation. If you want to update existing offer use
     * {@link ManageSellOfferOperation.Builder#setOfferId(long)}.
     * @see ManageSellOfferOperation
     */
    public static class Builder {

        private final org.kuknos.sdk.Asset selling;
        private final org.kuknos.sdk.Asset buying;
        private final String amount;
        private final String price;
        private long offerId = 0;

        private String mSourceAccount;

        /**
         * Construct a new ManageSellOffer builder from a ManageSellOfferOp XDR.
         * @param op {@link ManageSellOfferOp}
         */
        Builder(ManageSellOfferOp op) {
            selling = org.kuknos.sdk.Asset.fromXdr(op.getSelling());
            buying = org.kuknos.sdk.Asset.fromXdr(op.getBuying());
            amount = Operation.fromXdrAmount(op.getAmount().getInt64().longValue());
            price = Price.fromXdr(op.getPrice()).toString();
            offerId = op.getOfferID().getInt64().longValue();
        }

        /**
         * Creates a new ManageSellOffer builder. If you want to update existing offer use
         * {@link ManageSellOfferOperation.Builder#setOfferId(long)}.
         * @param selling The asset being sold in this operation
         * @param buying The asset being bought in this operation
         * @param amount Amount of selling being sold.
         * @param price Price of 1 unit of selling in terms of buying.
         * @throws ArithmeticException when amount has more than 7 decimal places.
         */
        public Builder(org.kuknos.sdk.Asset selling, Asset buying, String amount, String price) {
            this.selling = checkNotNull(selling, "selling cannot be null");
            this.buying = checkNotNull(buying, "buying cannot be null");
            this.amount = checkNotNull(amount, "amount cannot be null");
            this.price = checkNotNull(price, "price cannot be null");
        }

        /**
         * Sets offer ID. <code>0</code> creates a new offer. Set to existing offer ID to change it.
         * @param offerId
         */
        public Builder setOfferId(long offerId) {
            this.offerId = offerId;
            return this;
        }

        /**
         * Sets the source account for this operation.
         * @param sourceAccount The operation's source account.
         * @return Builder object so you can chain methods.
         */
        public Builder setSourceAccount(String sourceAccount) {
            mSourceAccount = checkNotNull(sourceAccount, "sourceAccount cannot be null");
            return this;
        }

        /**
         * Builds an operation
         */
        public ManageSellOfferOperation build() {
            ManageSellOfferOperation operation = new ManageSellOfferOperation(selling, buying, amount, price, offerId);
            if (mSourceAccount != null) {
                operation.setSourceAccount(mSourceAccount);
            }
            return operation;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                this.getSourceAccount(),
                this.amount,
                this.buying,
                this.offerId,
                this.price,
                this.selling
        );
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof ManageSellOfferOperation)) {
            return false;
        }

        ManageSellOfferOperation other = (ManageSellOfferOperation) object;
        return Objects.equal(this.getSourceAccount(), other.getSourceAccount()) &&
                Objects.equal(this.amount, other.amount) &&
                Objects.equal(this.buying, other.buying) &&
                Objects.equal(this.offerId, other.offerId) &&
                Objects.equal(this.price, other.price) &&
                Objects.equal(this.selling, other.selling);

    }

}
