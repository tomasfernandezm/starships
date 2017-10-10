package edu.austral.model.collision;

import edu.austral.model.entities.Entity;

public class Collision {

    public final Entity collisioner;
    public final Entity collisioned;
    public float damage;

    public Collision(Entity collisioner, Entity collisioned) {
        this.collisioner = collisioner;
        this.collisioned = collisioned;
        calculateDamage();
    }

    private void calculateDamage(){
        // TODO implementar
    }
}
