package edu.austral.controllers;

import edu.austral.GameController;
import edu.austral.controllers.configuration.EnumAction;
import edu.austral.controllers.configuration.KeyConfiguration;
import edu.austral.model.Game;
import edu.austral.model.Player;
import edu.austral.model.entities.Shot;
import edu.austral.model.entities.Starship;
import edu.austral.util.Vector2;
import edu.austral.util.generator.Generator;
import edu.austral.util.generator.RandomVectorGenerator;
import edu.austral.view.entities.StarshipSprite;
import edu.austral.view.View;
import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.List;

public class PlayerController {

    private float rotationMagnitude = 100;
    private Player player;
    private int playerNumber;
    private KeyConfiguration keyConfiguration;
    private PApplet sketch;


    public PlayerController(Vector2 position, PApplet pApplet, KeyConfiguration keyConfiguration){
        Generator<Vector2> generator = new RandomVectorGenerator();
        List<Vector2> vectors = generator.generate(1, 500, 500);
        Vector2 unitaryDirection = calculateUnitaryDirection(position, vectors.get(0));
        createPlayer(position, unitaryDirection);
        sketch = pApplet;
        this.keyConfiguration = keyConfiguration;
    }

    public void keyPressed(KeyEvent keyEvent){
        EnumAction enumAction = keyConfiguration.actionMap.get(keyEvent.getKeyCode());
        switch (enumAction){
            case FORWARD:
                if(Game.getINSTANCE().getMap().canMoveForward(player.getShip())){
                    moveForward();
                }
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
                if(Game.getINSTANCE().getMap().canMoveBackwards(player.getShip())){
                    moveBackwards();
                }
                break;
        }
    }

    private void createPlayer(Vector2 position, Vector2 direction){
//        String name = GameController.getINSTANCE().getGameConfiguration().playerNames.get(playerNumber);
        String name = "Tomas";
        int playerNumber = 3;
        Starship ship = new Starship(100, position, direction, 10);
        player = new Player(name, playerNumber, ship);
        GameController gameController = GameController.INSTANCE;
        gameController.view.add(new StarshipSprite(ship));
    }

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
        GameController gameController = GameController.INSTANCE;
        gameController.shotController.shotFired(shots);
    }

    private Vector2 calculateUnitaryDirection(Vector2 position, Vector2 direction){
        return direction.$minus(position).unitary();
    }
}
