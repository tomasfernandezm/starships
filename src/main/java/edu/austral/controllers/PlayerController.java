package edu.austral.controllers;

import edu.austral.GameController;
import edu.austral.controllers.configuration.EnumAction;
import edu.austral.controllers.configuration.KeyConfiguration;
import edu.austral.model.Player;
import edu.austral.model.entities.Shot;
import processing.event.KeyEvent;

import java.util.List;

public class PlayerController {

    private float rotationMagnitude;
    private Player player;
    private int playerNumber;
    private KeyConfiguration keyConfiguration;

    public void keyPressed(KeyEvent keyEvent){
        EnumAction enumAction = keyConfiguration.actionMap.get(keyEvent);
        switch (enumAction){
            case FORWARD:
                moveForward();
                break;
            case ROTATE_CLOCKWISE:
                rotateClockwise();
                break;
            case ROTATE_COUNTERCLOCKWISE:
                rotateCounterClockwise();
                break;
            case SHOOT:
                shoot();
                break;
            case BACKWARDS:
                moveBackwards();
                break;
        }

    }

    private void createPlayer(){
        // TODO crear Starship
        String name = GameController.getINSTANCE().getGameConfiguration().playerNames.get(playerNumber);
        Player player = new Player(name, playerNumber);
    }

    // TODO ver bien si hay con threads, podría guardar una referencia a Player
    private void rotateClockwise(){
        player.rotate(rotationMagnitude);
    }

    private void rotateCounterClockwise(){
        player.rotate(-1*rotationMagnitude);
    }

    private void moveForward(){
        player.moveForward();
    }

    private void moveBackwards(){
        player.moveBackwards();
    }

    private void shoot(){
        List<Shot> shots = player.shoot();
        // TODO falta implementar
    }
}
