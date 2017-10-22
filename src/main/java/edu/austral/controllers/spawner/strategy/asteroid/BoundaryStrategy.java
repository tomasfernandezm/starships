package edu.austral.controllers.spawner.strategy.asteroid;

import edu.austral.model.entities.Asteroid;
import edu.austral.util.Vector2;
import edu.austral.util.generator.BoundaryDirectionGenerator;
import edu.austral.util.generator.BoundaryPositionGenerator;
import edu.austral.util.generator.Generator;

import java.util.Random;

public class BoundaryStrategy implements AsteroidSpawnStrategy{

    private Random random = new Random();
    private Generator<Vector2> positionGenerator = new BoundaryPositionGenerator();
    private Generator<Vector2> directionGenerator = new BoundaryDirectionGenerator();

    @Override
    public Asteroid spawn(int xLimit, int yLimit, int averageSize, int speed) {
        Vector2 position = positionGenerator.generate(xLimit, yLimit);
        Vector2 direction = directionGenerator.generate(xLimit, yLimit);
        float size = random.nextFloat()*2*averageSize;
        return new Asteroid(position, direction, speed, size);
    }
}
