package edu.austral.view.entities;

import edu.austral.GameFramework;
import edu.austral.model.entities.Entity;
import edu.austral.model.entities.Starship;
import edu.austral.util.Vector2;
import edu.austral.view.ImageContainer;
import processing.core.PApplet;
import processing.core.PImage;

public class StarshipSprite extends EntitySprite {

    private PImage shipImage;

    public StarshipSprite(Entity entity) {
        super(entity);
    }

    @Override
    public void render(PApplet sketch) {
        shipImage = sketch.loadImage("/home/toams/facultad/starships/src/main/resources/images/starship.jpeg");

        float entityWidth = entity.getShape().getBounds().width;
        float entityHeight = entity.getShape().getBounds().height;
        float positionX = entity.getPosition().x();
        float positionY = entity.getPosition().y();
        sketch.rect(positionX - entityWidth/2, positionY - entityHeight/2,
                entityWidth, entityHeight);
        PImage image = shipImage;

        sketch.pushMatrix();
        sketch.translate(positionX, positionY);
        sketch.rotate(entity.getDirectionAngle());
        sketch.rect(positionX - entityWidth/2, positionY - entityHeight/2,
                entityWidth, entityHeight);
        sketch.image(image, -entityHeight/2,-entityWidth/2, entityHeight, entityWidth);
        sketch.popMatrix();
    }
}
