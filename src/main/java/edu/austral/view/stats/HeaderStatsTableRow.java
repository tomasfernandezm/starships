package edu.austral.view.stats;

import processing.core.PApplet;

import java.util.List;

public class HeaderStatsTableRow extends StatsTableRow {

    private final List<String> headers;

    HeaderStatsTableRow(int xCoor, int yCoor, int height, int width, List<String> headers) {
        super(xCoor, yCoor, height, width, headers.size());
        this.headers = headers;
    }

    @Override
    public void render(PApplet sketch) {
        int i = 0;
        while(i < columnAmount){
            wordViewList.get(i).render(sketch, headers.get(i));
            i++;
        }
    }
}
