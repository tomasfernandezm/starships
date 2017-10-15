package edu.austral.controllers;

import edu.austral.model.Game;
import edu.austral.model.entities.Shot;

import java.util.List;

public class ShotController {

    public void shotFired(List<Shot> shots){
        Game.getINSTANCE().getEntities().addAll(shots);
        // TODO también agregar en el view
    }
}
