package edu.austral;

import edu.austral.view.ImageContainer;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

public abstract class GameFramework extends PApplet {

    PImage backgroundImage;
    @Override public void settings() {
        size(500, 500);
        backgroundImage = loadImage("/home/toams/facultad/starships/src/main/resources/images/space.jpg");
    }

    @Override public void setup() {
        clear();
    }

    @Override public void draw() {
        clear();
        background(0);
        image(backgroundImage, 0, 0);
        draw((frameRate / 60) * 100, this);
    }

    public abstract void draw(float time, PApplet graphics);

    public abstract void keyPressed(KeyEvent event);
}
