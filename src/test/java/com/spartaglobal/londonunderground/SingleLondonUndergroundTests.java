package com.spartaglobal.londonunderground;

import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class SingleLondonUndergroundTests {


    private static ValidatableResponse jsonBody;

    @BeforeClass
    public static void setup(){
        baseURI = "https://api.tfl.gov.uk/line/mode";
        basePath = "/tube?";
        jsonBody = get().then();

    }

    @Test
    public void testGetBakerloo(){
        jsonBody.body("id[0]",equalTo("bakerloo"));
    }

    @Test
    public void testGetCentral(){
        jsonBody.body("id[1]",equalTo("central"));
    }

    @Test
    public void testGetCentralCreated(){
        jsonBody.body("created[1]", equalTo("2019-06-25T11:46:36.69Z"));
    }

    @Test
    public void testGetDistrictURI(){
        jsonBody.body("serviceTypes[3].uri[0]", equalTo("/Line/Route?ids=District&serviceTypes=Regular"));
    }


}
