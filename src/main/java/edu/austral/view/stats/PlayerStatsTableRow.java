package edu.austral.view.stats;

import edu.austral.model.Player;
import processing.core.PApplet;

public class PlayerStatsTableRow extends StatsTableRow{

    private Player player;

    public PlayerStatsTableRow(int xCoor, int yCoor, int height, int width, Player player) {
        super(xCoor, yCoor, height, width, 3);
        this.player = player;
    }

    @Override
    public void render(PApplet sketch) {
        int rgb = 255;
        if(!player.isAlive()) rgb = 120;
        wordViewList.get(0).render(sketch, player.name, rgb);
        wordViewList.get(1).render(sketch, String.valueOf(player.getShip().life), rgb);
        wordViewList.get(2).render(sketch, String.valueOf(player.getScore()), rgb);
    }
}
