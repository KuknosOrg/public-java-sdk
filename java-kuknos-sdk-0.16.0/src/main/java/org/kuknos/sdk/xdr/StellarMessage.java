// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;
import java.util.Arrays;

// === xdr source ============================================================

//  union StellarMessage switch (MessageType type)
//  {
//  case ERROR_MSG:
//      Error error;
//  case HELLO:
//      Hello hello;
//  case AUTH:
//      Auth auth;
//  case DONT_HAVE:
//      DontHave dontHave;
//  case GET_PEERS:
//      void;
//  case PEERS:
//      PeerAddress peers<100>;
//  
//  case GET_TX_SET:
//      uint256 txSetHash;
//  case TX_SET:
//      TransactionSet txSet;
//  
//  case TRANSACTION:
//      TransactionEnvelope transaction;
//  
//  case SURVEY_REQUEST:
//      SignedSurveyRequestMessage signedSurveyRequestMessage;
//  
//  case SURVEY_RESPONSE:
//      SignedSurveyResponseMessage signedSurveyResponseMessage;
//  
//  // SCP
//  case GET_SCP_QUORUMSET:
//      uint256 qSetHash;
//  case SCP_QUORUMSET:
//      SCPQuorumSet qSet;
//  case SCP_MESSAGE:
//      SCPEnvelope envelope;
//  case GET_SCP_STATE:
//      uint32 getSCPLedgerSeq; // ledger seq requested ; if 0, requests the latest
//  };

