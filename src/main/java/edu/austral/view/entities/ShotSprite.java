package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import edu.austral.model.entities.Shot;
import processing.core.PApplet;

public class ShotSprite extends EntitySprite{

    public ShotSprite(Entity entity) {
        super(entity);
    }

    @Override
    public void render(PApplet sketch) {
        sketch.rect(entity.getPosition().x(), entity.getPosition().y(),
                entity.getShape().getBounds().height, entity.getShape().getBounds().width);
    }
}
