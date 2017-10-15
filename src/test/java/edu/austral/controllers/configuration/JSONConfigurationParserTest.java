package edu.austral.controllers.configuration;

import com.google.gson.Gson;
import org.junit.Test;
import processing.event.KeyEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONConfigurationParserTest {

    @Test
    public void testParsing(){
        writeConfiguration();
    }

    private void writeConfiguration(){
        Map<Integer, EnumAction> map = new HashMap<>();
        map.put(97, EnumAction.FORWARD);
        map.put(98, EnumAction.BACKWARDS);
        KeyConfiguration keyConfiguration = new KeyConfiguration(map);
        List<KeyConfiguration> keyConfigurationList = new ArrayList<>();
        keyConfigurationList.add(keyConfiguration);
        Gson gson = new Gson();
        String json = gson.toJson(keyConfigurationList);

        try{
            FileWriter writer = new FileWriter("/home/toams/facultad/starships/src/test/resources/keyTest.json");
            writer.write(json);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
