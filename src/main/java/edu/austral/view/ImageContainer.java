package edu.austral.view;

import com.jogamp.common.util.ArrayHashMap;
import edu.austral.model.entities.EntityEnum;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.HashMap;
import java.util.Map;

import static edu.austral.model.entities.EntityEnum.STARSHIP;

public class ImageContainer {

    public final Map<EntityEnum, PImage> images = new HashMap<>();

    public ImageContainer(PApplet sketch){
        load(sketch);
    }

    private void load(PApplet sketch){
        images.put(STARSHIP, sketch.loadImage("/home/toams/facultad/starships/src/main/resources/images/starship.jpeg"));
    }
}
