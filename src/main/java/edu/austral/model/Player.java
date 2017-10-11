package edu.austral.model;

import edu.austral.model.entities.Shot;
import edu.austral.model.entities.Starship;

public class Player {

    private final String name;
    private final String number;
    private int score = 0;
    private Starship ship;
    private boolean alive = true;

    public Player(String name, String number, Starship spaceship) {
        this.name = name;
        this.number = number;
        this.ship = spaceship;
    }

    public void addToScore(int toAdd){
        score += toAdd;
    }

    public void rotate(float angle){
        ship.rotate(angle);
    }

    public void move(){
        ship.move();
    }

    public Shot[] shoot(){
        return ship.shoot(this);
    }
}
