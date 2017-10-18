package edu.austral.util.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JSONGenericWriter<T> {

    public void write(List<T> list, String path, String fileName){
        Gson gson = new Gson();
        Type genericType = new TypeToken<List<T>>() {}.getType();
        String json = gson.toJson(list, genericType);
        try{
            FileWriter writer = new FileWriter(path + "/" + fileName);
            writer.write(json);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
