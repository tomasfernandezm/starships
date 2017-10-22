package edu.austral.view.stats;

import edu.austral.model.Player;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class StatsTable {

    private final int xCoor;
    private final int yCoor;
    private final int rowWidth;
    private final int rowHeight;
    private final List<StatsTableRow> rows = new ArrayList<>();

    public StatsTable(int xCoor, int yCoor, int rowWidth, int rowHeight) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.rowWidth = rowWidth;
        this.rowHeight = rowHeight;
        createHeader();
    }

    private void createHeader(){
        List<String> headers = new ArrayList<>();
        headers.add("Player");
        headers.add("Life");
        headers.add("Score");
        rows.add(new HeaderStatsTableRow(xCoor, yCoor, rowHeight, rowWidth, headers));
    }

    public void addPlayerRow(Player player){
        int nextYCoor = rowHeight* rows.size() + yCoor;
        rows.add(new PlayerStatsTableRow(xCoor, nextYCoor, rowHeight, rowWidth, player));
    }

    public void render(PApplet sketch){
        for(StatsTableRow str: rows){
            str.render(sketch);
        }
    }
}
