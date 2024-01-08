package bondarev.entities;

import bondarev.BFS;
import bondarev.Coordinates;
import bondarev.CoordinatesShift;
import bondarev.Simulation;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Creature extends Entity {
    public final Integer health;
    public final Integer speed;

    public Creature(Coordinates coordinates, Integer health, Integer speed) {
        super(coordinates);
        this.health = health;
        this.speed = speed;
    }

      abstract public void makeMove(Simulation simulation);

    abstract void findTarget();

    public boolean isCellAvailableToMove(Coordinates coordinates, Simulation simulation) {
        return simulation.isCellEmpty(coordinates) || !((simulation.getEntity(coordinates) instanceof StaticEntities));
    }

    public Set<Coordinates> getAvailableMovesCells(Simulation simulation) {
        Set<Coordinates> result = new HashSet<>();

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
