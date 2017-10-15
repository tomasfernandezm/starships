package edu.austral.controllers.configuration;

import java.util.HashMap;
import java.util.Map;

public class KeyConfiguration {

    public Map<Integer, EnumAction> actionMap = new HashMap<>();

    KeyConfiguration(Map<Integer, EnumAction> actionMap){
        this.actionMap = actionMap;
    }
}
