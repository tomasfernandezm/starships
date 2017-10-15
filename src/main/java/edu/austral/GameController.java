package edu.austral;

import edu.austral.controllers.LevelController;
import edu.austral.controllers.PlayerController;
import edu.austral.controllers.ShotController;
import edu.austral.controllers.configuration.EnumAction;
import edu.austral.controllers.configuration.GameConfiguration;
import edu.austral.controllers.configuration.JSONConfigurationParser;
import edu.austral.controllers.configuration.KeyConfiguration;
import edu.austral.model.Player;
import edu.austral.util.Timer;
import edu.austral.util.Vector2;
import edu.austral.view.View;
import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController extends GameFramework {
    public static void main(String args[]) {
        PApplet.main("edu.austral.GameController");
    }

    public static GameController INSTANCE;

    List<PlayerController> playerControllers = new ArrayList<>();
    public ShotController shotController;
    LevelController levelController;
    GameConfiguration gameConfiguration;
    public View view = new View();

    public GameController(){
        INSTANCE = this;
        Map<Integer, EnumAction> map = new HashMap<>();
        map.put(39, EnumAction.ROTATE_COUNTERCLOCKWISE);
        map.put(38, EnumAction.FORWARD);
        map.put(37, EnumAction.ROTATE_CLOCKWISE);
        map.put(40, EnumAction.BACKWARDS);
        KeyConfiguration keyConfiguration = new KeyConfiguration(map);
        PlayerController playerController = new PlayerController(new Vector2(100, 100), this, keyConfiguration);
        playerControllers.add(playerController);
    }

    @Override public void draw(float time, PApplet graphics) {
        view.render(graphics);
    }

    @Override public void keyPressed(KeyEvent event) {
        System.out.println(event.getKeyCode());
        for(PlayerController p: playerControllers){
            p.keyPressed(event);
        }
    }

    public GameConfiguration getGameConfiguration() {
        return gameConfiguration;
    }

    public void setKeyConfig(){
        JSONConfigurationParser<KeyConfiguration> jsonConfigurationParser = new JSONConfigurationParser<>();
        List<KeyConfiguration> configs = jsonConfigurationParser.getConfig("/home/toams/facultad/starships/src/main/resources/keyConfig.json");
    }
}
