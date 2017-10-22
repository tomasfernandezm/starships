package edu.austral.controllers;

import edu.austral.GameController;
import edu.austral.model.Game;
import edu.austral.model.entities.Shot;
import edu.austral.view.entities.ShotSprite;

import java.util.List;

public class ShotController {

    void shotFired(List<Shot> shots){
        for(Shot s: shots){
            Game.getINSTANCE().addEntity(s);
            ShotSprite shotSprite = new ShotSprite(s);
            GameController.INSTANCE.view.add(shotSprite);
        }
    }
}
