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
import org.kuknos.sdk.responses.effects.AccountThresholdsUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.DataCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.DataRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.DataUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.EffectResponse;
import org.kuknos.sdk.responses.effects.OfferCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.OfferRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.OfferUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.SequenceBumpedEffectResponse;
import org.kuknos.sdk.responses.effects.SignerCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.SignerRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.SignerUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.TradeEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineAuthorizedEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineAuthorizedToMaintainLiabilitiesEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineCreatedEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineDeauthorizedEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineRemovedEffectResponse;
import org.kuknos.sdk.responses.effects.TrustlineUpdatedEffectResponse;
import org.kuknos.sdk.responses.effects.*;

import java.lang.reflect.Type;

class EffectDeserializer implements JsonDeserializer<EffectResponse> {
  @Override
  public EffectResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    // Create new Gson object with adapters needed in Operation
    Gson gson = new GsonBuilder()
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
      default:
        throw new RuntimeException("Invalid operation type");
    }
  }
}
