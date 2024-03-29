package org.kuknos.sdk.responses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.kuknos.sdk.responses.operations.AccountMergeOperationResponse;
import org.kuknos.sdk.responses.operations.AllowTrustOperationResponse;
import org.kuknos.sdk.responses.operations.BeginSponsoringFutureReservesOperationResponse;
import org.kuknos.sdk.responses.operations.BumpSequenceOperationResponse;
import org.kuknos.sdk.responses.operations.ChangeTrustOperationResponse;
import org.kuknos.sdk.responses.operations.ClaimClaimableBalanceOperationResponse;
import org.kuknos.sdk.responses.operations.CreateAccountOperationResponse;
import org.kuknos.sdk.responses.operations.CreateClaimableBalanceOperationResponse;
import org.kuknos.sdk.responses.operations.CreatePassiveSellOfferOperationResponse;
import org.kuknos.sdk.responses.operations.EndSponsoringFutureReservesOperationResponse;
import org.kuknos.sdk.responses.operations.InflationOperationResponse;
import org.kuknos.sdk.responses.operations.ManageBuyOfferOperationResponse;
import org.kuknos.sdk.responses.operations.ManageDataOperationResponse;
import org.kuknos.sdk.responses.operations.ManageSellOfferOperationResponse;
import org.kuknos.sdk.responses.operations.OperationResponse;
import org.kuknos.sdk.responses.operations.PathPaymentStrictReceiveOperationResponse;
import org.kuknos.sdk.responses.operations.PathPaymentStrictSendOperationResponse;
import org.kuknos.sdk.responses.operations.PaymentOperationResponse;
import org.kuknos.sdk.responses.operations.RevokeSponsorshipOperationResponse;
import org.kuknos.sdk.responses.operations.SetOptionsOperationResponse;
import org.kuknos.sdk.Asset;
import org.kuknos.sdk.Predicate;
import org.kuknos.sdk.responses.operations.*;
import org.kuknos.sdk.xdr.OperationType;

import java.lang.reflect.Type;

class OperationDeserializer implements JsonDeserializer<OperationResponse> {
  private static final OperationType[] AllOperationTypes = OperationType.values();
  @Override
  public OperationResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    // Create new Gson object with adapters needed in Operation
    Gson gson = new GsonBuilder()
            .registerTypeAdapter(Asset.class, new AssetDeserializer())
            .registerTypeAdapter(Predicate.class, new PredicateDeserializer())
            .registerTypeAdapter(TransactionResponse.class, new TransactionDeserializer())
            .create();

    int type = json.getAsJsonObject().get("type_i").getAsInt();
    if (type < 0 || type >= AllOperationTypes.length) {
      throw new RuntimeException("Invalid operation type");
    }

    switch (AllOperationTypes[type]) {
      case CREATE_ACCOUNT:
        return gson.fromJson(json, CreateAccountOperationResponse.class);
      case PAYMENT:
        return gson.fromJson(json, PaymentOperationResponse.class);
      case PATH_PAYMENT_STRICT_RECEIVE:
        return gson.fromJson(json, PathPaymentStrictReceiveOperationResponse.class);
      case MANAGE_SELL_OFFER:
        return gson.fromJson(json, ManageSellOfferOperationResponse.class);
      case CREATE_PASSIVE_SELL_OFFER:
        return gson.fromJson(json, CreatePassiveSellOfferOperationResponse.class);
      case SET_OPTIONS:
        return gson.fromJson(json, SetOptionsOperationResponse.class);
      case CHANGE_TRUST:
        return gson.fromJson(json, ChangeTrustOperationResponse.class);
      case ALLOW_TRUST:
        return gson.fromJson(json, AllowTrustOperationResponse.class);
      case ACCOUNT_MERGE:
        return gson.fromJson(json, AccountMergeOperationResponse.class);
      case INFLATION:
        return gson.fromJson(json, InflationOperationResponse.class);
      case MANAGE_DATA:
        return gson.fromJson(json, ManageDataOperationResponse.class);
      case BUMP_SEQUENCE:
        return gson.fromJson(json, BumpSequenceOperationResponse.class);
      case MANAGE_BUY_OFFER:
        return gson.fromJson(json, ManageBuyOfferOperationResponse.class);
      case PATH_PAYMENT_STRICT_SEND:
        return gson.fromJson(json, PathPaymentStrictSendOperationResponse.class);
      case CREATE_CLAIMABLE_BALANCE:
        return gson.fromJson(json, CreateClaimableBalanceOperationResponse.class);
      case CLAIM_CLAIMABLE_BALANCE:
        return gson.fromJson(json, ClaimClaimableBalanceOperationResponse.class);
      case BEGIN_SPONSORING_FUTURE_RESERVES:
        return gson.fromJson(json, BeginSponsoringFutureReservesOperationResponse.class);
      case END_SPONSORING_FUTURE_RESERVES:
        return gson.fromJson(json, EndSponsoringFutureReservesOperationResponse.class);
      case REVOKE_SPONSORSHIP:
        return gson.fromJson(json, RevokeSponsorshipOperationResponse.class);
      default:
        throw new RuntimeException("Invalid operation type");
    }
  }
}