//  ===========================================================================
public class StellarMessage implements XdrElement {
  public StellarMessage () {}
  MessageType type;
  public MessageType getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(MessageType value) {
    this.type = value;
  }
  private Error error;
  public Error getError() {
    return this.error;
  }
  public void setError(Error value) {
    this.error = value;
  }
  private Hello hello;
  public Hello getHello() {
    return this.hello;
  }
  public void setHello(Hello value) {
    this.hello = value;
  }
  private Auth auth;
  public Auth getAuth() {
    return this.auth;
  }
  public void setAuth(Auth value) {
    this.auth = value;
  }
  private DontHave dontHave;
  public DontHave getDontHave() {
    return this.dontHave;
  }
  public void setDontHave(DontHave value) {
    this.dontHave = value;
  }
  private PeerAddress[] peers;
  public PeerAddress[] getPeers() {
    return this.peers;
  }
  public void setPeers(PeerAddress[] value) {
    this.peers = value;
  }
  private Uint256 txSetHash;
  public Uint256 getTxSetHash() {
    return this.txSetHash;
  }
  public void setTxSetHash(Uint256 value) {
    this.txSetHash = value;
  }
  private TransactionSet txSet;
  public TransactionSet getTxSet() {
    return this.txSet;
  }
  public void setTxSet(TransactionSet value) {
    this.txSet = value;
  }
  private TransactionEnvelope transaction;
  public TransactionEnvelope getTransaction() {
    return this.transaction;
  }
  public void setTransaction(TransactionEnvelope value) {
    this.transaction = value;
  }
  private SignedSurveyRequestMessage signedSurveyRequestMessage;
  public SignedSurveyRequestMessage getSignedSurveyRequestMessage() {
    return this.signedSurveyRequestMessage;
  }
  public void setSignedSurveyRequestMessage(SignedSurveyRequestMessage value) {
    this.signedSurveyRequestMessage = value;
  }
  private SignedSurveyResponseMessage signedSurveyResponseMessage;
  public SignedSurveyResponseMessage getSignedSurveyResponseMessage() {
    return this.signedSurveyResponseMessage;
  }
  public void setSignedSurveyResponseMessage(SignedSurveyResponseMessage value) {
    this.signedSurveyResponseMessage = value;
  }
  private Uint256 qSetHash;
  public Uint256 getQSetHash() {
    return this.qSetHash;
  }
  public void setQSetHash(Uint256 value) {
    this.qSetHash = value;
  }
  private SCPQuorumSet qSet;
  public SCPQuorumSet getQSet() {
    return this.qSet;
  }
  public void setQSet(SCPQuorumSet value) {
    this.qSet = value;
  }
  private SCPEnvelope envelope;
  public SCPEnvelope getEnvelope() {
    return this.envelope;
  }
  public void setEnvelope(SCPEnvelope value) {
    this.envelope = value;
  }
  private Uint32 getSCPLedgerSeq;
  public Uint32 getGetSCPLedgerSeq() {
    return this.getSCPLedgerSeq;
  }
  public void setGetSCPLedgerSeq(Uint32 value) {
    this.getSCPLedgerSeq = value;
  }
  public static void encode(XdrDataOutputStream stream, StellarMessage encodedStellarMessage) throws IOException {
  //Xdrgen::AST::Identifier
  //MessageType
  stream.writeInt(encodedStellarMessage.getDiscriminant().getValue());
  switch (encodedStellarMessage.getDiscriminant()) {
  case ERROR_MSG:
  Error.encode(stream, encodedStellarMessage.error);
  break;
  case HELLO:
  Hello.encode(stream, encodedStellarMessage.hello);
  break;
  case AUTH:
  Auth.encode(stream, encodedStellarMessage.auth);
  break;
  case DONT_HAVE:
  DontHave.encode(stream, encodedStellarMessage.dontHave);
  break;
  case GET_PEERS:
  break;
  case PEERS:
  int peerssize = encodedStellarMessage.getPeers().length;
  stream.writeInt(peerssize);
  for (int i = 0; i < peerssize; i++) {
    PeerAddress.encode(stream, encodedStellarMessage.peers[i]);
  }
  break;
  case GET_TX_SET:
  Uint256.encode(stream, encodedStellarMessage.txSetHash);
  break;
  case TX_SET:
  TransactionSet.encode(stream, encodedStellarMessage.txSet);
  break;
  case TRANSACTION:
  TransactionEnvelope.encode(stream, encodedStellarMessage.transaction);
  break;
  case SURVEY_REQUEST:
  SignedSurveyRequestMessage.encode(stream, encodedStellarMessage.signedSurveyRequestMessage);
  break;
  case SURVEY_RESPONSE:
  SignedSurveyResponseMessage.encode(stream, encodedStellarMessage.signedSurveyResponseMessage);
  break;
  case GET_SCP_QUORUMSET:
  Uint256.encode(stream, encodedStellarMessage.qSetHash);
  break;
  case SCP_QUORUMSET:
  SCPQuorumSet.encode(stream, encodedStellarMessage.qSet);
  break;
  case SCP_MESSAGE:
  SCPEnvelope.encode(stream, encodedStellarMessage.envelope);
  break;
  case GET_SCP_STATE:
  Uint32.encode(stream, encodedStellarMessage.getSCPLedgerSeq);
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static StellarMessage decode(XdrDataInputStream stream) throws IOException {
  StellarMessage decodedStellarMessage = new StellarMessage();
  MessageType discriminant = MessageType.decode(stream);
  decodedStellarMessage.setDiscriminant(discriminant);
  switch (decodedStellarMessage.getDiscriminant()) {
  case ERROR_MSG:
  decodedStellarMessage.error = Error.decode(stream);
  break;
  case HELLO:
  decodedStellarMessage.hello = Hello.decode(stream);
  break;
  case AUTH:
  decodedStellarMessage.auth = Auth.decode(stream);
  break;
  case DONT_HAVE:
  decodedStellarMessage.dontHave = DontHave.decode(stream);
  break;
  case GET_PEERS:
  break;
  case PEERS:
  int peerssize = stream.readInt();
  decodedStellarMessage.peers = new PeerAddress[peerssize];
  for (int i = 0; i < peerssize; i++) {
    decodedStellarMessage.peers[i] = PeerAddress.decode(stream);
  }
  break;
  case GET_TX_SET:
  decodedStellarMessage.txSetHash = Uint256.decode(stream);
  break;
  case TX_SET:
  decodedStellarMessage.txSet = TransactionSet.decode(stream);
  break;
  case TRANSACTION:
  decodedStellarMessage.transaction = TransactionEnvelope.decode(stream);
  break;
  case SURVEY_REQUEST:
  decodedStellarMessage.signedSurveyRequestMessage = SignedSurveyRequestMessage.decode(stream);
  break;
  case SURVEY_RESPONSE:
  decodedStellarMessage.signedSurveyResponseMessage = SignedSurveyResponseMessage.decode(stream);
  break;
  case GET_SCP_QUORUMSET:
  decodedStellarMessage.qSetHash = Uint256.decode(stream);
  break;
  case SCP_QUORUMSET:
  decodedStellarMessage.qSet = SCPQuorumSet.decode(stream);
  break;
  case SCP_MESSAGE:
  decodedStellarMessage.envelope = SCPEnvelope.decode(stream);
  break;
  case GET_SCP_STATE:
  decodedStellarMessage.getSCPLedgerSeq = Uint32.decode(stream);
  break;
  }
    return decodedStellarMessage;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.error, this.hello, this.auth, this.dontHave, Arrays.hashCode(this.peers), this.txSetHash, this.txSet, this.transaction, this.signedSurveyRequestMessage, this.signedSurveyResponseMessage, this.qSetHash, this.qSet, this.envelope, this.getSCPLedgerSeq, this.type);
  }
  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof StellarMessage)) {
      return false;
    }

    StellarMessage other = (StellarMessage) object;
    return Objects.equal(this.error, other.error) && Objects.equal(this.hello, other.hello) && Objects.equal(this.auth, other.auth) && Objects.equal(this.dontHave, other.dontHave) && Arrays.equals(this.peers, other.peers) && Objects.equal(this.txSetHash, other.txSetHash) && Objects.equal(this.txSet, other.txSet) && Objects.equal(this.transaction, other.transaction) && Objects.equal(this.signedSurveyRequestMessage, other.signedSurveyRequestMessage) && Objects.equal(this.signedSurveyResponseMessage, other.signedSurveyResponseMessage) && Objects.equal(this.qSetHash, other.qSetHash) && Objects.equal(this.qSet, other.qSet) && Objects.equal(this.envelope, other.envelope) && Objects.equal(this.getSCPLedgerSeq, other.getSCPLedgerSeq) && Objects.equal(this.type, other.type);
  }
}
