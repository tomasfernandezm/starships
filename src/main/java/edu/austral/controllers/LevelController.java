package edu.austral.controllers;

import edu.austral.controllers.spawner.AsteroidSpawner;
import edu.austral.controllers.spawner.EntitySpawner;
import edu.austral.controllers.spawner.FWeaponSpawner;
import edu.austral.model.Game;
import edu.austral.model.entities.Asteroid;
import edu.austral.model.entities.FWeapon;
import edu.austral.view.View;
import edu.austral.view.entities.AsteroidSprite;
import edu.austral.view.entities.FWeaponSprite;

public class LevelController {

    private View view;
    private EntitySpawner<Asteroid> asteroidSpawner = new AsteroidSpawner(2000, 40, 20);
    private EntitySpawner<FWeapon> weaponSpawner = new FWeaponSpawner(1000);

    public LevelController(View view){
        this.view = view;
    }

    public void operate(){
        if(asteroidSpawner.canOperate()) spawnAsteroid();
        if(weaponSpawner.canOperate()) spawnFWeapon();
    }

    private void spawnAsteroid() {
        Asteroid asteroid = asteroidSpawner.spawn();
        view.add(new AsteroidSprite(asteroid));
        Game.getINSTANCE().addEntity(asteroid);
    }

    private void spawnFWeapon() {
        FWeapon weapon = weaponSpawner.spawn();
        view.add(new FWeaponSprite(weapon));
        Game.getINSTANCE().addEntity(weapon);
    }

}
