package bondarev.entities;

import bondarev.*;

import java.util.*;

public abstract class Creature extends Entity {
    public final Integer health;
    public final Integer speed;

    public Creature(Coordinates coordinates, Integer health, Integer speed) {
        super(coordinates);
        this.health = health;
        this.speed = speed;
    }

      public void makeMove(Simulation simulation){

          BFS bfs = new BFS(this);
          List<Coordinates> trace = bfs.findShortestPathToTarget(simulation);
          Map<Coordinates, Entity> copiedMap = new HashMap<>(Mapp.myMap);
          copiedMap.remove(this.coordinates);
          this.coordinates=trace.get(0);
          copiedMap.put(trace.get(0),this);


          Mapp.myMap = copiedMap;
      }
    public boolean isCellAvailableToMove(Coordinates coordinates, Simulation simulation) {
        return simulation.isCellEmpty(coordinates) || !((simulation.getEntity(coordinates) instanceof StaticEntities));
    }

    public Set<Coordinates> getAvailableMovesCells(Simulation simulation) {
        Set<Coordinates> result = new HashSet<>();
        int a = 1;
        for (CoordinatesShift shift : getCreatureMoves()) {
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinates = coordinates.shift(shift);
                if (isCellAvailableToMove(newCoordinates, simulation)) {
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }

    public Set<CoordinatesShift> getCreatureMoves() {
        Set<CoordinatesShift> shifts = new HashSet<>();
        shifts.add(new CoordinatesShift(0, 1));
        shifts.add(new CoordinatesShift(1, 0));
        shifts.add(new CoordinatesShift(0, -1));
        shifts.add(new CoordinatesShift(-1, 0));

        return shifts;
    }
}