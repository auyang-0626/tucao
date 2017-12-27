package com.yang.tucao.helper;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;


import com.alibaba.fastjson.JSON;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpHelper {
    private static final Log LOGGER = LogFactory.getLog(HttpHelper.class);

    private static final MediaType MT_JSON = MediaType.parse("application/json; charset=utf-8");
    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build();

    @SuppressWarnings("ConstantConditions")
    public static String httpGet(HttpUrl url, Map<String, String> headers) throws IOException {
        Request.Builder reqBuilder = new Request.Builder().url(url).get();

        if (null != headers) {
            headers.forEach(reqBuilder::addHeader);
        }

        try (Response response = CLIENT.newCall(reqBuilder.build()).execute()) {
            LOGGER.debug(String.format("[httpGet] %s", response));
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Status code is not 2xx, it is " + response.code() + ", body is: " + response.body().string());
            }
        }
    }

    @SuppressWarnings("ConstantConditions")
    public static String httpPost(HttpUrl url, Object data, Map<String, String> headers) throws IOException {
        RequestBody body = RequestBody.create(MT_JSON, JSON.toJSONString(data));
        Request.Builder reqBuilder = new Request.Builder().url(url).post(body);

        if (null != headers) {
            headers.forEach(reqBuilder::addHeader);
        }

        try (Response response = CLIENT.newCall(reqBuilder.build()).execute()) {
            LOGGER.debug(String.format("[httpPost] %s", response));

            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Status code is not 2xx, it is " + response.code() + ", body is: " + response.body().string());
            }
        }
    }
}
