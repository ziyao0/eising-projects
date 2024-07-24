package com.ziyao.harbor.web.client;

import com.ziyao.ideal.core.Strings;
import com.ziyao.harbor.web.SslSocketConstructor;
import okhttp3.*;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import java.time.Duration;
import java.util.Objects;

/**
 * @author ziyao zhang
 */
public class OkHttpConstructor {


    public OkHttpClient okHttpClient;


    public OkHttpConstructor() {
        okHttpClient = new OkHttpClient().newBuilder()
                .callTimeout(Duration.ofSeconds(5))
                .readTimeout(Duration.ofSeconds(10))
                .writeTimeout(Duration.ofSeconds(10))
                .sslSocketFactory(SslSocketConstructor.constructSslSocketFactory(), SslSocketConstructor.constructX509TrustManager())
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String s, SSLSession sslSession) {
                        return true;
                    }
                })
                .build();
    }

    public OkHttpClient constructDefaultOkHttpClient() {
        return okHttpClient;
    }

    public ResponseBody call(String url, Object args) {
        try {
            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            RequestBody requestBody = RequestBody.create(Strings.toBytes(args), mediaType);

            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Content-Type", "application/json")
                    .post(requestBody)
                    .build();
            Response execute = okHttpClient.newCall(request).execute();
            if (execute.isSuccessful()) {
                ResponseBody body = execute.body();
                if (Objects.nonNull(body)) {
                    return body;
                }
                return null;
            }
            throw new RuntimeException(execute.message());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        OkHttpConstructor constructor = new OkHttpConstructor();
    }
}
