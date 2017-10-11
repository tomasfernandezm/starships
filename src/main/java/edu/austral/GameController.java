package edu.austral;

import edu.austral.controllers.LevelController;
import edu.austral.controllers.PlayerController;
import edu.austral.controllers.ShotController;
import edu.austral.util.Vector2;
import processing.core.PApplet;

import java.awt.event.KeyEvent;
import java.util.List;

public class GameController extends GameFramework {
    public static void main(String args[]) {
        PApplet.main("edu.austral.GameController");
    }

    private static GameController INSTANCE = new GameController();

    public static GameController getINSTANCE(){
        return INSTANCE;
    }

    List<PlayerController> playerControllers;
    ShotController shotController;
    LevelController levelController;

    private GameController(){

    }

    @Override public void draw(float time, PApplet graphics) {
    }

    @Override public void keyPressed(KeyEvent event) {

    }
}
