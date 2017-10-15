package edu.austral.util;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class BoundaryVectorGeneratorTest{

    int yLength = 10;
    int xLength = 10;

    @Test
    public void testListVectorGeneration(){
        BoundaryVectorGenerator bvg = new BoundaryVectorGenerator();
        List<Vector2> list = bvg.generate(10, xLength, yLength);
        for(Vector2 v: list){
            boolean result = isTopLimit(v) || isRightLimit(v) || isLeftLimit(v) || isBottomLimit(v);
            assertThat(result).isTrue();
        }
    }

    private boolean isTopLimit(Vector2 vector){
        return vector.y() == 0;
    }

    private boolean isRightLimit(Vector2 vector){
        return vector.x() == xLength;
    }

    private boolean isBottomLimit(Vector2 vector){
        return vector.y() == yLength;
    }

    private boolean isLeftLimit(Vector2 vector){
        return vector.x() == xLength;
    }
}
