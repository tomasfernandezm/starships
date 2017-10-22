package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import processing.core.PApplet;

public class ShotSprite extends EntitySprite{

    public ShotSprite(Entity entity) {
        super(entity);
    }

    @Override
    public void render(PApplet sketch) {
        float entityWidth = entity.getShape().getBounds().width;
        float entityHeight = entity.getShape().getBounds().height;
        float positionX = entity.getPosition().x();
        float positionY = entity.getPosition().y();

        sketch.pushMatrix();
        sketch.translate(positionX, positionY);
        sketch.rect(-entityHeight/2,-entityWidth/2, entityHeight, entityWidth);
        sketch.popMatrix();
    }
}
