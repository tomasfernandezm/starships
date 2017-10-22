package edu.austral.view.score;

import processing.core.PApplet;

public class PlayerStatsHeader{

    public final int xCoor;
    public final int yCoor;
    public final int width;
    public final int height;
    private WordView nameHeader = new WordView(710, 10, 60, 120);
    private WordView lifeHeader = new WordView(770, 10, 60, 120);
    private WordView scoreHeader = new WordView(830, 10, 60, 120);


    public PlayerStatsHeader(int xCoor, int yCoor, int width, int height) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.width = width;
        this.height = height;
    }

    public void render(PApplet sketch){
        nameHeader.render(sketch, "PLAYER");
        lifeHeader.render(sketch, "LIFE");
        scoreHeader.render(sketch, "SCORE");
    }
}
