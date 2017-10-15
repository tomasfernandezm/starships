package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import processing.core.PApplet;
import processing.core.PGraphics;

public interface Drawable {

    void render(PApplet sketch);

    boolean represents(Entity entity);
}
