package edu.austral.controllers.configuration;

import java.util.HashMap;
import java.util.Map;

public class GameConfiguration {

    public Map<Integer, String> playerNames = new HashMap<>();

    public int amountOfPlayers(){
        return playerNames.size();
    }

    public boolean hasPlayerNames(){
        return playerNames.size() != 0;
    }
}
