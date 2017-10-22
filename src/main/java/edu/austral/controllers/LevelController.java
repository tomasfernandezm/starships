package edu.austral.controllers;

import edu.austral.GameController;
import edu.austral.model.Game;
import edu.austral.model.entities.Asteroid;
import edu.austral.model.entities.FWeapon;
import edu.austral.util.Timer;
import edu.austral.util.Vector2;
import edu.austral.util.generator.BoundaryDirectionGenerator;
import edu.austral.util.generator.BoundaryVectorGenerator;
import edu.austral.util.generator.Generator;
import edu.austral.view.View;
import edu.austral.view.entities.AsteroidSprite;
import edu.austral.view.entities.FWeaponSprite;

import java.util.Random;

public class LevelController {

    private Random random = new Random();
    private Timer asteroidTimer;
    private View view;
    private Timer weaponTimer;
    private double averageMillisBetweenAsteroidSpawn = 2000;
    private double averageMillisBetweenWeaponSpawn = 10000;
    private float asteroidSizeMean = 40;
    private Generator<Vector2> boundaryVectorGenerator = new BoundaryVectorGenerator();
    private Generator<Vector2> boundaryDirectionGenerator = new BoundaryDirectionGenerator();
    private int xDimension;
    private int yDimension;

    public LevelController(){
        asteroidTimer = new Timer(averageMillisBetweenAsteroidSpawn);
        weaponTimer = new Timer(averageMillisBetweenWeaponSpawn);
        view = GameController.INSTANCE.view;
        xDimension = Game.getINSTANCE().getMap().getXLength();
        yDimension = Game.getINSTANCE().getMap().getYLength();
    }

    public void operate(){
        if(asteroidTimer.canOperate()) spawnAsteroid();
        if(weaponTimer.canOperate()) spawnFWeapon();
    }

    // TODO generate speed randomly
    private void spawnAsteroid() {
        float size = random.nextFloat()*2*asteroidSizeMean;
        Vector2 position = boundaryVectorGenerator.generate(xDimension, yDimension);
        Vector2 direction = boundaryDirectionGenerator.generate(xDimension, yDimension);
        Asteroid asteroid = new Asteroid(position, direction,1, size);
        view.add(new AsteroidSprite(asteroid));
        Game.getINSTANCE().addEntity(asteroid);
        setNewTimerInterval(asteroidTimer, averageMillisBetweenAsteroidSpawn);
    }

    private void spawnFWeapon() {
        Vector2 position = boundaryVectorGenerator.generate(xDimension, yDimension);
        Vector2 direction = boundaryDirectionGenerator.generate(xDimension, yDimension);
        FWeapon weapon = new FWeapon(100, position, direction, 1);
        view.add(new FWeaponSprite(weapon));
        Game.getINSTANCE().addEntity(weapon);
        setNewTimerInterval(weaponTimer, averageMillisBetweenWeaponSpawn);
    }

    private void setNewTimerInterval(Timer timer, double mean){
        float factor = random.nextFloat();
        timer.changeInterval(2*factor*mean);
    }
}
