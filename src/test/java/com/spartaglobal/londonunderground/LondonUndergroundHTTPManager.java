package com.spartaglobal.londonunderground;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

import static io.restassured.RestAssured.basePath;

public class LondonUndergroundHTTPManager {

    private String base_uri;
    private String apiKey;
    private String basePath;

    public LondonUndergroundHTTPManager() {
        PropsReader props = new PropsReader();
        base_uri="https://api.tfl.gov.uk/line/mode";
        basePath = "/tube?";
        apiKey = "access_key=" + props.getApiKey();
    }

    public String[] getTubeLines(){

        String[] jsonBody = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet getTubeLines = new HttpGet(base_uri + basePath + apiKey);
        try {
            CloseableHttpResponse response = httpClient.execute(getTubeLines);
            //jsonBody = EntityUtils.toString(response.getEntity());
            jsonBody = Entit
        }catch (IOException e){
            e.printStackTrace();
        }
        return jsonBody;
    }
}
