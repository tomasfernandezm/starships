package edu.austral.model.entities;

import edu.austral.model.entities.weapons.Weapon;
import edu.austral.util.Vector2;

import java.awt.geom.Rectangle2D;

import static edu.austral.Constants.FWEAPON_HEIGHT;
import static edu.austral.Constants.FWEAPON_WIDTH;

public class FWeapon extends Entity {

    private Weapon weapon;
    private final float collisionDamage;

    public FWeapon(int life, Vector2 position, Vector2 direction, float speed, Weapon weapon) {
        super(life, position, direction, speed, EntityEnum.FWEAPON);
        this.shape = new Rectangle2D.Float(position.x() - FWEAPON_WIDTH/2, position.y() - FWEAPON_HEIGHT/2, FWEAPON_WIDTH, FWEAPON_HEIGHT);
        collisionDamage = (float) life/10;
        this.weapon = weapon;
    }

    @Override
    public float getCollisionDamage() {
        return collisionDamage;
    }

    @Override
    public void collisionedWith(Entity collisionable) {
        if(collisionable.getType().equals(EntityEnum.STARSHIP)) life = -1;
        else super.collisionedWith(collisionable);
    }

    Weapon getWeapon() {
        return weapon;
    }
}
