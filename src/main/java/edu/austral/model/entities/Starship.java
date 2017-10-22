package edu.austral.model.entities;

import edu.austral.Constants;
import edu.austral.model.Player;
import edu.austral.model.entities.weapons.DoubleWeapon;
import edu.austral.model.entities.weapons.StandardWeapon;
import edu.austral.model.entities.weapons.TripleWeapon;
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

    public Starship(int life, Vector2 position, Vector2 direction, float speed) {
        super(life, position, direction, speed, EntityEnum.STARSHIP);
        this.shape = new Rectangle2D.Float(position.x() - Constants.STARSHIP_WIDTH/2, position.y() - Constants.STARSHIP_HEIGHT/2, Constants.STARSHIP_HEIGHT, Constants.STARSHIP_WIDTH);
        this.weapon = new TripleWeapon();
        this.collisionDamage = life/10;
    }

    @Override
    public void collisionedWith(Entity collisionable) {
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
        AffineTransform affineTransform = new AffineTransform();
        position = position.$minus(direction.$times(speed));
        affineTransform.translate(-1*direction.x()*speed, -1*direction.y()*speed);
        shape = affineTransform.createTransformedShape(shape);
    }

    public void rotate(float angle){
        float radians = angle*((float) Math.PI/180);
        direction = direction.rotate(radians);
        directionAngle += angle;
        if(directionAngle >= 360) directionAngle -= 360;
        else if(directionAngle < 0) directionAngle += 360;
    }
}
