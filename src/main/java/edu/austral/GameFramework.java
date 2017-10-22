package edu.austral;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

import static edu.austral.Constants.*;

public abstract class GameFramework extends PApplet {

    PImage backgroundImage;
    PImage gameOver;
    @Override public void settings() {
        size(VIEW_WIDTH, VIEW_HEIGHT);
        backgroundImage = loadImage("/home/toams/facultad/starships/src/main/resources/images/space.jpg");
        gameOver = loadImage("/home/toams/facultad/starships/src/main/resources/images/gameOver.png");
    }

    @Override public void setup() {
        clear();
    }

    @Override public void draw() {
        clear();
        background(0);
        image(backgroundImage, 0, 0, MAP_WIDTH,MAP_HEIGHT);
        draw((frameRate / 60) * 100, this);
    }

    public abstract void draw(float time, PApplet graphics);

    public abstract void keyPressed(KeyEvent event);
}
