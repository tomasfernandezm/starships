package edu.austral.controllers.configuration.lifter;

import edu.austral.controllers.configuration.EnumAction;
import edu.austral.controllers.configuration.KeyConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyConfigurationLifter implements ConfigLifter<List<KeyConfiguration>> {

    @Override
    public List<KeyConfiguration> lift() {
        List<KeyConfiguration> result = new ArrayList<>();
        Map<Integer, EnumAction> map = new HashMap<>();
        map.put(39, EnumAction.ROTATE_COUNTERCLOCKWISE);
        map.put(38, EnumAction.FORWARD);
        map.put(37, EnumAction.ROTATE_CLOCKWISE);
        map.put(40, EnumAction.BACKWARDS);
        map.put(83, EnumAction.SHOOT);
        result.add(new KeyConfiguration(map));
        return result;
    }
}
