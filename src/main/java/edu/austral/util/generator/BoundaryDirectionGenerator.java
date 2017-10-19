package edu.austral.util.generator;

import edu.austral.util.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoundaryDirectionGenerator implements Generator<Vector2>{

    private Random random = new Random();

    @Override
    public List<Vector2> generate(int amount, int xLength, int yLength) {
        int i = 0;
        List<Vector2> result = new ArrayList<>();
        while(i < amount){
            result.add(generate(xLength, yLength));
            i+=1;
        }
        return result;
    }

    @Override
    public Vector2 generate(int xLength, int yLength) {
        int x = random.nextInt(xLength);
        int y = random.nextInt(yLength);
        int r = random.nextInt(3);
        Vector2 result;
        if(r == 0) result = new Vector2(x, y);
        else if (r == 1) result = new Vector2(-1*x, y);
        else if(r == 2) result = new Vector2(-1*x, -1*y);
        else return new Vector2(x, -1 * y);
        return result.unitary();
    }
}
