package edu.austral.controllers.configuration;

import java.util.Map;

public class GameConfiguration {

    public Map<Integer, String> playerNames;

    public int amountOfPlayers(){
        return playerNames.size();
    }

    public boolean hasPlayerNames(){
        return playerNames.size() != 0;
    }
}
