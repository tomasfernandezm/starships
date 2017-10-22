package edu.austral.view.entities;

import edu.austral.model.entities.Entity;
import edu.austral.view.Drawable;

public interface DrawableEntity extends Drawable {

    boolean represents(Entity entity);
}
