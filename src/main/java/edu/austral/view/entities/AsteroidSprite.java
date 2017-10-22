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
    public PImage getImage(PApplet sketch) {
        return sketch.loadImage("/home/toams/facultad/starships/src/main/resources/images/alien.png");
    }
}
