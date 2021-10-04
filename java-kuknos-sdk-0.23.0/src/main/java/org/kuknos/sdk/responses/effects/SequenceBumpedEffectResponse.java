package org.kuknos.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

import org.kuknos.sdk.Server;
import org.kuknos.sdk.requests.EffectsRequestBuilder;

/**
 * Represents sequence_bumped effect response.
 * @see <a href="https://www.stellar.org/developers/horizon/reference/resources/effect.html" target="_blank">Effect documentation</a>
 * @see EffectsRequestBuilder
 * @see Server#effects()
 */
public class SequenceBumpedEffectResponse extends EffectResponse {
    @SerializedName("new_seq")
    protected final Long newSequence;

    public SequenceBumpedEffectResponse(Long newSequence) {
        this.newSequence = newSequence;
    }

    public Long getNewSequence() {
        return newSequence;
    }
}
