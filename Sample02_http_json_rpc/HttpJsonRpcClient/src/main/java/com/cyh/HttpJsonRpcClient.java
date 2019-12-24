package com.cyh;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class HttpJsonRpcClient {

    public static void main(String[] args) throws Exception {
        String url = "http://127.0.0.1:8080/com.cyh.api.DemoService";
        HttpPost httpPost = new HttpPost(url);
        JSONObject param = new JSONObject();
        param.put("jsonrpc", "2.0");
        param.put("method", "sayHello");
        List<String> list = new ArrayList<>();
        list.add("cyh");
        param.put("params", list);
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        entity.setContentEncoding("utf-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json");

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(httpPost);
        String ans = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        System.err.println(ans);

    }

}
