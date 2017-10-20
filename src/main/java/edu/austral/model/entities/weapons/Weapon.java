package edu.austral.model.entities.weapons;

import edu.austral.Constants;
import edu.austral.model.Player;
import edu.austral.model.entities.Shot;
import edu.austral.model.entities.Starship;
import edu.austral.util.Timer;

import java.util.List;
import java.util.Optional;

public abstract class Weapon {

    private final double shotInterval = Constants.SHOOT_INTERVAL;
    protected int capacity;
    Timer timer = new Timer(Constants.SHOOT_INTERVAL);

    Weapon(int capacity) {
        this.capacity = capacity;
    }

    public abstract List<Shot> shootW(Player player, Starship starship);

    public Optional<List<Shot>> shoot(Player player, Starship starship){ ;
        if(canShoot()) {
            Optional<List<Shot>> listOptional = Optional.of(shootW(player, starship));
            timer.restart();
            return listOptional;
        }
        else return Optional.empty();
    };

    public boolean canShoot(){
        return hasCapacity() && timer.canOperate();
    }

    public abstract boolean hasCapacity();
}
