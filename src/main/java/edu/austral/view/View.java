package edu.austral.view;

import edu.austral.model.Player;
import edu.austral.model.entities.Entity;
import edu.austral.view.entities.DrawableEntity;
import edu.austral.view.score.PlayerStatsHeader;
import edu.austral.view.score.PlayerStatsRenderer;
import edu.austral.view.score.WordView;
import processing.core.PApplet;

import java.util.*;

public class View {

    private final List<DrawableEntity> drawableEntities = new ArrayList<>();
    private final PlayerStatsRenderer playerStatsRenderer = new PlayerStatsRenderer();

    public View(){

    }

    public void add(DrawableEntity drawableEntity){
        drawableEntities.add(drawableEntity);
    }

    public void add(Player player){
        playerStatsRenderer.addPlayerStats(player);
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
        playerStatsRenderer.render(sketch);
    }
}
