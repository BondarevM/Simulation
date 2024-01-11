package bondarev;

import bondarev.entities.Creature;
import bondarev.entities.Entity;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.setupDefaultEntitiesPosition();

       simulation.gameLoop();
    }
}