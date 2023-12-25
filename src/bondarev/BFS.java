package bondarev;

import bondarev.Coordinates;
import bondarev.entities.Creature;
import bondarev.entities.Grass;
import bondarev.entities.Herbivore;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {
    Creature creature;

    BFS(Creature creature) {
        this.creature = creature;
    }

    Queue<Coordinates> queue = new LinkedList<>();

    public Coordinates findTarget(Simulation simulation) {
        Set<Coordinates> checktedCoordinates = new HashSet<>();

        for (Coordinates coordiate : creature.getAvailableMovesCells(simulation)) {
            queue.add(coordiate);
        }

        while (!queue.isEmpty()) {
            Coordinates coordinateInQuestion = queue.remove();

            if (!checktedCoordinates.contains(coordinateInQuestion)) {
                if (Map.map.get(coordinateInQuestion) instanceof Grass) {
                    return coordinateInQuestion;

                } else {
                    Herbivore herbivoreForTest = new Herbivore(coordinateInQuestion, 1, 3);
                    checktedCoordinates.add(coordinateInQuestion);

                    for (Coordinates coordinate : herbivoreForTest.getAvailableMovesCells(simulation)) {
                        queue.add(coordinate);
                    }

                }
            }

        }

        return null;
    }

}
