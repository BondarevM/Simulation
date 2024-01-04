package bondarev;

import bondarev.Coordinates;
import bondarev.Mapp;
import bondarev.Simulation;
import bondarev.entities.Creature;
import bondarev.entities.Grass;
import bondarev.entities.Herbivore;

import java.util.*;
import java.util.Map;

public class BFS {
    Creature creature;

    BFS(Creature creature) {
        this.creature = creature;
    }

    Queue<Coordinates> q = new LinkedList<>();
    Map<Coordinates, Coordinates> parentMap = new HashMap<>(); // Добавлено для хранения родительских координат

    public List<Coordinates> findShortestPathToTarget(Simulation simulation) {
        Set<Coordinates> checkedCoordinates = new HashSet<>();
        q.add(creature.coordinates);

        while (!q.isEmpty()) {
            Coordinates currentCoordinate = q.remove();

            if (!checkedCoordinates.contains(currentCoordinate)) {
                if (Mapp.myMap.get(currentCoordinate) instanceof Grass) {
                    // Если найдена трава, строим и возвращаем путь
                    return buildPath(currentCoordinate);

                } else {
                    Herbivore herbivoreForTest = new Herbivore(currentCoordinate, 1, 3);
                    checkedCoordinates.add(currentCoordinate);

                    for (Coordinates neighborCoordinate : herbivoreForTest.getAvailableMovesCells(simulation)) {
                        q.add(neighborCoordinate);
                        parentMap.put(neighborCoordinate, currentCoordinate); // Сохраняем родительскую координату
                    }
                }
            }
        }

        return null; // Если Grass не найдена, возвращаем null
    }

    private List<Coordinates> buildPath(Coordinates targetCoordinate) {
        List<Coordinates> path = new ArrayList<>();
        Coordinates current = targetCoordinate;

        while (!(current != null && path.contains(current))) {
            path.add(current);
            current = parentMap.get(current);

        }

        Collections.reverse(path);
        return path;
    }
}
