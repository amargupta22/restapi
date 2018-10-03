package com.qa.client;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Amar on 11/05/18.
 */
public class RestClient {


    // 1. Get Method
    public CloseableHttpResponse getCall(String url) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        // createDefault will create one client connection and it returns CloseableHttpClient object.

        HttpGet httpGet = new HttpGet(url); // This will create one httpget connection.

        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet); // Hit the get URL

        return closeableHttpResponse;
    }
}



