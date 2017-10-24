package edu.austral.view.entities;

import edu.austral.GameFramework;
import edu.austral.model.entities.Asteroid;
import processing.core.PApplet;
import processing.core.PImage;

public class AsteroidSprite extends EntitySprite{

    public AsteroidSprite(Asteroid entity) {
        super(entity);
    }

    @Override
    public PImage getImage() {
        return GameFramework.asteroidImage;
    }
}
