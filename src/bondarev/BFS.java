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

    //    Class<?> abc = typeOfOurTarget.getClass();
//
//
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
    Map<Coordinates, Coordinates> parentMap = new HashMap<>(); // Добавлено для хранения родительских координат

    public List<Coordinates> findShortestPathToTarget(Simulation simulation) {
        Set<Coordinates> checkedCoordinates = new HashSet<>();
        q.add(creature.coordinates);
        Coordinates координатыКролика = creature.coordinates;

        while (!q.isEmpty()) {
            Coordinates currentCoordinate = q.remove();
            int a = 1;
            if (!checkedCoordinates.contains(currentCoordinate)) {
//                Mapp.myMap.get(currentCoordinate) instanceof Grass
//                 (typeOfOurTarget.getClass().isInstance(Mapp.myMap.get(currentCoordinate)))

                if (typeOfOurTarget.getClass().isInstance(Mapp.myMap.get(currentCoordinate))) {
                    // Если найдена трава, строим и возвращаем путь
                    List<Coordinates> path = buildPath(currentCoordinate);
                    int a2 = 1;

                    return path;

                } else {
                    Herbivore herbivoreForTest = new Herbivore(currentCoordinate, 1, 3);
                    checkedCoordinates.add(currentCoordinate);
                    int aa = 1;

                    for (Coordinates neighborCoordinate : herbivoreForTest.getAvailableMovesCells(simulation)) {

                        if (!checkedCoordinates.contains(neighborCoordinate)) {
                            q.add(neighborCoordinate);
                            parentMap.put(neighborCoordinate, currentCoordinate); // Сохраняем родительскую координату
                        }
                    }

                    herbivoreForTest = null;
                }
            }
        }

        return null; // Если Grass не найдена, возвращаем null

    }

    private List<Coordinates> buildPath(Coordinates targetCoordinate) {
        List<Coordinates> path = new ArrayList<>();

        while (targetCoordinate != creature.coordinates) {
            path.add(targetCoordinate);
            targetCoordinate = parentMap.get(targetCoordinate);
            Coordinates координатыЕбаногоКролика = creature.coordinates;
            int a = 1;

        }

        Collections.reverse(path);
        return path;

//        List<Coordinates> path = new ArrayList<>();
//        Coordinates current = targetCoordinate;
//
//
//        while (!(current != null && path.contains(current))) {
//            path.add(current);
//            current = parentMap.get(current);
//
//        }
//
//        Collections.reverse(path);
//        return path;

    }


}
