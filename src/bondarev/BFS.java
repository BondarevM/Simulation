package bondarev;

import bondarev.entities.*;

import java.util.*;

public class BFS {
    Creature creature;
    Object typeOfOurTarget = new Object();

    public BFS(Creature creature) {
        this.creature = creature;

        if (creature instanceof Herbivore) {
            typeOfOurTarget = new Grass(creature.coordinates);
        }
        if (creature instanceof Predator) {
            typeOfOurTarget = new Herbivore(creature.coordinates, 3, 1);
        }

    }

    Queue<Coordinates> q = new LinkedList<>();
    java.util.Map<Coordinates, Coordinates> parentMap = new HashMap<>();

    public List<Coordinates> findShortestPathToTarget(Simulation simulation) {
        Set<Coordinates> checkedCoordinates = new HashSet<>();
        q.add(creature.coordinates);

        while (!q.isEmpty()) {
            Coordinates currentCoordinate = q.remove();
            if (!checkedCoordinates.contains(currentCoordinate)) {

                if (typeOfOurTarget.getClass().isInstance(simulation.MAP.getEntity(currentCoordinate))) {

                    List<Coordinates> path = buildPath(currentCoordinate);
                    return path;

                } else {
                    Creature creatureFortest = new Predator(currentCoordinate, 1, 3, 1);

                    if (this.creature instanceof Herbivore) {
                        creatureFortest = new Herbivore(currentCoordinate, 1, 3);
                    }
                    if (this.creature instanceof Predator) {
                        creatureFortest = new Predator(currentCoordinate, 1, 3, 1);
                    }

                    checkedCoordinates.add(currentCoordinate);

                    for (Coordinates neighborCoordinate : creatureFortest.getAvailableMovesCells(simulation)) {
                        if (!checkedCoordinates.contains(neighborCoordinate)) {
                            q.add(neighborCoordinate);
                            parentMap.put(neighborCoordinate, currentCoordinate); // Сохраняем родительскую координату
                        }
                    }
                }
            }
        }
        return null;
    }

    private List<Coordinates> buildPath(Coordinates targetCoordinate) {
        List<Coordinates> path = new ArrayList<>();

        while (targetCoordinate != creature.coordinates) {
            path.add(targetCoordinate);
            targetCoordinate = parentMap.get(targetCoordinate);
        }

        Collections.reverse(path);
        return path;
    }
}
