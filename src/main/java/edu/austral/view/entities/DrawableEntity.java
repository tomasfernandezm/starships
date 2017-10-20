package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import edu.austral.util.Vector2;
import edu.austral.view.Drawable;
import processing.core.PApplet;
import processing.core.PGraphics;

import java.awt.*;

public interface DrawableEntity extends Drawable {

    boolean represents(Entity entity);
}
