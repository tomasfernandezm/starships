package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import edu.austral.model.entities.Starship;
import edu.austral.util.Vector2;
import processing.core.PApplet;

public class StarshipSprite extends EntitySprite {

    public StarshipSprite(Entity entity) {
        super(entity);
    }

    @Override
    public void render(PApplet sketch) {
        sketch.fill(255, 0, 0);
        float entityWidth = entity.getShape().getBounds().width;
        float entityHeight = entity.getShape().getBounds().height;
        float positionX = entity.getPosition().x();
        float positionY = entity.getPosition().y();
        sketch.rect(positionX - entityWidth/2, positionY - entityHeight/2,
                entityWidth, entityHeight);
        Vector2 position = entity.getPosition();
        Vector2 direction = entity.getDirection();
        sketch.stroke(126);
        sketch.line(position.x(), position.y(), position.x() + direction.x()*entity.getShape().getBounds().height/2,position.y() + direction.y()*entity.getShape().getBounds().width/2);
    }
}
