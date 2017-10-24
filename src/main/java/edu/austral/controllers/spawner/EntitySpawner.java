package edu.austral.controllers.spawner;

import edu.austral.Constants;
import edu.austral.model.entities.Entity;
import edu.austral.util.Timer;

import java.util.Random;

public abstract class EntitySpawner<T extends Entity> {

    private Random random = new Random();
    private final Timer timer;
    protected final int xLimit = Constants.MAP_WIDTH;
    protected final int yLimit = Constants.MAP_HEIGHT;
    private final double averageMillisBetweenSpawns;

    EntitySpawner(Timer timer, double averageMillisBetweenSpawns) {
        this.timer = timer;
        this.averageMillisBetweenSpawns = averageMillisBetweenSpawns;
    }

    public abstract T spawn();

    public boolean canOperate(){
        return timer.canOperate();
    }

    void setNewTimerInterval(){
        float factor = random.nextFloat();
        timer.changeInterval(2*factor*averageMillisBetweenSpawns);
    }
}
