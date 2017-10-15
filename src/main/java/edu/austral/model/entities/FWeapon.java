package edu.austral.model.entities;

import edu.austral.model.entities.weapons.Weapon;
import edu.austral.util.Vector2;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class FWeapon extends Entity {

    private Weapon weapon;
    private final float collisionDamage;

    FWeapon(float life, Vector2 position, Vector2 direction, float speed) {
        super(life, position, direction, speed);
        this.shape = new Rectangle2D.Float(position.x(), position.y(), 30, 30);
        collisionDamage = (float) life/10;
    }

    @Override
    public float getCollisionDamage() {
        return collisionDamage;
    }
}
