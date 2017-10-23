package edu.austral.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import edu.austral.util.json.JSONGenericParser;
import edu.austral.util.json.JSONGenericWriter;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class JSONGenericIOTest {

    @Test
    public void testJson(){
        Pair pair1 = new Pair(5, 5);
        Pair pair2 = new Pair(1, 1);

        List<Pair> list = new ArrayList<>();
        list.add(pair1);
        list.add(pair2);

        String path = "src/main/resources/config/keyConfig.json";

        JSONGenericWriter<Pair> jsonGenericWriter = new JSONGenericWriter<>();
        jsonGenericWriter.write(list, path, "pairs2.json");

        JSONGenericParser<Pair> jsonGenericParser = new JSONGenericParser<>();
        List<Pair> result = jsonGenericParser.read(path +  "/" + "pairs2.json");
        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
        int a = result.get(0).x;
        assertThat(((Pair) result.get(0)).x).isEqualTo(list.get(0).x);
        assertThat(result.get(0).y).isEqualTo(list.get(0).y);
    }

    class Pair implements Comparable<Pair>{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if(o.x == x && o.y == y) return 0;
            return 1;
        }
    }
}
