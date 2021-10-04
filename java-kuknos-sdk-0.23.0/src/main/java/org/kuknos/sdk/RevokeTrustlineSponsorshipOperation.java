package org.kuknos.sdk;

import com.google.common.base.Objects;

import org.kuknos.sdk.xdr.LedgerEntryType;
import org.kuknos.sdk.xdr.LedgerKey;
import org.kuknos.sdk.xdr.OperationType;
import org.kuknos.sdk.xdr.RevokeSponsorshipOp;
import org.kuknos.sdk.xdr.RevokeSponsorshipType;
import org.kuknos.sdk.xdr.*;

import static com.google.common.base.Preconditions.checkNotNull;

public class RevokeTrustlineSponsorshipOperation extends Operation {
  private final String accountId;
  private final org.kuknos.sdk.Asset asset;

  private RevokeTrustlineSponsorshipOperation(String accountId, org.kuknos.sdk.Asset asset) {
    this.accountId = accountId;
    this.asset = asset;
  }

  public String getAccountId() {
    return accountId;
  }

  public org.kuknos.sdk.Asset getAsset() {
    return asset;
  }

  @Override
  org.kuknos.sdk.xdr.Operation.OperationBody toOperationBody() {
    RevokeSponsorshipOp op = new RevokeSponsorshipOp();
    LedgerKey key = new LedgerKey();
    key.setDiscriminant(LedgerEntryType.TRUSTLINE);
    LedgerKey.LedgerKeyTrustLine trustLine = new LedgerKey.LedgerKeyTrustLine();
    trustLine.setAccountID(StrKey.encodeToXDRAccountId(accountId));
    trustLine.setAsset(asset.toXdr());
    key.setTrustLine(trustLine);

    op.setLedgerKey(key);
    op.setDiscriminant(RevokeSponsorshipType.REVOKE_SPONSORSHIP_LEDGER_ENTRY);

    org.kuknos.sdk.xdr.Operation.OperationBody body = new org.kuknos.sdk.xdr.Operation.OperationBody();
    body.setDiscriminant(OperationType.REVOKE_SPONSORSHIP);
    body.setRevokeSponsorshipOp(op);

    return body;
  }

  public static class Builder {
    private final String accountId;
    private final org.kuknos.sdk.Asset asset;

    private String mSourceAccount;

    /**
     * Construct a new RevokeTrustlineSponsorshipOperation builder from a RevokeSponsorship XDR.
     * @param op {@link RevokeSponsorshipOp}
     */
    Builder(RevokeSponsorshipOp op) {
      accountId = StrKey.encodeStellarAccountId(op.getLedgerKey().getTrustLine().getAccountID());
      asset = org.kuknos.sdk.Asset.fromXdr(op.getLedgerKey().getTrustLine().getAsset());
    }

    /**
     * Creates a new RevokeTrustlineSponsorshipOperation builder.
     * @param accountId The id of the account whose trustline will be revoked.
     * @param asset The asset of the trustline which will be revoked.
     */
    public Builder(String accountId, Asset asset) {
      this.accountId = accountId;
      this.asset = asset;
    }

    /**
     * Sets the source account for this operation.
     * @param sourceAccount The operation's source account.
     * @return Builder object so you can chain methods.
     */
    public RevokeTrustlineSponsorshipOperation.Builder setSourceAccount(String sourceAccount) {
      mSourceAccount = checkNotNull(sourceAccount, "sourceAccount cannot be null");
      return this;
    }

    /**
     * Builds an operation
     */
    public RevokeTrustlineSponsorshipOperation build() {
      RevokeTrustlineSponsorshipOperation operation = new RevokeTrustlineSponsorshipOperation(accountId, asset);
      if (mSourceAccount != null) {
        operation.setSourceAccount(mSourceAccount);
      }
      return operation;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.accountId, this.asset, this.getSourceAccount());
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof RevokeTrustlineSponsorshipOperation)) {
      return false;
    }

    RevokeTrustlineSponsorshipOperation other = (RevokeTrustlineSponsorshipOperation) object;
    return Objects.equal(this.accountId, other.accountId) &&
        Objects.equal(this.asset, other.asset) &&
        Objects.equal(this.getSourceAccount(), other.getSourceAccount());
  }
}
