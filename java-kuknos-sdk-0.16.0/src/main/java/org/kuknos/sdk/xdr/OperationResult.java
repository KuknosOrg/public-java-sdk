// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union OperationResult switch (OperationResultCode code)
//  {
//  case opINNER:
//      union switch (OperationType type)
//      {
//      case CREATE_ACCOUNT:
//          CreateAccountResult createAccountResult;
//      case PAYMENT:
//          PaymentResult paymentResult;
//      case PATH_PAYMENT_STRICT_RECEIVE:
//          PathPaymentStrictReceiveResult pathPaymentStrictReceiveResult;
//      case MANAGE_SELL_OFFER:
//          ManageSellOfferResult manageSellOfferResult;
//      case CREATE_PASSIVE_SELL_OFFER:
//          ManageSellOfferResult createPassiveSellOfferResult;
//      case SET_OPTIONS:
//          SetOptionsResult setOptionsResult;
//      case CHANGE_TRUST:
//          ChangeTrustResult changeTrustResult;
//      case ALLOW_TRUST:
//          AllowTrustResult allowTrustResult;
//      case ACCOUNT_MERGE:
//          AccountMergeResult accountMergeResult;
//      case INFLATION:
//          InflationResult inflationResult;
//      case MANAGE_DATA:
//          ManageDataResult manageDataResult;
//      case BUMP_SEQUENCE:
//          BumpSequenceResult bumpSeqResult;
//      case MANAGE_BUY_OFFER:
//          ManageBuyOfferResult manageBuyOfferResult;
//      case PATH_PAYMENT_STRICT_SEND:
//          PathPaymentStrictSendResult pathPaymentStrictSendResult;
//      }
//      tr;
//  default:
//      void;
//  };

