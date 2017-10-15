package edu.austral.util.generator;

import edu.austral.util.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoundaryVectorGenerator implements Generator<Vector2>{

    private Random random = new Random();

    public List<Vector2> generate(int amount, int xLength, int yLength){
        List<Vector2> result = new ArrayList<>();
        int i = 0;
        while(i < amount){
            result.add(generate(xLength, yLength));
            i++;
        }
        return result;
    }

    private Vector2 generate(int xLength, int yLength){
        int side = random.nextInt(3);
        float x = 0;
        float y = 0;
        switch(side){
            case 0:
                x = random.nextInt(xLength);
                y = 0;
                break;
            case 1:
                x = xLength;
                y = random.nextInt(yLength);
                break;
            case 2:
                x = random.nextInt(xLength);
                y = yLength;
                break;
            case 3:
                x = 0;
                y = random.nextInt(yLength);
                break;
        }
        return new Vector2(x, y);
    }
}
