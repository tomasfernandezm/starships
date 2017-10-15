package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import edu.austral.model.entities.Shot;
import processing.core.PApplet;

public class ShotSprite extends EntitySprite{

    public ShotSprite(PApplet sketch, Entity entity) {
        super(sketch, entity);
    }

    @Override
    public void render() {
        sketch.rect(entity.getPosition().x(), entity.getPosition().y(),
                entity.getShape().getBounds().height, entity.getShape().getBounds().width);
    }
}
