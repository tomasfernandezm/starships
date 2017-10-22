package edu.austral.controllers.spawner.strategy.asteroid;

import edu.austral.model.entities.Asteroid;
import edu.austral.util.Vector2;
import edu.austral.util.generator.Generator;
import edu.austral.util.generator.RandomVectorGenerator;
import sun.java2d.loops.GeneralRenderer;

import java.util.Random;

public class RandomStrategy implements AsteroidSpawnStrategy{

    private Random random = new Random();
    private Generator<Vector2> generator = new RandomVectorGenerator();

    @Override
    public Asteroid spawn(int xLimit, int yLimit, int averageSize, int averageSpeed) {
        Vector2 position = generator.generate(xLimit, yLimit);
        Vector2 direction = generator.generate(xLimit, yLimit).unitary();
        float size = random.nextFloat()*2*averageSize;
        float speed = random.nextFloat()*2*averageSpeed;
        return new Asteroid(position, direction, size, speed);
    }
}
