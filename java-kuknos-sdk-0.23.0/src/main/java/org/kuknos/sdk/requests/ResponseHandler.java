package org.kuknos.sdk.requests;

import com.google.gson.reflect.TypeToken;

import org.kuknos.sdk.responses.GsonSingleton;
import org.kuknos.sdk.responses.TypedResponse;

import java.io.IOException;

import okhttp3.Response;

public class ResponseHandler<T> {

  private TypeToken<T> type;

  /**
   * "Generics on a type are typically erased at runtime, except when the type is compiled with the
   * generic parameter bound. In that case, the compiler inserts the generic type information into
   * the compiled class. In other cases, that is not possible."
   * More info: http://stackoverflow.com/a/14506181
   * @param type
   */
  public ResponseHandler(TypeToken<T> type) {
    this.type = type;
  }

  public T handleResponse(final Response response) throws IOException, TooManyRequestsException {
    try {
      // Too Many Requests
      if (response.code() == 429) {
        int retryAfter = Integer.parseInt(response.header("Retry-After"));
        throw new TooManyRequestsException(retryAfter);
      }

      String content = response.body().string();

      // Other errors
      if (response.code() >= 300) {
        throw new ErrorResponse(response.code(), content);
      }

      T object = GsonSingleton.getInstance().fromJson(content, type.getType());
      if (object instanceof org.kuknos.sdk.responses.Response) {
        ((org.kuknos.sdk.responses.Response) object).setHeaders(response.headers());
      }
      if(object instanceof TypedResponse) {
    	  	((TypedResponse) object).setType(type);
      }
      return object;
    } finally {
      response.close();
    }
  }

  public T handleResponse(String message) throws IOException, TooManyRequestsException {
    throw new ErrorResponse(500, message);
  }
}
