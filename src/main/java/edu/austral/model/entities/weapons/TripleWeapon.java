package edu.austral.model.entities.weapons;

import edu.austral.model.Player;
import edu.austral.model.entities.Shot;

public class TripleWeapon extends Weapon{

    public TripleWeapon(double shotInterval) {
        super(shotInterval, 300);
    }

    @Override
    protected Shot[] shoot(Player player) {
        // TODO implement shoot
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
