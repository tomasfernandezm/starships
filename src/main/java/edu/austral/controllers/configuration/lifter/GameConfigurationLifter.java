package edu.austral.controllers.configuration.lifter;

import edu.austral.controllers.configuration.GameConfiguration;

import java.util.HashMap;
import java.util.Map;

public class GameConfigurationLifter implements ConfigLifter<GameConfiguration>{

    @Override
    public GameConfiguration lift() {
        GameConfiguration gameConfiguration = new GameConfiguration();
        Map<Integer, String> playerNames = new HashMap<>();
        playerNames.put(1, "Tomas");
        gameConfiguration.playerNames = playerNames;
        return gameConfiguration;
    }
}
