package edu.austral.util.generator;

import edu.austral.Constants;
import edu.austral.util.Vector2;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PositionPlayerGenerator implements Generator<Vector2>{

    private Random random = new Random();

    @Override
    public List<Vector2> generate(int amount, int xLength, int yLength) {
        List<Vector2> result = new ArrayList<>();
        int i = 0;
        while(i < amount){
            boolean succesfull = false;
            while(!succesfull) {
                Vector2 vect = generate(xLength, yLength);
                if(!collides(result, vect)) {
                    result.add(vect);
                    succesfull = true;
                }
            }
            i++;
        }
        return result;
    }

    public Vector2 generate(int xBound, int yBound){
        int xCoor = random.nextInt(xBound);
        int yCoor = random.nextInt(yBound);
        return new Vector2(xCoor, yCoor);
    }

    public boolean collides(List<Vector2> list, Vector2 vect){
        Shape shape = new Rectangle2D.Float(vect.x(), vect.y(), Constants.STARSHIP_HEIGHT, Constants.STARSHIP_WIDTH);
        int i = 0;
        while(i < list.size()){
            Shape aux = new Rectangle2D.Float(list.get(i).x(), list.get(i).y(), Constants.STARSHIP_HEIGHT, Constants.STARSHIP_WIDTH);
            boolean collides = collides(shape, aux);
            if(collides){ return true; }
            i += 1;
        }
        return false;
    }

    private boolean collides(Shape shape1, Shape shape2){
        return shape1.intersects(shape2.getBounds());
    }
}
