package bondarev.entities;

import bondarev.*;

import java.util.*;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, Integer health, Integer speed) {
        super(coordinates, health, speed);
    }

    @Override
    public void makeMove(Simulation simulation) {
        try {
            BFS bfs = new BFS(this);
            List<Coordinates> trace = bfs.findShortestPathToTarget(simulation);
            java.util.Map<Coordinates, Entity> copiedMap = simulation.MAP.getCopiedMap();

            if (!(simulation.MAP.getEntity(this.coordinates) instanceof Predator)) {
                copiedMap.remove(this.coordinates);
            }
            this.coordinates = trace.get(0);
            copiedMap.put(trace.get(0), this);
            simulation.MAP.equatingMaps(copiedMap);
        } catch (NullPointerException e) {
        }
    }

    @Override
    public Set<Coordinates> getAvailableMovesCells(Simulation simulation) {
        Set<Coordinates> availableMovesCells = super.getAvailableMovesCells(simulation);
        Set<Coordinates> copidedAvailableMovesCells = new HashSet<>(availableMovesCells);
        for (Coordinates cell : availableMovesCells) {
            if (simulation.MAP.getEntity(cell) instanceof Predator || simulation.MAP.getEntity(cell) instanceof Herbivore) {
                copidedAvailableMovesCells.remove(cell);
            }
        }
        availableMovesCells = copidedAvailableMovesCells;
        return availableMovesCells;
    }
}
