package edu.austral.view.entities;

import edu.austral.model.entities.Shot;
import processing.core.PApplet;
import processing.core.PImage;

public class ShotSprite extends EntitySprite{

    public ShotSprite(Shot entity) {
        super(entity);
    }

    @Override
    public PImage getImage(PApplet sketch) {
        return sketch.loadImage("src/main/resources/images/shot.png");
    }
}
