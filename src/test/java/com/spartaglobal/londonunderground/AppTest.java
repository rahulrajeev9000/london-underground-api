package com.spartaglobal.londonunderground;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AppTest {

    DTO dto = new DTO("resources/key.properties");

    @Test
    public void getFullFile(){
        dto.printFullFile();
    }

//    @Test
//    public void testCentral(){
//        assertEquals("central", dto.getCentral());
//    }
//
//

}
