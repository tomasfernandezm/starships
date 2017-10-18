package edu.austral.controllers;

import edu.austral.GameController;
import edu.austral.GameFramework;
import edu.austral.model.Game;
import edu.austral.model.entities.Shot;
import edu.austral.view.entities.ShotSprite;
import processing.core.PApplet;

import java.util.List;

public class ShotController {

    void shotFired(List<Shot> shots){
        Game.getINSTANCE().getEntities().addAll(shots);
        for(Shot s: shots){
            ShotSprite shotSprite = new ShotSprite(s);
            GameController.INSTANCE.view.add(shotSprite);
        }
    }
}
