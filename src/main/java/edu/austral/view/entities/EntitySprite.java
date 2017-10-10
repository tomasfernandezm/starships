package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import processing.core.PGraphics;

public class EntitySprite implements Drawable {

    protected final PGraphics graphics;
    private final Entity entity;

    public EntitySprite(Entity entity) {
        this.entity = entity;
        graphics = setup();
    }

    protected PGraphics setup(){
        return new PGraphics();
    }

    @Override
    public PGraphics getGraphics() {
        return graphics;
    }
}
