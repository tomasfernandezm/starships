package edu.austral.model.entities.weapons;

import edu.austral.model.Player;
import edu.austral.model.entities.Shot;

public class StandardWeapon extends Weapon{

    public StandardWeapon(double shotInterval) {
        super(shotInterval, 0);
    }

    @Override
    protected Shot[] trigger(Player player) {
        // TODO implement trigger
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean canShoot() {
        return true;
    }
}
