package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public abstract class EntitySprite implements DrawableEntity {

    protected final Entity entity;

    EntitySprite(Entity entity) {
        this.entity = entity;
    }

    public boolean represents(Entity entity){
        return this.entity.equals(entity);
    }

    @Override
    public void render(PApplet sketch){
        float entityWidth = entity.getShape().getBounds().width;
        float entityHeight = entity.getShape().getBounds().height;
        float positionX = entity.getPosition().x();
        float positionY = entity.getPosition().y();

        PImage image = getImage(sketch);

        sketch.pushMatrix();
        sketch.translate(positionX, positionY);
        sketch.imageMode(PConstants.CENTER);
        sketch.image(image, 0,0, entityHeight, entityWidth);
        sketch.popMatrix();
        sketch.imageMode(PConstants.CORNER);
    }

    public abstract PImage getImage(PApplet sketch);
}
