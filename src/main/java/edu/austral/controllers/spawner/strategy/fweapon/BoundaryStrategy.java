package edu.austral.controllers.spawner.strategy.fweapon;

import edu.austral.Constants;
import edu.austral.model.entities.Entity;
import edu.austral.model.entities.EntityEnum;
import edu.austral.model.entities.FWeapon;
import edu.austral.model.entities.weapons.Weapon;
import edu.austral.util.Vector2;
import edu.austral.util.generator.BoundaryDirectionGenerator;
import edu.austral.util.generator.BoundaryPositionGenerator;
import edu.austral.util.generator.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import static edu.austral.Constants.*;

public class BoundaryStrategy implements FWeaponSpawnStrategy{

    private Generator<Vector2> positionGenerator = new BoundaryPositionGenerator();
    private Generator<Vector2> directionGenerator = new BoundaryDirectionGenerator();
    private Random random = new Random();
    private List<EntityEnum> weaponEnums = new ArrayList<>();

    public BoundaryStrategy(List<EntityEnum> weaponEnums) {
        this.weaponEnums = weaponEnums;
    }

    @Override
    public FWeapon spawn(Map<EntityEnum, Supplier<Weapon>> map, int xLimit, int yLimit) {
        Vector2 position = positionGenerator.generate(xLimit, yLimit);
        Vector2 direction = directionGenerator.generate(xLimit, yLimit);
        Weapon weapon = map.get(getRandomEnum()).get();
        return new FWeapon(FWEAPON_LIFE,position, direction, FWEAPON_SPEED, weapon);
    }

    private EntityEnum getRandomEnum(){
        int option = (int) Math.floor(random.nextInt(weaponEnums.size()));
        return weaponEnums.get(option);
    }


}
