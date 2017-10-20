package edu.austral.util;

import edu.austral.util.generator.PositionPlayerGenerator;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PositionPlayerGeneratorTest {

    @Test
    public void testListVectorGeneration(){
        PositionPlayerGenerator positionVectorGenerator = new PositionPlayerGenerator();
        List<Vector2> vectors = positionVectorGenerator.generate(10, 1000, 1000);
        assertThat(vectors).hasSize(10);
        int i = 0;
        while(i < vectors.size()){
            Vector2 current = vectors.remove(i);
            for(Vector2 v: vectors){
                assertThat(positionVectorGenerator.collides(vectors, current)).isFalse();
            }
        }
    }
}