//  ===========================================================================
public class OperationResult implements XdrElement {
  public OperationResult () {}
  OperationResultCode code;
  public OperationResultCode getDiscriminant() {
    return this.code;
  }
  public void setDiscriminant(OperationResultCode value) {
    this.code = value;
  }
  private OperationResultTr tr;
  public OperationResultTr getTr() {
    return this.tr;
  }
  public void setTr(OperationResultTr value) {
    this.tr = value;
  }
  public static void encode(XdrDataOutputStream stream, OperationResult encodedOperationResult) throws IOException {
  //Xdrgen::AST::Identifier
  //OperationResultCode
  stream.writeInt(encodedOperationResult.getDiscriminant().getValue());
  switch (encodedOperationResult.getDiscriminant()) {
  case opINNER:
  OperationResultTr.encode(stream, encodedOperationResult.tr);
  break;
  default:
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static OperationResult decode(XdrDataInputStream stream) throws IOException {
  OperationResult decodedOperationResult = new OperationResult();
  OperationResultCode discriminant = OperationResultCode.decode(stream);
  decodedOperationResult.setDiscriminant(discriminant);
  switch (decodedOperationResult.getDiscriminant()) {
  case opINNER:
  decodedOperationResult.tr = OperationResultTr.decode(stream);
  break;
  default:
  break;
  }
    return decodedOperationResult;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.tr, this.code);
  }
  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof OperationResult)) {
      return false;
    }

    OperationResult other = (OperationResult) object;
    return Objects.equal(this.tr, other.tr) && Objects.equal(this.code, other.code);
  }

  public static class OperationResultTr {
    public OperationResultTr () {}
    OperationType type;
    public OperationType getDiscriminant() {
      return this.type;
    }
    public void setDiscriminant(OperationType value) {
      this.type = value;
    }
    private CreateAccountResult createAccountResult;
    public CreateAccountResult getCreateAccountResult() {
      return this.createAccountResult;
    }
    public void setCreateAccountResult(CreateAccountResult value) {
      this.createAccountResult = value;
    }
    private PaymentResult paymentResult;
    public PaymentResult getPaymentResult() {
      return this.paymentResult;
    }
    public void setPaymentResult(PaymentResult value) {
      this.paymentResult = value;
    }
    private PathPaymentStrictReceiveResult pathPaymentStrictReceiveResult;
    public PathPaymentStrictReceiveResult getPathPaymentStrictReceiveResult() {
      return this.pathPaymentStrictReceiveResult;
    }
    public void setPathPaymentStrictReceiveResult(PathPaymentStrictReceiveResult value) {
      this.pathPaymentStrictReceiveResult = value;
    }
    private ManageSellOfferResult manageSellOfferResult;
    public ManageSellOfferResult getManageSellOfferResult() {
      return this.manageSellOfferResult;
    }
    public void setManageSellOfferResult(ManageSellOfferResult value) {
      this.manageSellOfferResult = value;
    }
    private ManageSellOfferResult createPassiveSellOfferResult;
    public ManageSellOfferResult getCreatePassiveSellOfferResult() {
      return this.createPassiveSellOfferResult;
    }
    public void setCreatePassiveSellOfferResult(ManageSellOfferResult value) {
      this.createPassiveSellOfferResult = value;
    }
    private SetOptionsResult setOptionsResult;
    public SetOptionsResult getSetOptionsResult() {
      return this.setOptionsResult;
    }
    public void setSetOptionsResult(SetOptionsResult value) {
      this.setOptionsResult = value;
    }
    private ChangeTrustResult changeTrustResult;
    public ChangeTrustResult getChangeTrustResult() {
      return this.changeTrustResult;
    }
    public void setChangeTrustResult(ChangeTrustResult value) {
      this.changeTrustResult = value;
    }
    private AllowTrustResult allowTrustResult;
    public AllowTrustResult getAllowTrustResult() {
      return this.allowTrustResult;
    }
    public void setAllowTrustResult(AllowTrustResult value) {
      this.allowTrustResult = value;
    }
    private AccountMergeResult accountMergeResult;
    public AccountMergeResult getAccountMergeResult() {
      return this.accountMergeResult;
    }
    public void setAccountMergeResult(AccountMergeResult value) {
      this.accountMergeResult = value;
    }
    private InflationResult inflationResult;
    public InflationResult getInflationResult() {
      return this.inflationResult;
    }
    public void setInflationResult(InflationResult value) {
      this.inflationResult = value;
    }
    private ManageDataResult manageDataResult;
    public ManageDataResult getManageDataResult() {
      return this.manageDataResult;
    }
    public void setManageDataResult(ManageDataResult value) {
      this.manageDataResult = value;
    }
    private BumpSequenceResult bumpSeqResult;
    public BumpSequenceResult getBumpSeqResult() {
      return this.bumpSeqResult;
    }
    public void setBumpSeqResult(BumpSequenceResult value) {
      this.bumpSeqResult = value;
    }
    private ManageBuyOfferResult manageBuyOfferResult;
    public ManageBuyOfferResult getManageBuyOfferResult() {
      return this.manageBuyOfferResult;
    }
    public void setManageBuyOfferResult(ManageBuyOfferResult value) {
      this.manageBuyOfferResult = value;
    }
    private PathPaymentStrictSendResult pathPaymentStrictSendResult;
    public PathPaymentStrictSendResult getPathPaymentStrictSendResult() {
      return this.pathPaymentStrictSendResult;
    }
    public void setPathPaymentStrictSendResult(PathPaymentStrictSendResult value) {
      this.pathPaymentStrictSendResult = value;
    }
    public static void encode(XdrDataOutputStream stream, OperationResultTr encodedOperationResultTr) throws IOException {
    //Xdrgen::AST::Identifier
    //OperationType
    stream.writeInt(encodedOperationResultTr.getDiscriminant().getValue());
    switch (encodedOperationResultTr.getDiscriminant()) {
    case CREATE_ACCOUNT:
    CreateAccountResult.encode(stream, encodedOperationResultTr.createAccountResult);
    break;
    case PAYMENT:
    PaymentResult.encode(stream, encodedOperationResultTr.paymentResult);
    break;
    case PATH_PAYMENT_STRICT_RECEIVE:
    PathPaymentStrictReceiveResult.encode(stream, encodedOperationResultTr.pathPaymentStrictReceiveResult);
    break;
    case MANAGE_SELL_OFFER:
    ManageSellOfferResult.encode(stream, encodedOperationResultTr.manageSellOfferResult);
    break;
    case CREATE_PASSIVE_SELL_OFFER:
    ManageSellOfferResult.encode(stream, encodedOperationResultTr.createPassiveSellOfferResult);
    break;
    case SET_OPTIONS:
    SetOptionsResult.encode(stream, encodedOperationResultTr.setOptionsResult);
    break;
    case CHANGE_TRUST:
    ChangeTrustResult.encode(stream, encodedOperationResultTr.changeTrustResult);
    break;
    case ALLOW_TRUST:
    AllowTrustResult.encode(stream, encodedOperationResultTr.allowTrustResult);
    break;
    case ACCOUNT_MERGE:
    AccountMergeResult.encode(stream, encodedOperationResultTr.accountMergeResult);
    break;
    case INFLATION:
    InflationResult.encode(stream, encodedOperationResultTr.inflationResult);
    break;
    case MANAGE_DATA:
    ManageDataResult.encode(stream, encodedOperationResultTr.manageDataResult);
    break;
    case BUMP_SEQUENCE:
    BumpSequenceResult.encode(stream, encodedOperationResultTr.bumpSeqResult);
    break;
    case MANAGE_BUY_OFFER:
    ManageBuyOfferResult.encode(stream, encodedOperationResultTr.manageBuyOfferResult);
    break;
    case PATH_PAYMENT_STRICT_SEND:
    PathPaymentStrictSendResult.encode(stream, encodedOperationResultTr.pathPaymentStrictSendResult);
    break;
    }
    }
    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }
    public static OperationResultTr decode(XdrDataInputStream stream) throws IOException {
    OperationResultTr decodedOperationResultTr = new OperationResultTr();
    OperationType discriminant = OperationType.decode(stream);
    decodedOperationResultTr.setDiscriminant(discriminant);
    switch (decodedOperationResultTr.getDiscriminant()) {
    case CREATE_ACCOUNT:
    decodedOperationResultTr.createAccountResult = CreateAccountResult.decode(stream);
    break;
    case PAYMENT:
    decodedOperationResultTr.paymentResult = PaymentResult.decode(stream);
    break;
    case PATH_PAYMENT_STRICT_RECEIVE:
    decodedOperationResultTr.pathPaymentStrictReceiveResult = PathPaymentStrictReceiveResult.decode(stream);
    break;
    case MANAGE_SELL_OFFER:
    decodedOperationResultTr.manageSellOfferResult = ManageSellOfferResult.decode(stream);
    break;
    case CREATE_PASSIVE_SELL_OFFER:
    decodedOperationResultTr.createPassiveSellOfferResult = ManageSellOfferResult.decode(stream);
    break;
    case SET_OPTIONS:
    decodedOperationResultTr.setOptionsResult = SetOptionsResult.decode(stream);
    break;
    case CHANGE_TRUST:
    decodedOperationResultTr.changeTrustResult = ChangeTrustResult.decode(stream);
    break;
    case ALLOW_TRUST:
    decodedOperationResultTr.allowTrustResult = AllowTrustResult.decode(stream);
    break;
    case ACCOUNT_MERGE:
    decodedOperationResultTr.accountMergeResult = AccountMergeResult.decode(stream);
    break;
    case INFLATION:
    decodedOperationResultTr.inflationResult = InflationResult.decode(stream);
    break;
    case MANAGE_DATA:
    decodedOperationResultTr.manageDataResult = ManageDataResult.decode(stream);
    break;
    case BUMP_SEQUENCE:
    decodedOperationResultTr.bumpSeqResult = BumpSequenceResult.decode(stream);
    break;
    case MANAGE_BUY_OFFER:
    decodedOperationResultTr.manageBuyOfferResult = ManageBuyOfferResult.decode(stream);
    break;
    case PATH_PAYMENT_STRICT_SEND:
    decodedOperationResultTr.pathPaymentStrictSendResult = PathPaymentStrictSendResult.decode(stream);
    break;
    }
      return decodedOperationResultTr;
    }
    @Override
    public int hashCode() {
      return Objects.hashCode(this.createAccountResult, this.paymentResult, this.pathPaymentStrictReceiveResult, this.manageSellOfferResult, this.createPassiveSellOfferResult, this.setOptionsResult, this.changeTrustResult, this.allowTrustResult, this.accountMergeResult, this.inflationResult, this.manageDataResult, this.bumpSeqResult, this.manageBuyOfferResult, this.pathPaymentStrictSendResult, this.type);
    }
    @Override
    public boolean equals(Object object) {
      if (object == null || !(object instanceof OperationResultTr)) {
        return false;
      }

      OperationResultTr other = (OperationResultTr) object;
      return Objects.equal(this.createAccountResult, other.createAccountResult) && Objects.equal(this.paymentResult, other.paymentResult) && Objects.equal(this.pathPaymentStrictReceiveResult, other.pathPaymentStrictReceiveResult) && Objects.equal(this.manageSellOfferResult, other.manageSellOfferResult) && Objects.equal(this.createPassiveSellOfferResult, other.createPassiveSellOfferResult) && Objects.equal(this.setOptionsResult, other.setOptionsResult) && Objects.equal(this.changeTrustResult, other.changeTrustResult) && Objects.equal(this.allowTrustResult, other.allowTrustResult) && Objects.equal(this.accountMergeResult, other.accountMergeResult) && Objects.equal(this.inflationResult, other.inflationResult) && Objects.equal(this.manageDataResult, other.manageDataResult) && Objects.equal(this.bumpSeqResult, other.bumpSeqResult) && Objects.equal(this.manageBuyOfferResult, other.manageBuyOfferResult) && Objects.equal(this.pathPaymentStrictSendResult, other.pathPaymentStrictSendResult) && Objects.equal(this.type, other.type);
    }

  }
}
