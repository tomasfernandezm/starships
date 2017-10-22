package edu.austral.view.stats;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public abstract class StatsTableRow {

    private final int xCoor;
    private final int yCoor;
    private final int height;
    private final int width;
    protected final int columnAmount;

    protected List<WordView> wordViewList = new ArrayList<>();

    public StatsTableRow(int xCoor, int yCoor, int height, int width, int columnAmount) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.height = height;
        this.width = width;
        this.columnAmount = columnAmount;
        createColumns(columnAmount);
    }

    private void createColumns(int columnAmount){
        int columnWidth = width/columnAmount;
        int i = 0;
        while(i < columnAmount){
            WordView wordView = new WordView(xCoor + columnWidth*i, yCoor, columnWidth, height);
            wordViewList.add(wordView);
            i += 1;
        }
    }

    public abstract void render(PApplet sketch);
}
