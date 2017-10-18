package edu.austral.model;

import edu.austral.model.entities.Shot;
import edu.austral.model.entities.Starship;

import java.util.List;
import java.util.Optional;

public class Player {

    private final String name;
    private final int number;
    private int score = 0;
    private Starship ship;
    private boolean alive = true;

    public Player(String name, int number, Starship spaceship) {
        this.name = name;
        this.number = number;
        this.ship = spaceship;
    }

    public Starship getShip(){
        return ship;
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
