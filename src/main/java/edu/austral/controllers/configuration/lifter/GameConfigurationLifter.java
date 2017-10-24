package edu.austral.controllers.configuration.lifter;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import edu.austral.controllers.configuration.GameConfiguration;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class GameConfigurationLifter implements ConfigLifter<GameConfiguration> {

    private String path = "src/main/resources/config/gameConfig.json";

    @Override
    public GameConfiguration lift() {
        Gson gson = new Gson();
        GameConfiguration gameConfiguration;
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(path));
            gameConfiguration = gson.fromJson(jsonReader, GameConfiguration.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error loading the configuration file");
        }
        return gameConfiguration;
    }
}

