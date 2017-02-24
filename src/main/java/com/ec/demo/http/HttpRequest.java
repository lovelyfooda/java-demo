package com.ec.demo.http;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.ec.demo.common.Appconfiguration;

/**
 * @ClassName: HttpRequest
 * @Description: http请求组件
 * @author longqingping
 * @date 2016年10月14日 上午10:13:27
 */
@Component
public class HttpRequest {

    private CloseableHttpClient httpclient;
    private HttpResponseHandler hand = new HttpResponseHandler();

    @PostConstruct
    private void init() {
        httpclient = HttpClients.createDefault();
    }

    public String tokenRequest(String url, String param) throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(url);
        StringEntity en = new StringEntity(param);
        httpPost.setEntity(en);
        String json = httpclient.execute(httpPost, hand);
        System.out.println(json);
        JSONObject jsonObject = new JSONObject(json);
        return (String) jsonObject.getJSONObject("data").get("accessToken");
    }

    public String businessRequest(String url, String token, String param) throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Authorization", token);
        httpPost.addHeader("CORP_ID", Appconfiguration.CORP_ID);
        StringEntity en = new StringEntity(param, "UTF-8");
        en.setContentType("application/json");
        httpPost.setEntity(en);
        // httpPost.setEntity(en);
        String result = httpclient.execute(httpPost, hand);
        System.out.println(result);
        return result;
    }

}
