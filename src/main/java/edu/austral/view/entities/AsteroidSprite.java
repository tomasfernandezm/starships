package edu.austral.view.entities;

import edu.austral.model.entities.Asteroid;
import edu.austral.model.entities.Entity;
import processing.core.PApplet;

public class AsteroidSprite extends EntitySprite{

    public AsteroidSprite(Entity entity) {
        super(entity);
    }

    @Override
    public void render(PApplet sketch) {
        sketch.ellipse(entity.getPosition().x(), entity.getPosition().y(),
                entity.getShape().getBounds().height, entity.getShape().getBounds().width);
    }
}
