package edu.austral.view.entities;

import edu.austral.model.entities.Asteroid;
import edu.austral.model.entities.Entity;
import edu.austral.model.entities.FWeapon;
import processing.core.PApplet;
import processing.core.PImage;

public class FWeaponSprite extends EntitySprite{

    public FWeaponSprite(Entity entity) {
        super(entity);
    }

    @Override
    public void render(PApplet sketch) {
        float entityWidth = entity.getShape().getBounds().width;
        float entityHeight = entity.getShape().getBounds().height;
        float positionX = entity.getPosition().x();
        float positionY = entity.getPosition().y();

        PImage image = sketch.loadImage("/home/toams/facultad/starships/src/main/resources/images/weapon.png");

        sketch.pushMatrix();
        sketch.translate(positionX, positionY);
        sketch.image(image, -entityHeight/2,-entityWidth/2, entityHeight, entityWidth);
        sketch.popMatrix();
    }
}
