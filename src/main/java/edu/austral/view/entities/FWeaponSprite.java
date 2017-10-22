package edu.austral.view.entities;

import edu.austral.model.entities.Asteroid;
import edu.austral.model.entities.Entity;
import edu.austral.model.entities.FWeapon;
import processing.core.PApplet;
import processing.core.PImage;

public class FWeaponSprite extends EntitySprite{

    public FWeaponSprite(FWeapon entity) {
        super(entity);
    }

    @Override
    public PImage getImage(PApplet sketch) {
        return sketch.loadImage("/home/toams/facultad/starships/src/main/resources/images/weapon.png");
    }
}
