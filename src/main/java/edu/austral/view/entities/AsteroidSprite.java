package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class AsteroidSprite extends EntitySprite{

    public AsteroidSprite(Entity entity) {
        super(entity);
    }

    @Override
    public void render(PApplet sketch) {

        float entityWidth = entity.getShape().getBounds().width;
        float entityHeight = entity.getShape().getBounds().height;
        float positionX = entity.getPosition().x();
        float positionY = entity.getPosition().y();

        PImage image = sketch.loadImage("/home/toams/facultad/starships/src/main/resources/images/alien.png");

        sketch.pushMatrix();
        sketch.translate(positionX, positionY);
        sketch.ellipseMode(PConstants.CENTER);
        sketch.image(image, 0,0, entityHeight, entityWidth);
        sketch.popMatrix();
    }
}
