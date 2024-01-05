package bondarev;

import bondarev.entities.Creature;
import bondarev.entities.Entity;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
//        Map map = new Map();
        simulation.setupDefaultEntitiesPosition();
//
//
//
        simulation.render(simulation);

        Entity entity = simulation.getEntity(new Coordinates(1,0));
        Entity entity1 = simulation.getEntity(new Coordinates(0,2));

        Creature herbivore = (Creature) entity;
        Creature predator = (Creature) entity1;


//        Set<Coordinates> availableCoordinatesToMove = creature.getAvailableMovesCells(simulation);

        BFS bfsForHerbivore = new BFS(herbivore);
        BFS bfsForPredator = new BFS(predator);


        List<Coordinates> traceForHerbivore = bfsForHerbivore.findShortestPathToTarget(simulation);
        List<Coordinates> traceForPredator = bfsForPredator.findShortestPathToTarget(simulation);





    int a = 123;

//        simulation.gameLoop();
    }
}