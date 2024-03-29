package bondarev.entities;

import bondarev.*;
import bondarev.Map;
import bondarev.Simulation;

import java.util.*;

public class Predator extends Creature {
    public Predator(Coordinates coordinates, Integer health, Integer speed, int powerOfAttack) {
        super(coordinates, health, speed);
        this.powerOfAttack = powerOfAttack;
    }

    int powerOfAttack;

    @Override
    public void makeMove(Simulation simulation) {
        try {
            super.makeMove(simulation);
        } catch (NullPointerException e) {
        }
    }

    @Override
    public Set<Coordinates> getAvailableMovesCells(Simulation simulation) {
        Set<Coordinates> availableMovesCells = super.getAvailableMovesCells(simulation);
        Set<Coordinates> copidedAvailableMovesCells = new HashSet<>(availableMovesCells);
        for (Coordinates cell : availableMovesCells) {
            if (simulation.MAP.getEntity(cell) instanceof Grass || simulation.MAP.getEntity(cell) instanceof Predator) {
                copidedAvailableMovesCells.remove(cell);
            }
        }
        availableMovesCells = copidedAvailableMovesCells;
        return availableMovesCells;
    }
}
