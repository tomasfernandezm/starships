package edu.austral.view.score;

import edu.austral.model.Player;
import edu.austral.view.Drawable;
import processing.core.PApplet;

public class PlayerStatsView{

    private final Player player;
    private final int xCoor;
    private final int yCoor;
    private final int width;
    private final int height;
    private WordView name;
    private WordView life;
    private WordView score;

    PlayerStatsView(Player player, int xCoor, int yCoor, int width, int height) {
        this.player = player;
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.width = width;
        this.height = height;
        name = new WordView(710, yCoor, width, height);
        life = new WordView(770, yCoor, width, height);
        score = new WordView(830, yCoor, width, height);
    }

    public void render(PApplet sketch){
        int rgb = 255;
        if(!player.isAlive()) rgb = 120;
        name.render(sketch, player.name, rgb);
        life.render(sketch, String.valueOf(player.getShip().life), rgb);
        score.render(sketch, String.valueOf(player.getScore()), rgb);
    }
}
