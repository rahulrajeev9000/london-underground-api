package com.spartaglobal.londonunderground;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.collection.IsArrayContaining;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.hamcrest.collection.IsArrayContaining.*;
public class SingleLondonUndergroundTests {


    private static ValidatableResponse jsonBody;
    //IsArrayContaining isArrayContaining = new IsArrayContaining(

//    public JSONArray testGetArrayServiceName(){
//        return (JSONArray)jsonBody."serviceTypes[5].name");
//    }

    @BeforeClass
    public static void setup(){
        baseURI = "https://api.tfl.gov.uk/line/mode";
        basePath = "/tube?";
        jsonBody = get().then();

        JSONObject tube = new JSONObject();
        JSONArray tubes = new JSONArray();

       // tube = jsonBody.body("serviceType[5].name");




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

    @Test
    public void testGetJubileeHasNight(){
        //Assert.assertEquals(true ,jsonBody.body("serviceTypes[5]name"));
        jsonBody.body("serviceTypes[5].name[1]", hasItemInArray("Night"));
      // Assert.assertTrue(jsonBody.body("serviceTypes[5].name", IsArrayContaining("Night")));
     // jsonBody.extract("servicesType[5].name", hasItemInArray("Night"));
    }




}
