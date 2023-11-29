package bondarev;

import bondarev.entities.Creature;
import bondarev.entities.Entity;

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

        Entity entity = simulation.getEntity(new Coordinates(2,10));
        Creature creature = (Creature) entity;
        Set<Coordinates> availableCoordinatesToMove = creature.getAvailableMovesCells(simulation);

    int a = 123;

//        simulation.gameLoop();
    }
}