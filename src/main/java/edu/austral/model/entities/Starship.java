package edu.austral.model.entities;

import edu.austral.model.Player;
import edu.austral.model.entities.weapons.StandardWeapon;
import edu.austral.model.entities.weapons.Weapon;
import edu.austral.util.Vector2;

import java.awt.geom.Rectangle2D;
import java.util.List;

public class Starship extends Entity {

    private Weapon weapon;
    private float collisionDamage;

    Starship(float life, Vector2 position, Vector2 direction, float speed) {
        super(life, position, direction, speed);
        this.shape = new Rectangle2D.Float(position.x(), position.y(), 50, 50);
        this.weapon = new StandardWeapon();
        this.collisionDamage = life/10;
    }


    @Override
    public float getCollisionDamage() {
        return collisionDamage;
    }

    public List<Shot> shoot(Player player){
        return weapon.shoot(player, this);
    }

    public Weapon changeWeapon(Weapon weapon){
        Weapon oldWeapon = this.weapon;
        this.weapon = weapon;
        return oldWeapon;
    }

    public void moveBackwards(){
        position = position.$minus(direction);
    }

    public void rotate(float angle){
        direction = direction.rotate(angle);
    }
}
