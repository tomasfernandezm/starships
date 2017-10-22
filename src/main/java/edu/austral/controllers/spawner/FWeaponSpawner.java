package edu.austral.controllers.spawner;


import edu.austral.controllers.spawner.strategy.fweapon.BoundaryStrategy;
import edu.austral.controllers.spawner.strategy.fweapon.FWeaponSpawnStrategy;
import edu.austral.model.entities.Entity;
import edu.austral.model.entities.EntityEnum;
import edu.austral.model.entities.FWeapon;
import edu.austral.model.entities.weapons.DoubleWeapon;
import edu.austral.model.entities.weapons.StandardWeapon;
import edu.austral.model.entities.weapons.TripleWeapon;
import edu.austral.model.entities.weapons.Weapon;
import edu.austral.util.Timer;
import edu.austral.util.Vector2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static edu.austral.model.entities.EntityEnum.*;
import static edu.austral.model.entities.EntityEnum.TRIPLE_WEAPON;

public class FWeaponSpawner extends EntitySpawner<FWeapon>{

    List<EntityEnum> weapons = new ArrayList<>();
    private FWeaponSpawnStrategy strategy;
    private Map<EntityEnum, Supplier<Weapon>> weaponSupplier = new HashMap<>();

    public FWeaponSpawner(double averageMillisBetweenSpawns) {
        super(new Timer(averageMillisBetweenSpawns), averageMillisBetweenSpawns);
        weapons.add(SINGLE_WEAPON);
        weapons.add(DOUBLE_WEAPON);
        weapons.add(TRIPLE_WEAPON);
        weaponSupplier.put(SINGLE_WEAPON, StandardWeapon::new);
        weaponSupplier.put(DOUBLE_WEAPON, DoubleWeapon::new);
        weaponSupplier.put(TRIPLE_WEAPON, TripleWeapon::new);
        strategy = new BoundaryStrategy(weapons);
    }

    @Override
    public FWeapon spawn() {
        setNewTimerInterval();
        return strategy.spawn(weaponSupplier, xLimit, yLimit);
    }
}
