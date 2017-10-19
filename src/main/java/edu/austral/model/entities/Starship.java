package edu.austral.model.entities;

import edu.austral.model.Constants;
import edu.austral.model.Player;
import edu.austral.model.entities.weapons.StandardWeapon;
import edu.austral.model.entities.weapons.Weapon;
import edu.austral.util.Vector2;

import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.Optional;

public class Starship extends Entity {

    private Weapon weapon;
    private float collisionDamage;
    public Player player;

    public Starship(float life, Vector2 position, Vector2 direction, float speed) {
        super(life, position, direction, speed, EntityEnum.STARSHIP);
        this.shape = new Rectangle2D.Float(position.x(), position.y(), Constants.STARSHIP_HEIGHT, Constants.STARSHIP_WIDTH);
        this.weapon = new StandardWeapon();
        this.collisionDamage = life/10;
    }

    @Override
    public void collisionedWith(Entity collisionable) {
        System.out.println(player.name + "has: " + life + " life left");
        if(collisionable.getType().equals(EntityEnum.FWEAPON)) changeWeapon(((FWeapon) collisionable).getWeapon());
        else super.collisionedWith(collisionable);
    }

    @Override
    public float getCollisionDamage() {
        return collisionDamage;
    }

    public Optional<List<Shot>> shoot(Player player){
        return weapon.shoot(player, this);
    }

    private void changeWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void moveBackwards(){
        position = position.$minus(direction.$times(speed));
    }

    public void rotate(float angle){
        direction = direction.rotate(angle);
        directionAngle += angle;
        if(directionAngle >= 360) directionAngle -= 360;
        AffineTransform tx = new AffineTransform();
        tx.rotate(angle/(2*Math.PI), shape.getBounds().height/2, shape.getBounds().width/2);
        shape = tx.createTransformedShape(shape);
    }
}
