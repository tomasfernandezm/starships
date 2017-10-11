package edu.austral.model.entities.weapons;

import edu.austral.model.Player;
import edu.austral.model.entities.Shot;
import edu.austral.util.Timer;

public abstract class Weapon {

    private final double shotInterval;
    private int capacity;
    private Timer timer;

    public Weapon(double shotInterval, int capacity) {
        this.shotInterval = shotInterval;
        this.capacity = capacity;
        this.timer = timer;
    }

    public abstract Shot[] shoot(Player player);

    public boolean canShoot(){
        return capacity > 0;
    }
}
