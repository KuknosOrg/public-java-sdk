package org.kuknos.sdk;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import org.kuknos.sdk.xdr.ClaimantType;
import org.kuknos.sdk.xdr.CreateClaimableBalanceOp;
import org.kuknos.sdk.xdr.Int64;
import org.kuknos.sdk.xdr.OperationType;
import org.kuknos.sdk.xdr.*;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class CreateClaimableBalanceOperation extends Operation {
  private final String amount;
  private final org.kuknos.sdk.Asset asset;
  private final List<org.kuknos.sdk.Claimant> claimants;


  private CreateClaimableBalanceOperation(String amount, org.kuknos.sdk.Asset asset, List<org.kuknos.sdk.Claimant> claimants) {
    this.asset = checkNotNull(asset, "asset cannot be null");
    this.amount = checkNotNull(amount, "amount cannot be null");
    this.claimants = checkNotNull(claimants, "claimants cannot be null");
    if (this.claimants.isEmpty()) {
      throw new IllegalArgumentException("claimants cannot be empty");
    }
  }

  public org.kuknos.sdk.Asset getAsset() {
    return asset;
  }
  public String getAmount() {
    return amount;
  }
  public List<org.kuknos.sdk.Claimant> getClaimants() {
    return claimants;
  }

  @Override
  org.kuknos.sdk.xdr.Operation.OperationBody toOperationBody() {
    CreateClaimableBalanceOp op = new CreateClaimableBalanceOp();

    // asset
    op.setAsset(asset.toXdr());
    // amount
    Int64 amount = new Int64();
    amount.setInt64(Operation.toXdrAmount(this.amount));
    op.setAmount(amount);

    org.kuknos.sdk.xdr.Claimant[] xdrClaimants = new org.kuknos.sdk.xdr.Claimant[claimants.size()];
    for (int i = 0; i < claimants.size(); i++) {

      org.kuknos.sdk.xdr.Claimant.ClaimantV0 v0 = new org.kuknos.sdk.xdr.Claimant.ClaimantV0();
      v0.setDestination(StrKey.encodeToXDRAccountId(claimants.get(i).getDestination()));
      v0.setPredicate(claimants.get(i).getPredicate().toXdr());

      xdrClaimants[i] = new org.kuknos.sdk.xdr.Claimant();
      xdrClaimants[i].setDiscriminant(ClaimantType.CLAIMANT_TYPE_V0);
      xdrClaimants[i].setV0(v0);
    }
    op.setClaimants(xdrClaimants);

    org.kuknos.sdk.xdr.Operation.OperationBody body = new org.kuknos.sdk.xdr.Operation.OperationBody();
    body.setDiscriminant(OperationType.CREATE_CLAIMABLE_BALANCE);
    body.setCreateClaimableBalanceOp(op);
    return body;
  }

  public static class Builder {
    private final String amount;
    private final org.kuknos.sdk.Asset asset;
    private final List<org.kuknos.sdk.Claimant> claimants;

    private String mSourceAccount;

    /**
     * Construct a new CreateClaimableBalance builder from a CreateClaimableBalance XDR.
     * @param op {@link CreateClaimableBalanceOp}
     */
    Builder(CreateClaimableBalanceOp op) {
      asset = org.kuknos.sdk.Asset.fromXdr(op.getAsset());
      amount = Operation.fromXdrAmount(op.getAmount().getInt64().longValue());
      claimants = Lists.newArrayList();
      for(org.kuknos.sdk.xdr.Claimant c : op.getClaimants()) {
        claimants.add(new org.kuknos.sdk.Claimant(StrKey.encodeStellarAccountId(c.getV0().getDestination()), Predicate.fromXdr(c.getV0().getPredicate())));
      }
    }

    /**
     * Creates a new CreateClaimableBalance builder.
     * @param amount The amount which can be claimed.
     * @param asset The asset which can be claimed/
     * @param claimants The list of entities which can claim the balance.
     */
    public Builder(String amount, Asset asset, List<org.kuknos.sdk.Claimant> claimants) {
      this.amount = amount;
      this.asset = asset;
      this.claimants = claimants;
    }

    /**
     * Sets the source account for this operation.
     * @param sourceAccount The operation's source account.
     * @return Builder object so you can chain methods.
     */
    public CreateClaimableBalanceOperation.Builder setSourceAccount(String sourceAccount) {
      mSourceAccount = checkNotNull(sourceAccount, "sourceAccount cannot be null");
      return this;
    }

    /**
     * Builds an operation
     */
    public CreateClaimableBalanceOperation build() {
      CreateClaimableBalanceOperation operation = new CreateClaimableBalanceOperation(amount, asset, claimants);
      if (mSourceAccount != null) {
        operation.setSourceAccount(mSourceAccount);
      }
      return operation;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.amount, this.asset, this.claimants, this.getSourceAccount());
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof CreateClaimableBalanceOperation)) {
      return false;
    }

    CreateClaimableBalanceOperation other = (CreateClaimableBalanceOperation) object;
    return Objects.equal(this.amount, other.amount) &&
        Objects.equal(this.asset, other.asset) &&
        Objects.equal(this.claimants, other.claimants) &&
        Objects.equal(this.getSourceAccount(), other.getSourceAccount());
  }
}
