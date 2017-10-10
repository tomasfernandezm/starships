package edu.austral.model.entities.weapons;

import edu.austral.model.Player;
import edu.austral.model.entities.Shot;

public class TripleWeapon extends Weapon{

    public TripleWeapon(double shotInterval) {
        super(shotInterval, 300);
    }

    @Override
    protected Shot[] trigger(Player player) {
        // TODO implement trigger
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
