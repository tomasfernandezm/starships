package edu.austral.controllers.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class KeyConfiguration {

    private Map<Integer, EnumAction> actionMap = new HashMap<>();

    public KeyConfiguration(Map<Integer, EnumAction> actionMap){
        this.actionMap = actionMap;
    }

    public Optional<EnumAction> get(Integer keyCode){
        EnumAction enumAction = actionMap.get(keyCode);
        return enumAction != null ? Optional.of(enumAction) : Optional.empty();
    }
}
