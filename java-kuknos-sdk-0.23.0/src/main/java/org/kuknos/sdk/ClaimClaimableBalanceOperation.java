package org.kuknos.sdk;

import com.google.common.base.Objects;
import com.google.common.io.BaseEncoding;

import org.kuknos.sdk.xdr.ClaimClaimableBalanceOp;
import org.kuknos.sdk.xdr.ClaimableBalanceID;
import org.kuknos.sdk.xdr.OperationType;
import org.kuknos.sdk.xdr.XdrDataInputStream;
import org.kuknos.sdk.xdr.XdrDataOutputStream;
import org.kuknos.sdk.xdr.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.google.common.base.Preconditions.checkNotNull;

public class ClaimClaimableBalanceOperation extends Operation {
  private final String balanceId;


  private ClaimClaimableBalanceOperation(String balanceId) {
    this.balanceId = checkNotNull(balanceId, "balanceId cannot be null");
  }

  public String getBalanceId() {
    return balanceId;
  }

  @Override
  org.kuknos.sdk.xdr.Operation.OperationBody toOperationBody() {
    ClaimClaimableBalanceOp op = new ClaimClaimableBalanceOp();

    byte[] balanceIdBytes = BaseEncoding.base16().lowerCase().decode(balanceId.toLowerCase());
    XdrDataInputStream balanceIdXdrDataInputStream = new XdrDataInputStream(new ByteArrayInputStream(balanceIdBytes));
    ClaimableBalanceID id;
    try {
      id = ClaimableBalanceID.decode(balanceIdXdrDataInputStream);
    } catch (IOException e) {
      throw new IllegalArgumentException("invalid balanceId: " + balanceId, e);
    }

    op.setBalanceID(id);
    org.kuknos.sdk.xdr.Operation.OperationBody body = new org.kuknos.sdk.xdr.Operation.OperationBody();
    body.setDiscriminant(OperationType.CLAIM_CLAIMABLE_BALANCE);
    body.setClaimClaimableBalanceOp(op);
    return body;
  }

  public static class Builder {
    private final String balanceId;

    private String mSourceAccount;

    /**
     * Construct a new ClaimClaimableBalance builder from a ClaimClaimableBalance XDR.
     * @param op {@link ClaimClaimableBalanceOp}
     */
    Builder(ClaimClaimableBalanceOp op) {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
      try {
        op.getBalanceID().encode(xdrDataOutputStream);
      } catch (IOException e) {
        throw new IllegalArgumentException("invalid claimClaimableBalanceOp.", e);
      }
      balanceId = BaseEncoding.base16().lowerCase().encode(byteArrayOutputStream.toByteArray());
    }

    /**
     * Creates a new ClaimClaimableBalance builder.
     * @param balanceId The id of the claimable balance.
     */
    public Builder(String balanceId) {
      this.balanceId = balanceId;
    }

    /**
     * Sets the source account for this operation.
     * @param sourceAccount The operation's source account.
     * @return Builder object so you can chain methods.
     */
    public ClaimClaimableBalanceOperation.Builder setSourceAccount(String sourceAccount) {
      mSourceAccount = checkNotNull(sourceAccount, "sourceAccount cannot be null");
      return this;
    }

    /**
     * Builds an operation
     */
    public ClaimClaimableBalanceOperation build() {
      ClaimClaimableBalanceOperation operation = new ClaimClaimableBalanceOperation(balanceId);
      if (mSourceAccount != null) {
        operation.setSourceAccount(mSourceAccount);
      }
      return operation;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.balanceId, this.getSourceAccount());
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof ClaimClaimableBalanceOperation)) {
      return false;
    }

    ClaimClaimableBalanceOperation other = (ClaimClaimableBalanceOperation) object;
    return Objects.equal(this.balanceId, other.balanceId) &&
        Objects.equal(this.getSourceAccount(), other.getSourceAccount());
  }

}
