package edu.austral.model;

import edu.austral.controllers.PlayerController;
import edu.austral.model.entities.Shot;
import edu.austral.model.entities.Starship;

import java.util.List;
import java.util.Optional;

public class Player {

    public final String name;
    private final int number;
    private int score = 0;
    private Starship ship;
    public PlayerController playerController;

    public Player(String name, int number, Starship spaceship, PlayerController playerController) {
        this.name = name;
        this.number = number;
        this.ship = spaceship;
        this.playerController = playerController;
    }

    public Starship getShip(){
        return ship;
    }

    public boolean isAlive(){
        return ship.isAlive();
    }

    public int getScore(){
        return score;
    }

    public void addToScore(int toAdd){
        score += toAdd;
    }

    public void rotate(float angle){
        ship.rotate(angle);
    }

    public void moveForward(){
        ship.move();
    }

    public void moveBackwards(){
        ship.moveBackwards();
    }

    public Optional<List<Shot>> shoot(){
        return ship.shoot(this);
    }
}
