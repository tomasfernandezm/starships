package edu.austral.model.entities.weapons;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import edu.austral.model.Constants;
import edu.austral.model.Player;
import edu.austral.model.entities.Shot;
import edu.austral.model.entities.Starship;
import edu.austral.util.Timer;
import edu.austral.util.Vector2;

import java.util.List;

public abstract class Weapon {

    private final double shotInterval = Constants.SHOOT_INTERVAL;
    private int capacity;
    Timer timer = new Timer(Constants.SHOOT_INTERVAL);

    public Weapon(int capacity) {
        this.capacity = capacity;
    }

    public abstract List<Shot> shoot(Player player, Starship starship);

    public boolean canShoot(){
        return capacity > 0 && timer.canOperate();
    }
}
