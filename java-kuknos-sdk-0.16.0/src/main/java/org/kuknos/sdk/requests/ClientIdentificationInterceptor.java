package org.kuknos.sdk.requests;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.kuknos.sdk.Util;

import java.io.IOException;

public class ClientIdentificationInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request requestWithHeaders;

        requestWithHeaders = originalRequest.newBuilder()
                .addHeader("X-Client-Name", "java-stellar-sdk")
                .addHeader("X-Client-Version", Util.getSdkVersion())
                .build();
        return chain.proceed(requestWithHeaders);
    }
}
