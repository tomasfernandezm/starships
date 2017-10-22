package edu.austral.view;

import edu.austral.model.Player;
import edu.austral.model.entities.Entity;
import edu.austral.view.entities.DrawableEntity;
import edu.austral.view.stats.StatsRenderer;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static edu.austral.Constants.MAP_HEIGHT;
import static edu.austral.Constants.MAP_WIDTH;

public class View {

    private final List<DrawableEntity> drawableEntities = new ArrayList<>();
    private final StatsRenderer statsRenderer = new StatsRenderer();

    public View(){

    }

    public void add(DrawableEntity drawableEntity){
        drawableEntities.add(drawableEntity);
    }

    public void add(Player player){
        statsRenderer.addPlayerStats(player);
    }

    public void remove(Entity entity){
        Optional<DrawableEntity> drawableOptional = get(entity);
        drawableOptional.map(drawableEntities::remove);
    }

    private Optional<DrawableEntity> get(Entity entity){
        for(DrawableEntity d: drawableEntities){
            if(d.represents(entity)) return Optional.of(d);
        }
        return Optional.empty();
    }

    public void render(PApplet sketch){
        for(DrawableEntity d: drawableEntities){
            d.render(sketch);
        }
        statsRenderer.render(sketch);
    }

    public void displayGameOver(PApplet sketch) {
        PImage gameOver = sketch.loadImage("src/main/resources/images/gameOver.png");
        sketch.image(gameOver, MAP_WIDTH/2 - gameOver.width/2, MAP_HEIGHT/2 - gameOver.height/2);
        statsRenderer.render(sketch);
    }
}
