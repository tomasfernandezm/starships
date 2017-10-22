package edu.austral.controllers.spawner.strategy.fweapon;

import edu.austral.model.entities.Entity;
import edu.austral.model.entities.EntityEnum;
import edu.austral.model.entities.FWeapon;
import edu.austral.model.entities.weapons.Weapon;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public interface FWeaponSpawnStrategy {

    FWeapon spawn(Map<EntityEnum, Supplier<Weapon>> map, int xLimit, int yLimit);
}
