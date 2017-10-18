package edu.austral.view;

import edu.austral.controllers.configuration.EnumAction;
import edu.austral.model.entities.Entity;
import edu.austral.model.entities.EntityEnum;
import edu.austral.view.entities.Drawable;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.*;

import static edu.austral.model.entities.EntityEnum.STARSHIP;

public class View {

    private final List<Drawable> drawables = new ArrayList<>();

    public View(){

    }

    public void add(Drawable drawable){
        drawables.add(drawable);
    }

    public void remove(Entity entity){
        Optional<Drawable> drawableOptional = get(entity);
        drawableOptional.map(drawables::remove);
    }

    private Optional<Drawable> get(Entity entity){
        for(Drawable d: drawables){
            if(d.represents(entity)) return Optional.of(d);
        }
        return Optional.empty();
    }

    public void render(PApplet sketch){
        for(Drawable d: drawables){
            d.render(sketch);
        }
    }
}
