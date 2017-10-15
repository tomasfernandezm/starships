package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import processing.core.PApplet;
import processing.core.PGraphics;

public abstract class EntitySprite implements Drawable {

    protected final Entity entity;
    protected final PApplet sketch;

    public EntitySprite(PApplet sketch, Entity entity) {
        this.entity = entity;
        this.sketch = sketch;
    }

    @Override
    public abstract void render();
}
