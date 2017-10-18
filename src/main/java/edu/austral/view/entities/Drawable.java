package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.core.PGraphics;

import java.awt.*;

public interface Drawable {

    void render(PApplet sketch);
    boolean represents(Entity entity);
}
