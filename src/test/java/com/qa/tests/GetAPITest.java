package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Amar on 13/06/18.
 */
public class GetAPITest extends TestBase {
    TestBase testBase;
    String serviceUrl;
    String apiURL;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;

    @BeforeMethod
    public void setup() {
        testBase = new TestBase();
        serviceUrl = prop.getProperty("URL");
        apiURL = prop.getProperty("serviceURL");

        url = serviceUrl + apiURL;
    }

    @Test
    public void getAPITest() throws IOException {
        restClient = new RestClient();
        closeableHttpResponse = restClient.getCall(url);

        // a. Status Code
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status Code: " + statusCode);

        Assert.assertEquals(RESPONSE_STATUS_CODE_200,statusCode,"Status code is not 200");
        //b. Json String
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON: " + responseJson);

        //c. All Headers
        Header[] headersArray = closeableHttpResponse.getAllHeaders();

        HashMap<String, String> allHeaders = new HashMap<String, String>();

        for (Header header : headersArray) {
            allHeaders.put(header.getName(), header.getValue());
        }

        System.out.println("Header Array: " + allHeaders);

    }
}
