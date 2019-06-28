package com.spartaglobal.londonunderground;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;


public class DTO {

    public JSONArray fullLondonUndergroundFile;

    public DTO(String jsonString){

        //RatesFileReader ratesFile = new RatesFileReader(filePath);
        LondonUndergroundHTTPManager ratesJson = new LondonUndergroundHTTPManager();
        JSONParser parser = new JSONParser();

        try{
            String[] train = {ratesJson.getTubeLines()};
            Object trainObj = parser.parse(ratesJson.getTubeLines());
            fullLondonUndergroundFile = (JSONArray) trainObj;
        }catch (ParseException  e){
            e.printStackTrace();
        }

    }


    public JSONArray getFullLondonUndergroundFile() {
        return fullLondonUndergroundFile;
    }

    // debugging method
    public void printFullFile(){
        System.out.println(fullLondonUndergroundFile.toString());
    }
//
//    public String getCentral(){
//        return (String) fullLondonUndergroundFile.get("id[1]");
//    }


}
