package org.kuknos.sdk;

import org.kuknos.sdk.xdr.SignerKey;
import org.kuknos.sdk.xdr.SignerKeyType;
import org.kuknos.sdk.xdr.Uint256;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Signer is a helper class that creates {@link SignerKey} objects.
 */
public class Signer {
    /**
     * Create <code>ed25519PublicKey</code> {@link SignerKey} from
     * a {@link KeyPair}
     * @param keyPair
     * @return org.stellar.sdk.xdr.SignerKey
     */
    public static SignerKey ed25519PublicKey(KeyPair keyPair) {
        checkNotNull(keyPair, "keyPair cannot be null");
        return keyPair.getXdrSignerKey();
    }

    /**
     * Create <code>sha256Hash</code> {@link SignerKey} from
     * a sha256 hash of a preimage.
     * @param hash
     * @return org.stellar.sdk.xdr.SignerKey
     */
    public static SignerKey sha256Hash(byte[] hash) {
        checkNotNull(hash, "hash cannot be null");
        SignerKey signerKey = new SignerKey();
        Uint256 value = Signer.createUint256(hash);

        signerKey.setDiscriminant(SignerKeyType.SIGNER_KEY_TYPE_HASH_X);
        signerKey.setHashX(value);

        return signerKey;
    }

    /**
     * Create <code>preAuthTx</code> {@link SignerKey} from
     * a {@link org.kuknos.sdk.xdr.Transaction} hash.
     * @param tx
     * @return org.stellar.sdk.xdr.SignerKey
     */
    public static SignerKey preAuthTx(Transaction tx) {
        checkNotNull(tx, "tx cannot be null");
        SignerKey signerKey = new SignerKey();
        Uint256 value = Signer.createUint256(tx.hash());

        signerKey.setDiscriminant(SignerKeyType.SIGNER_KEY_TYPE_PRE_AUTH_TX);
        signerKey.setPreAuthTx(value);

        return signerKey;
    }

    /**
     * Create <code>preAuthTx</code> {@link SignerKey} from
     * a transaction hash.
     * @param hash
     * @return org.stellar.sdk.xdr.SignerKey
     */
    public static SignerKey preAuthTx(byte[] hash) {
        checkNotNull(hash, "hash cannot be null");
        SignerKey signerKey = new SignerKey();
        Uint256 value = Signer.createUint256(hash);

        signerKey.setDiscriminant(SignerKeyType.SIGNER_KEY_TYPE_PRE_AUTH_TX);
        signerKey.setPreAuthTx(value);

        return signerKey;
    }

    private static Uint256 createUint256(byte[] hash) {
        if (hash.length != 32) {
            throw new RuntimeException("hash must be 32 bytes long");
        }
        Uint256 value = new Uint256();
        value.setUint256(hash);
        return value;
    }
}
