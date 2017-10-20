package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import processing.core.PApplet;

public abstract class EntitySprite implements DrawableEntity {

    protected final Entity entity;

    EntitySprite(Entity entity) {
        this.entity = entity;
    }

    public boolean represents(Entity entity){
        return this.entity.equals(entity);
    }

    @Override
    public abstract void render(PApplet sketch);
}
