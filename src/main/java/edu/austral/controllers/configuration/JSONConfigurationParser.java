package edu.austral.controllers.configuration;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONConfigurationParser<T> {

    public List<T> getConfig(String path){
        Gson gson = new Gson();
        List<T> result;
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(path));
            Type typeToken = new TypeToken<List<T>>() {
            }.getType();
            result = gson.fromJson(jsonReader, typeToken);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("There was an error loading the configuration file");
        }
        return result;
    }
}
