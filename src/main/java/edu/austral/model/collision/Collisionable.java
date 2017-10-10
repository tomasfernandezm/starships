package edu.austral.model.collision;

import java.awt.*;

public interface Collisionable<T> {

    Shape getShape();
    void collisionedWith(T c);
}
