package org.kuknos.sdk.responses.effects;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EffectsRequestBuilder;

/**
 * Represents signer_created effect response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see EffectsRequestBuilder
 * @see Server#effects()
 */
public class SignerCreatedEffectResponse extends SignerEffectResponse {
  SignerCreatedEffectResponse(Integer weight, String publicKey) {
    super(weight, publicKey);
  }
}
