package edu.austral.model.entities.weapons;

import edu.austral.model.Player;
import edu.austral.model.entities.Shot;
import edu.austral.model.entities.Starship;
import edu.austral.util.Vector2;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StandardWeapon extends Weapon {

    public StandardWeapon() {
        super(0);
    }

    @Override
    public List<Shot> shootW(Player player, Starship starship) {
        List<Shot> result = new ArrayList<>();
        Vector2 shipPosition = starship.getPosition();
        Shape starshipShape = starship.getShape();
        float xPosition = (float) starship.getShape().getBounds().getHeight() * starship.getDirection().x() + shipPosition.x();
        float yPosition = (float) starship.getShape().getBounds().getWidth() * starship.getDirection().y() + shipPosition.y();
        Shot shot = new Shot(new Vector2(xPosition, yPosition), player.getShip().getDirection(), player);
        result.add(shot);
        return result;
    }

    @Override
    public boolean hasCapacity() {
        return true;
    }
}
