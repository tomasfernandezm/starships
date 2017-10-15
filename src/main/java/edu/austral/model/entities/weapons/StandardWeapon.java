package edu.austral.model.entities.weapons;

import edu.austral.model.Player;
import edu.austral.model.entities.Shot;
import edu.austral.model.entities.Starship;
import edu.austral.util.Vector2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StandardWeapon extends Weapon{

    public StandardWeapon() {
        super(0);
    }

    @Override
    public List<Shot> shoot(Player player, Starship starship) {
        List<Shot> result = new LinkedList<>();
        if(!timer.canOperate()) return result;
        else {
            // TODO think creation logic
            return result;
        }
    }

    @Override
    public boolean canShoot() {
        return true;
    }
}
