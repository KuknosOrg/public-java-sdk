package org.kuknos.sdk;

import org.kuknos.sdk.xdr.Hash;
import org.kuknos.sdk.xdr.Memo;
import org.kuknos.sdk.xdr.MemoType;

/**
 * Represents MEMO_RETURN.
 */
public class MemoReturnHash extends MemoHashAbstract {
  public MemoReturnHash(byte[] bytes) {
    super(bytes);
  }

  public MemoReturnHash(String hexString) {
    super(hexString);
  }

  @Override
  Memo toXdr() {
    Memo memo = new Memo();
    memo.setDiscriminant(MemoType.MEMO_RETURN);

    Hash hash = new Hash();
    hash.setHash(bytes);

    memo.setRetHash(hash);
    return memo;
  }
}
