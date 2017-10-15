package edu.austral.util.generator;

import java.util.List;

public interface Generator<T> {

    List<T> generate(int amount, int xLength, int yLength);
}
