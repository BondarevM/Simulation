package bondarev;

import bondarev.Coordinates;
import bondarev.Mapp;
import bondarev.Simulation;
import bondarev.entities.*;

import java.util.*;
import java.util.Map;

public class BFS {
    Creature creature;
    Object typeOfOurTarget = new Object();
    Class<?> abc = typeOfOurTarget.getClass();


    BFS(Creature creature) {
        this.creature = creature;

        if (creature instanceof Herbivore){
            typeOfOurTarget = new Grass(creature.coordinates);
        }
        if (creature instanceof Predator){
            typeOfOurTarget = new Herbivore(creature.coordinates,3,1);
        }

    }


    Queue<Coordinates> q = new LinkedList<>();
    Map<Coordinates, Coordinates> parentMap = new HashMap<>(); // Добавлено для хранения родительских координат

    public List<Coordinates> findShortestPathToTarget(Simulation simulation) {
        Set<Coordinates> checkedCoordinates = new HashSet<>();
        q.add(creature.coordinates);

        while (!q.isEmpty()) {
            Coordinates currentCoordinate = q.remove();

            if (!checkedCoordinates.contains(currentCoordinate)) {
                //Mapp.myMap.get(currentCoordinate) instanceof Grass

                if (typeOfOurTarget.getClass().isInstance(Mapp.myMap.get(currentCoordinate))) {
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
