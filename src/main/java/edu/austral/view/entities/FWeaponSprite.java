package edu.austral.view.entities;

import edu.austral.model.entities.FWeapon;
import processing.core.PApplet;
import processing.core.PImage;

public class FWeaponSprite extends EntitySprite{

    public FWeaponSprite(FWeapon entity) {
        super(entity);
    }

    @Override
    public PImage getImage(PApplet sketch) {
        return sketch.loadImage("src/main/resources/images/weapon.png");
    }
}
