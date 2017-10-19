package edu.austral.controllers;

import edu.austral.GameController;
import edu.austral.controllers.configuration.EnumAction;
import edu.austral.controllers.configuration.KeyConfiguration;
import edu.austral.model.Game;
import edu.austral.model.Player;
import edu.austral.model.entities.Starship;
import edu.austral.util.Vector2;
import edu.austral.util.generator.Generator;
import edu.austral.util.generator.RandomVectorGenerator;
import edu.austral.view.entities.StarshipSprite;
import processing.event.KeyEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.austral.controllers.configuration.EnumAction.*;

public class PlayerController {

    private float rotationMagnitude = 100;
    private Player player;
    private KeyConfiguration keyConfiguration;
    private Map<EnumAction, Runnable> commands = new HashMap<>();


    public PlayerController(KeyConfiguration keyConfiguration) {
        this.keyConfiguration = keyConfiguration;
        commands.put(FORWARD, this::moveForward);
        commands.put(ROTATE_CLOCKWISE, this::rotateClockwise);
        commands.put(ROTATE_COUNTERCLOCKWISE, this::rotateCounterClockwise);
        commands.put(BACKWARDS, this::moveBackwards);
        commands.put(SHOOT, this::shoot);
    }

    public void keyPressed(KeyEvent keyEvent) {
        keyConfiguration.get(keyEvent.getKeyCode()).ifPresent(enumAction -> {
            commands.get(enumAction).run();
        });
    }

    public void createPlayer(String name, int playerNumber, Vector2 position) {
        Vector2 direction = getUnitaryDirection(position);
        Starship ship = new Starship(100, position, direction, 10);
        player = new Player(name, playerNumber, ship);
        GameController gameController = GameController.INSTANCE;
        gameController.view.add(new StarshipSprite(ship));
    }

    private void rotateClockwise() {
        player.rotate(rotationMagnitude);
    }

    private void rotateCounterClockwise() {
        player.rotate(-1 * rotationMagnitude);
    }

    private void moveForward() {
        if (Game.getINSTANCE().getMap().canMoveForward(player.getShip())) {
            player.moveForward();
        }
    }

    private void moveBackwards() {
        if (Game.getINSTANCE().getMap().canMoveBackwards(player.getShip())) {
            player.moveBackwards();
        }
    }

    private void shoot() {
        player.shoot().ifPresent(shots -> {
            GameController gameController = GameController.INSTANCE;
            gameController.shotController.shotFired(shots);
        });
    }

    private Vector2 getUnitaryDirection(Vector2 position) {
        Generator<Vector2> generator = new RandomVectorGenerator();
        List<Vector2> vectors = generator.generate(1, 500, 500);
        return vectors.get(0).$minus(position).unitary();
    }
}
