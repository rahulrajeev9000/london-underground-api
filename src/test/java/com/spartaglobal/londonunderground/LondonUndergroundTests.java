package com.spartaglobal.londonunderground;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class LondonUndergroundTests {
    private static JsonPath jsonBody;

    @BeforeClass
    public static void setup(){
        baseURI = "https://api.tfl.gov.uk/line/mode";
        basePath = "/tube?";

        JSONObject tube = new JSONObject();
        JSONArray tubes = new JSONArray();

        tubes.add("serviceTypes[5].name");
        //tubes.add("district");

        tube.put("serviceTypes", tubes);

        System.out.println(tube.toJSONString());

        jsonBody = given()
                .contentType(ContentType.JSON)
                .body(tube)
                .when()
                .post()
                .then()
                .extract()
                .jsonPath();
    }

//    public JsonPath testGetArrayServiceName(){
//        return jsonBody.("serviceTypes[5].name");
//    }

    @Test
    public void getCentralLineTest(){
        Assert.assertEquals("central", jsonBody.get("id[1]"));

    }

    @Test
    public void testGetJubileeHasNight(){
        //Assert.assertEquals(true ,jsonBody.body("serviceTypes[5]name"));
        JSONArray arrayJubilee = (JSONArray) jsonBody.getJsonObject("name");
        System.out.println(arrayJubilee.toJSONString());

    }
}
