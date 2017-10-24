package edu.austral.controllers.configuration.lifter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import edu.austral.controllers.configuration.KeyConfiguration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class KeyConfigurationLifter implements ConfigLifter<List<KeyConfiguration>> {

    String path = "src/main/resources/config/keyConfig.json";

    @Override
    public List<KeyConfiguration> lift(){
        Gson gson = new Gson();
        List<KeyConfiguration> result;
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(path));
            Type typeToken = new TypeToken<List<KeyConfiguration>>() {
            }.getType();
            result = gson.fromJson(jsonReader, typeToken);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("There was an error loading the configuration file");
        }
        return result;
    }
}
