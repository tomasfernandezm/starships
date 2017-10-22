package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import processing.core.PApplet;
import processing.core.PImage;

public class ShotSprite extends EntitySprite{

    public ShotSprite(Entity entity) {
        super(entity);
    }

    @Override
    public PImage getImage(PApplet sketch) {
        return sketch.loadImage("/home/toams/facultad/starships/src/main/resources/images/shot.png");
    }
}
