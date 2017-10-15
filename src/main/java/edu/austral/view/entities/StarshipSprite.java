package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import edu.austral.model.entities.Starship;
import processing.core.PApplet;

public class StarshipSprite extends EntitySprite {

    public StarshipSprite(PApplet sketch, Entity entity) {
        super(sketch, entity);
    }

    @Override
    public void render() {
        sketch.rect(entity.getPosition().x(), entity.getPosition().y(),
                entity.getShape().getBounds().height, entity.getShape().getBounds().width);
    }
}
