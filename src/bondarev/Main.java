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

//        simulation.render(simulation);
//        Entity entity = simulation.getEntity(new Coordinates(1, 0));
//        Creature herbivore = (Creature) entity;
//        BFS bfsForHerbivore = new BFS(herbivore);
//        List<Coordinates> traceForHerbivore = bfsForHerbivore.findShortestPathToTarget(simulation);

        int a = 123;

//        simulation.gameLoop();
    }
}