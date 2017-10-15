package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import processing.core.PApplet;
import processing.core.PGraphics;

public abstract class EntitySprite implements Drawable {

    protected final Entity entity;

    public EntitySprite(Entity entity) {
        this.entity = entity;
    }

    public boolean represents(Entity entity){
        return this.entity.equals(entity);
    }

    @Override
    public abstract void render(PApplet sketch);
}
