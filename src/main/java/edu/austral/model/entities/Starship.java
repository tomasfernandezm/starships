package edu.austral.model.entities;

import edu.austral.Constants;
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

    public Starship(int life, Vector2 position, Vector2 direction, float speed) {
        super(life, position, direction, speed, EntityEnum.STARSHIP);
        this.shape = new Rectangle2D.Float(position.x(), position.y(), Constants.STARSHIP_HEIGHT, Constants.STARSHIP_WIDTH);
        this.weapon = new StandardWeapon();
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
        position = position.$minus(direction.$times(speed));
    }

    public void rotate(float angle){
        float radians = angle*((float) Math.PI/180);
        direction = direction.rotate(radians);
        directionAngle += angle;
        if(directionAngle >= 360) directionAngle -= 360;
        else if(directionAngle < 0) directionAngle += 360;
        rotateShape(angle);
    }

    private void rotateShape(float angle) {
        double radians = angle*(Math.PI/180);
        AffineTransform tx = new AffineTransform();
        tx.rotate(radians);
        shape = tx.createTransformedShape(shape).getBounds2D();
        rescale(shape.getBounds().width, shape.getBounds().height, tx);

    }

    private void rescale(double xLength, double yLength, AffineTransform tx){
        double x = 50/xLength;
        double y = 50/yLength;
        tx.scale(x, y);
        shape = tx.createTransformedShape(shape).getBounds2D();
    }
}
