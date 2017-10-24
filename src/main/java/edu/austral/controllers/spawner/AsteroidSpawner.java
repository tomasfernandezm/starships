package edu.austral.controllers.spawner;

import edu.austral.controllers.spawner.strategy.asteroid.AsteroidSpawnStrategy;
import edu.austral.controllers.spawner.strategy.asteroid.BoundaryStrategy;
import edu.austral.model.entities.Asteroid;
import edu.austral.util.Timer;

public class AsteroidSpawner extends EntitySpawner<Asteroid>{

    private final int averageAsteroidSize;
    private final int averageAsteroidSpeed;
    private AsteroidSpawnStrategy strategy = new BoundaryStrategy();

    public AsteroidSpawner(double averageMillisBetweenSpawns, int averageAsteroidSize, int averageAsteroidSpeed) {
        super(new Timer(averageMillisBetweenSpawns), averageMillisBetweenSpawns);
        this.averageAsteroidSize = averageAsteroidSize;
        this.averageAsteroidSpeed = averageAsteroidSpeed;
    }

    @Override
    public Asteroid spawn() {
        setNewTimerInterval();
        return strategy.spawn(xLimit, yLimit, averageAsteroidSize, 1);
    }
}
