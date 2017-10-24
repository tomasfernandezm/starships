package edu.austral;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

import static edu.austral.Constants.*;

public abstract class GameFramework extends PApplet {

    public static PImage backgroundImage;
    public static PImage gameOverImage;
    public static PImage shotImage;
    public static PImage weaponImage;
    public static PImage shipImage;
    public static PImage asteroidImage;

    @Override public void settings() {
        size(VIEW_WIDTH, VIEW_HEIGHT);
    }

    @Override public void setup() {
        clear();
        backgroundImage = loadImage("src/main/resources/images/space.jpg");
        gameOverImage = loadImage("src/main/resources/images/gameOver.png");
        shotImage = loadImage("src/main/resources/images/shot.png");
        weaponImage = loadImage("src/main/resources/images/weapon.png");
        shipImage = loadImage("src/main/resources/images/starship.png");
        asteroidImage = loadImage("src/main/resources/images/alien.png");

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
