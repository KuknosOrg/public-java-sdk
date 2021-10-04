package org.kuknos.sdk.responses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.kuknos.sdk.responses.effects.AccountCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.AccountCreditedEffectResponse;
import org.kuknos.sdk.responses.effects.AccountDebitedEffectResponse;
import org.kuknos.sdk.responses.effects.AccountFlagsUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.AccountHomeDomainUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.AccountInflationDestinationUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.AccountRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.AccountSponsorshipCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.AccountSponsorshipRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.AccountSponsorshipUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.AccountThresholdsUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.ClaimableBalanceClaimantCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.ClaimableBalanceClaimedEffectResponse;
import org.kuknos.sdk.responses.effects.ClaimableBalanceCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.ClaimableBalanceSponsorshipCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.ClaimableBalanceSponsorshipRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.ClaimableBalanceSponsorshipUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.DataCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.DataRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.DataSponsorshipCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.DataSponsorshipRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.DataSponsorshipUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.DataUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.EffectResponse;
import org.kuknos.sdk.responses.effects.OfferCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.OfferRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.OfferUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.SequenceBumpedEffectResponse;
import org.kuknos.sdk.responses.effects.SignerCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.SignerRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.SignerSponsorshipCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.SignerSponsorshipRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.SignerSponsorshipUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.SignerUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.TradeEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineAuthorizedEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineAuthorizedToMaintainLiabilitiesEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineDeauthorizedEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineSponsorshipCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineSponsorshipRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineSponsorshipUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineUpdatedEffectResponse;
import org.kuknos.sdk.Asset;
import org.kuknos.sdk.Predicate;
import org.kuknos.sdk.responses.effects.*;

import java.lang.reflect.Type;

class EffectDeserializer implements JsonDeserializer<EffectResponse> {
  @Override
  public EffectResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    // Create new Gson object with adapters needed in Operation
    Gson gson = new GsonBuilder()
        .registerTypeAdapter(Asset.class, new AssetDeserializer())
        .registerTypeAdapter(Predicate.class, new PredicateDeserializer())
        .create();


    int type = json.getAsJsonObject().get("type_i").getAsInt();
    switch (type) {
      // Account effects
      case 0:
        return gson.fromJson(json, AccountCreatedEffectResponse.class);
      case 1:
        return gson.fromJson(json, AccountRemovedEffectResponse.class);
      case 2:
        return gson.fromJson(json, AccountCreditedEffectResponse.class);
      case 3:
        return gson.fromJson(json, AccountDebitedEffectResponse.class);
      case 4:
        return gson.fromJson(json, AccountThresholdsUpdatedEffectResponse.class);
      case 5:
        return gson.fromJson(json, AccountHomeDomainUpdatedEffectResponse.class);
      case 6:
        return gson.fromJson(json, AccountFlagsUpdatedEffectResponse.class);
      case 7:
        return gson.fromJson(json, AccountInflationDestinationUpdatedEffectResponse.class);
      // Signer effects
      case 10:
        return gson.fromJson(json, SignerCreatedEffectResponse.class);
      case 11:
        return gson.fromJson(json, SignerRemovedEffectResponse.class);
      case 12:
        return gson.fromJson(json, SignerUpdatedEffectResponse.class);
      // Trustline effects
      case 20:
        return gson.fromJson(json, TrustlineCreatedEffectResponse.class);
      case 21:
        return gson.fromJson(json, TrustlineRemovedEffectResponse.class);
      case 22:
        return gson.fromJson(json, TrustlineUpdatedEffectResponse.class);
      case 23:
        return gson.fromJson(json, TrustlineAuthorizedEffectResponse.class);
      case 24:
        return gson.fromJson(json, TrustlineDeauthorizedEffectResponse.class);
      case 25:
        return gson.fromJson(json, TrustlineAuthorizedToMaintainLiabilitiesEffectResponse.class);
      // Trading effects
      case 30:
        return gson.fromJson(json, OfferCreatedEffectResponse.class);
      case 31:
        return gson.fromJson(json, OfferRemovedEffectResponse.class);
      case 32:
        return gson.fromJson(json, OfferUpdatedEffectResponse.class);
      case 33:
        return gson.fromJson(json, TradeEffectResponse.class);
      // Data effects
      case 40:
        return gson.fromJson(json, DataCreatedEffectResponse.class);
      case 41:
        return gson.fromJson(json, DataRemovedEffectResponse.class);
      case 42:
        return gson.fromJson(json, DataUpdatedEffectResponse.class);
      // Bump Sequence effects
      case 43:
        return gson.fromJson(json, SequenceBumpedEffectResponse.class);
      // claimable balance effects
      case 50:
        return gson.fromJson(json, ClaimableBalanceCreatedEffectResponse.class);
      case 51:
        return gson.fromJson(json, ClaimableBalanceClaimantCreatedEffectResponse.class);
      case 52:
        return gson.fromJson(json, ClaimableBalanceClaimedEffectResponse.class);
      // sponsorship effects
      case 60:
        return gson.fromJson(json, AccountSponsorshipCreatedEffectResponse.class);
      case 61:
        return gson.fromJson(json, AccountSponsorshipUpdatedEffectResponse.class);
      case 62:
        return gson.fromJson(json, AccountSponsorshipRemovedEffectResponse.class);
      case 63:
        return gson.fromJson(json, TrustlineSponsorshipCreatedEffectResponse.class);
      case 64:
        return gson.fromJson(json, TrustlineSponsorshipUpdatedEffectResponse.class);
      case 65:
        return gson.fromJson(json, TrustlineSponsorshipRemovedEffectResponse.class);
      case 66:
        return gson.fromJson(json, DataSponsorshipCreatedEffectResponse.class);
      case 67:
        return gson.fromJson(json, DataSponsorshipUpdatedEffectResponse.class);
      case 68:
        return gson.fromJson(json, DataSponsorshipRemovedEffectResponse.class);
      case 69:
        return gson.fromJson(json, ClaimableBalanceSponsorshipCreatedEffectResponse.class);
      case 70:
        return gson.fromJson(json, ClaimableBalanceSponsorshipUpdatedEffectResponse.class);
      case 71:
        return gson.fromJson(json, ClaimableBalanceSponsorshipRemovedEffectResponse.class);
      case 72:
        return gson.fromJson(json, SignerSponsorshipCreatedEffectResponse.class);
      case 73:
        return gson.fromJson(json, SignerSponsorshipUpdatedEffectResponse.class);
      case 74:
        return gson.fromJson(json, SignerSponsorshipRemovedEffectResponse.class);
      default:
        throw new RuntimeException("Invalid effect type");
    }
  }
}
