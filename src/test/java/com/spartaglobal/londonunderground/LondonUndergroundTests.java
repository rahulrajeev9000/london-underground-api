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

        tubes.add("central");
        tubes.add("district");

        tube.put("id", tubes);

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

    @Test
    public void getCentralLineTest(){
        Assert.assertEquals("central", jsonBody.get("id[1]"));

    }
}
