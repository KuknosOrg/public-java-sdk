// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.kuknos.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  struct Error
//  {
//      ErrorCode code;
//      string msg<100>;
//  };

//  ===========================================================================
public class Error implements XdrElement {
  public Error () {}
  private ErrorCode code;
  public ErrorCode getCode() {
    return this.code;
  }
  public void setCode(ErrorCode value) {
    this.code = value;
  }
  private XdrString msg;
  public XdrString getMsg() {
    return this.msg;
  }
  public void setMsg(XdrString value) {
    this.msg = value;
  }
  public static void encode(XdrDataOutputStream stream, Error encodedError) throws IOException{
    ErrorCode.encode(stream, encodedError.code);
    encodedError.msg.encode(stream);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static Error decode(XdrDataInputStream stream) throws IOException {
    Error decodedError = new Error();
    decodedError.code = ErrorCode.decode(stream);
    decodedError.msg = XdrString.decode(stream, 100);
    return decodedError;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.code, this.msg);
  }
  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof Error)) {
      return false;
    }

    Error other = (Error) object;
    return Objects.equal(this.code, other.code) && Objects.equal(this.msg, other.msg);
  }
}
