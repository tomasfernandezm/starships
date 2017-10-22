package edu.austral.controllers.spawner.strategy.asteroid;

import edu.austral.model.entities.Asteroid;

public interface AsteroidSpawnStrategy {

    Asteroid spawn(int xLimit, int yLimit, int averageSize, int averageSpeed);
}
