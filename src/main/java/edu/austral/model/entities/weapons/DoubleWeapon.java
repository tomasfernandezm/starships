package edu.austral.model.entities.weapons;

import edu.austral.model.Player;
import edu.austral.model.entities.Shot;

public class DoubleWeapon extends Weapon{

    public DoubleWeapon(double shotInterval) {
        super(shotInterval, 200);
    }

    @Override
    protected Shot[] trigger(Player player) {
        // TODO implement trigger
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
