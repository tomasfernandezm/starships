package edu.austral.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import edu.austral.controllers.configuration.GameConfiguration;
import edu.austral.util.json.JSONGenericParser;
import edu.austral.util.json.JSONGenericWriter;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class JSONGenericIOTest {

    @Test
    public void testJson(){
        GameConfiguration gameConfig = new GameConfiguration();
        gameConfig.playerNames.put(1, "Tomas");
        gameConfig.playerNames.put(2, "Nico");

        Gson gson = new Gson();
        String json = gson.toJson(gameConfig);

        try{
            FileWriter writer = new FileWriter("/home/toams/facultad/starships/src/main/resources/config/gameConfig.json");
            writer.write(json);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        GameConfiguration result = gson.fromJson(json, GameConfiguration.class);
        assertThat(result.playerNames).hasSize(2);
    }

    class Pair implements Comparable<Pair>{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if(o.x == x && o.y == y) return 0;
            return 1;
        }
    }
}
