package org.kuknos.sdk;

import org.kuknos.sdk.xdr.MemoType;


/**
 * Represents MEMO_NONE.
 */
public class MemoNone extends Memo {
  @Override
  org.kuknos.sdk.xdr.Memo toXdr() {
    org.kuknos.sdk.xdr.Memo memo = new org.kuknos.sdk.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_NONE);
    return memo;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return true;
  }

  @Override
  public String toString() {
    return "";
  }
}
