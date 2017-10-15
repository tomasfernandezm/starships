package edu.austral.util.generator;

import edu.austral.util.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomVectorGenerator implements Generator<Vector2>{

    private Random random = new Random();

    @Override
    public List<Vector2> generate(int amount, int xLength, int yLength) {
        List<Vector2> result = new ArrayList<>();
        int i = 0;
        while(i < amount){
            Vector2 vector2 = new Vector2(random.nextInt(xLength), random.nextInt(yLength));
            result.add(vector2);
            i += 1;
        }
        return result;
    }
}
