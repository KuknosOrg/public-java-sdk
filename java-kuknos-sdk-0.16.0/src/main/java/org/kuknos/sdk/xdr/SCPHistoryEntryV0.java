// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import java.util.Arrays;
import com.google.common.base.Objects;

// === xdr source ============================================================

//  struct SCPHistoryEntryV0
//  {
//      SCPQuorumSet quorumSets<>; // additional quorum sets used by ledgerMessages
//      LedgerSCPMessages ledgerMessages;
//  };

//  ===========================================================================
public class SCPHistoryEntryV0 implements XdrElement {
  public SCPHistoryEntryV0 () {}
  private SCPQuorumSet[] quorumSets;
  public SCPQuorumSet[] getQuorumSets() {
    return this.quorumSets;
  }
  public void setQuorumSets(SCPQuorumSet[] value) {
    this.quorumSets = value;
  }
  private LedgerSCPMessages ledgerMessages;
  public LedgerSCPMessages getLedgerMessages() {
    return this.ledgerMessages;
  }
  public void setLedgerMessages(LedgerSCPMessages value) {
    this.ledgerMessages = value;
  }
  public static void encode(XdrDataOutputStream stream, SCPHistoryEntryV0 encodedSCPHistoryEntryV0) throws IOException{
    int quorumSetssize = encodedSCPHistoryEntryV0.getQuorumSets().length;
    stream.writeInt(quorumSetssize);
    for (int i = 0; i < quorumSetssize; i++) {
      SCPQuorumSet.encode(stream, encodedSCPHistoryEntryV0.quorumSets[i]);
    }
    LedgerSCPMessages.encode(stream, encodedSCPHistoryEntryV0.ledgerMessages);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static SCPHistoryEntryV0 decode(XdrDataInputStream stream) throws IOException {
    SCPHistoryEntryV0 decodedSCPHistoryEntryV0 = new SCPHistoryEntryV0();
    int quorumSetssize = stream.readInt();
    decodedSCPHistoryEntryV0.quorumSets = new SCPQuorumSet[quorumSetssize];
    for (int i = 0; i < quorumSetssize; i++) {
      decodedSCPHistoryEntryV0.quorumSets[i] = SCPQuorumSet.decode(stream);
    }
    decodedSCPHistoryEntryV0.ledgerMessages = LedgerSCPMessages.decode(stream);
    return decodedSCPHistoryEntryV0;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(Arrays.hashCode(this.quorumSets), this.ledgerMessages);
  }
  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof SCPHistoryEntryV0)) {
      return false;
    }

    SCPHistoryEntryV0 other = (SCPHistoryEntryV0) object;
    return Arrays.equals(this.quorumSets, other.quorumSets) && Objects.equal(this.ledgerMessages, other.ledgerMessages);
  }
}
