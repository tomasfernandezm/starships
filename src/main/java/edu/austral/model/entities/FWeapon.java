package edu.austral.model.entities;

import edu.austral.model.entities.weapons.Weapon;
import edu.austral.util.Vector2;

import java.awt.*;

public class FWeapon extends Entity {

    private Weapon weapon;

    public FWeapon(Shape shape, Vector2 position, Vector2 direction, float speed) {
        super(shape, position, direction, speed);
    }

    @Override
    public void collisionedWith(Entity collisionable) {
        // TODO implementar
    }
}
