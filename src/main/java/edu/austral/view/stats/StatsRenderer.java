package edu.austral.view.stats;

import edu.austral.Constants;
import edu.austral.model.Player;
import processing.core.PApplet;

public class StatsRenderer {

    private final StatsTable statsTable;

    public StatsRenderer() {
        int xCoor = Constants.MAP_WIDTH + Constants.STATS_TABLE_LEFT_PADDING;
        int yCoor = Constants.STATS_TABLE_TOP_PADDING;
        int width = Constants.VIEW_WIDTH - Constants.MAP_WIDTH - Constants.STATS_TABLE_LEFT_PADDING - Constants.STATS_TABLE_RIGHT_PADDING;
        int height = Constants.STATS_TABLE_ROW_HEIGHT;
        statsTable = new StatsTable(xCoor, yCoor, width, height);
    }

    public void addPlayerStats(Player player){
        statsTable.addPlayerRow(player);
    }

    public void render(PApplet sketch){
        statsTable.render(sketch);
    }
}
