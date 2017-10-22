package edu.austral.model.entities.weapons;

import edu.austral.model.Player;
import edu.austral.model.entities.Shot;
import edu.austral.model.entities.Starship;
import edu.austral.util.Vector2;

import java.util.LinkedList;
import java.util.List;

public class TripleWeapon extends Weapon{

    public TripleWeapon() {
        super(300);
    }

    @Override
    public List<Shot> shootW(Player player, Starship starship) {
        List<Shot> result = new LinkedList<>();

        Vector2 shipPosition = starship.getPosition();
        Vector2 shipDirection = starship.getDirection();
        int shipHeght = starship.getShape().getBounds().height;
        Vector2 bulletPosition1 = shipPosition.$plus(shipDirection.rotate(-100).$times(shipHeght));
        Vector2 bulletPosition2 = shipPosition.$plus(shipDirection.rotate(100).$times(shipHeght));
        Vector2 bulletPosition3 = shipPosition.$plus(shipDirection.$times(shipHeght));
        result.add(new Shot(bulletPosition1, shipDirection.rotate(-100), player));
        result.add(new Shot(bulletPosition2, shipDirection.rotate(100), player));
        result.add(new Shot(bulletPosition3, shipDirection, player));
        capacity -= 3;
        return result;
    }

    @Override
    public boolean hasCapacity() {
        return capacity >= 3;
    }
}
