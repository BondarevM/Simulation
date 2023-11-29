package bondarev.entities;

import bondarev.BFS;
import bondarev.Coordinates;
import bondarev.CoordinatesShift;
import bondarev.Simulation;

import java.util.Set;

public class Herbivore extends Creature {


    public Herbivore(Coordinates coordinates, Integer health, Integer speed) {
        super(coordinates, health, speed);
    }

    @Override
    public void makeMove() {
    }

    @Override
    void findTarget() {

    }
//    @Override
//    public boolean isCellAvailableToMove(Coordinates coordinates, Simulation simulation){
//        super(getAvailableMovesCells())
//    }

//    @Override
//    protected Set<CoordinatesShift> getCreatureMoves() {
//        return null;
//    }




}
