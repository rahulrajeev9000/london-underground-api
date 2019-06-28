package com.spartaglobal.londonunderground;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropsReader {

    private String apiKey;

    public PropsReader() {
        Properties props = new Properties();

        try{
            props.load(new FileReader("resources/key.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }

        apiKey = props.getProperty("key");

    }

    public String getApiKey(){
        return apiKey;
    }
}
