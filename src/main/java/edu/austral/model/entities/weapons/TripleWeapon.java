package edu.austral.model.entities.weapons;

import edu.austral.model.Player;
import edu.austral.model.entities.Shot;
import edu.austral.model.entities.Starship;

import java.util.LinkedList;
import java.util.List;

public class TripleWeapon extends Weapon{

    public TripleWeapon() {
        super(300);
    }

    @Override
    public List<Shot> shootW(Player player, Starship starship) {
        List<Shot> result = new LinkedList<>();
        if(!timer.canOperate()) return result;
        else {
            // TODO think creation logic
            return result;
        }
    }

    @Override
    public boolean hasCapacity() {
        return capacity >= 3;
    }
}
