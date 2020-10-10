package org.kuknos.sdk;

import com.google.common.base.Objects;

import org.kuknos.sdk.xdr.Int64;
import org.kuknos.sdk.xdr.OperationType;
import org.kuknos.sdk.xdr.PaymentOp;


import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents <a href="https://www.stellar.org/developers/learn/concepts/list-of-operations.html#payment" target="_blank">Payment</a> operation.
 * @see <a href="https://www.stellar.org/developers/learn/concepts/list-of-operations.html" target="_blank">List of Operations</a>
 */
public class PaymentOperation extends Operation {

  private final String destination;
  private final Asset asset;
  private final String amount;

  private PaymentOperation(String destination, Asset asset, String amount) {
    this.destination = checkNotNull(destination, "destination cannot be null");
    this.asset = checkNotNull(asset, "asset cannot be null");
    this.amount = checkNotNull(amount, "amount cannot be null");
  }

  /**
   * Account that receives the payment.
   */
  public String getDestination() {
    return destination;
  }

  /**
   * Asset to send to the destination account.
   */
  public Asset getAsset() {
    return asset;
  }

  /**
   * Amount of the asset to send.
   */
  public String getAmount() {
    return amount;
  }

  @Override
  org.kuknos.sdk.xdr.Operation.OperationBody toOperationBody() {
    PaymentOp op = new PaymentOp();

    // destination
    op.setDestination(StrKey.encodeToXDRMuxedAccount(this.destination));
    // asset
    op.setAsset(asset.toXdr());
    // amount
    Int64 amount = new Int64();
    amount.setInt64(toXdrAmount(this.amount));
    op.setAmount(amount);

    org.kuknos.sdk.xdr.Operation.OperationBody body = new org.kuknos.sdk.xdr.Operation.OperationBody();
    body.setDiscriminant(OperationType.PAYMENT);
    body.setPaymentOp(op);
    return body;
  }

  /**
   * Builds Payment operation.
   * @see PathPaymentOperation
   */
  public static class Builder {
    private final String destination;
    private final Asset asset;
    private final String amount;

    private String mSourceAccount;

    /**
     * Construct a new PaymentOperation builder from a PaymentOp XDR.
     * @param op {@link PaymentOp}
     */
    Builder(PaymentOp op) {
      destination = StrKey.encodeStellarMuxedAccount(op.getDestination());
      asset = Asset.fromXdr(op.getAsset());
      amount = fromXdrAmount(op.getAmount().getInt64().longValue());
    }

    /**
     * Creates a new PaymentOperation builder.
     * @param destination The destination account id
     * @param asset The asset to send.
     * @param amount The amount to send in lumens.
     * @throws ArithmeticException when amount has more than 7 decimal places.
     */
    public Builder(String destination, Asset asset, String amount) {
      this.destination = destination;
      this.asset = asset;
      this.amount = amount;
    }

    /**
     * Sets the source account for this operation.
     * @param account The operation's source account.
     * @return Builder object so you can chain methods.
     */
    public Builder setSourceAccount(String account) {
      mSourceAccount = account;
      return this;
    }

    /**
     * Builds an operation
     */
    public PaymentOperation build() {
      PaymentOperation operation = new PaymentOperation(destination, asset, amount);
      if (mSourceAccount != null) {
        operation.setSourceAccount(mSourceAccount);
      }
      return operation;
    }
  }

  public int hashCode() {
    return Objects.hashCode(
            this.getSourceAccount(),
            this.asset,
            this.amount,
            this.destination
    );
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof PaymentOperation)) {
      return false;
    }

    PaymentOperation other = (PaymentOperation) object;
    return Objects.equal(this.getSourceAccount(), other.getSourceAccount()) &&
            Objects.equal(this.asset, other.asset) &&
            Objects.equal(this.amount, other.amount) &&
            Objects.equal(this.destination, other.destination);
  }
}
