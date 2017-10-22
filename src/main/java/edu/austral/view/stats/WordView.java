package edu.austral.view.stats;

import processing.core.PApplet;
import processing.core.PConstants;

public class WordView{

    public final int x;
    public final int y;
    public final int width;
    public final int height;

    WordView(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render(PApplet sketch, String word){
        render(sketch, word, 255);
    }

    public void render(PApplet sketch, String word, int rgb){
        sketch.pushMatrix();
        sketch.fill(rgb);
        sketch.textAlign(PConstants.CENTER);
        sketch.text(word, x, y, width, height);
        sketch.popMatrix();
    }
}
