package edu.austral.model.entities;

import edu.austral.model.Player;
import edu.austral.model.entities.weapons.Weapon;
import edu.austral.util.Vector2;

import java.awt.*;

public class Starship extends Entity {

    private Weapon weapon;

    public Starship(Shape shape, Vector2 position, Vector2 direction, float speed, Weapon weapon) {
        super(shape, position, direction, speed);
        this.weapon = weapon;
    }

    @Override
    public void collisionedWith(Entity collisionable) {

    }

    public Shot[] shoot(Player player){
        return weapon.shoot(player);
    }

    public Weapon changeWeapon(Weapon weapon){
        Weapon oldWeapon = this.weapon;
        this.weapon = weapon;
        return oldWeapon;
    }

    public void rotate(float angle){
        direction = direction.rotate(angle);
    }
}
