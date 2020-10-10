// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union SurveyResponseBody switch (SurveyMessageCommandType type)
//  {
//  case SURVEY_TOPOLOGY:
//      TopologyResponseBody topologyResponseBody;
//  };

//  ===========================================================================
public class SurveyResponseBody implements XdrElement {
  public SurveyResponseBody () {}
  SurveyMessageCommandType type;
  public SurveyMessageCommandType getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(SurveyMessageCommandType value) {
    this.type = value;
  }
  private TopologyResponseBody topologyResponseBody;
  public TopologyResponseBody getTopologyResponseBody() {
    return this.topologyResponseBody;
  }
  public void setTopologyResponseBody(TopologyResponseBody value) {
    this.topologyResponseBody = value;
  }
  public static void encode(XdrDataOutputStream stream, SurveyResponseBody encodedSurveyResponseBody) throws IOException {
  //Xdrgen::AST::Identifier
  //SurveyMessageCommandType
  stream.writeInt(encodedSurveyResponseBody.getDiscriminant().getValue());
  switch (encodedSurveyResponseBody.getDiscriminant()) {
  case SURVEY_TOPOLOGY:
  TopologyResponseBody.encode(stream, encodedSurveyResponseBody.topologyResponseBody);
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static SurveyResponseBody decode(XdrDataInputStream stream) throws IOException {
  SurveyResponseBody decodedSurveyResponseBody = new SurveyResponseBody();
  SurveyMessageCommandType discriminant = SurveyMessageCommandType.decode(stream);
  decodedSurveyResponseBody.setDiscriminant(discriminant);
  switch (decodedSurveyResponseBody.getDiscriminant()) {
  case SURVEY_TOPOLOGY:
  decodedSurveyResponseBody.topologyResponseBody = TopologyResponseBody.decode(stream);
  break;
  }
    return decodedSurveyResponseBody;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.topologyResponseBody, this.type);
  }
  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof SurveyResponseBody)) {
      return false;
    }

    SurveyResponseBody other = (SurveyResponseBody) object;
    return Objects.equal(this.topologyResponseBody, other.topologyResponseBody) && Objects.equal(this.type, other.type);
  }
}