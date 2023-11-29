package bondarev.entities;

import bondarev.Coordinates;
import bondarev.CoordinatesShift;
import bondarev.Simulation;

import java.util.Set;

public class Predator extends Creature {
    public Predator(Coordinates coordinates, Integer health, Integer speed, int powerOfAttack) {
        super(coordinates, health, speed);
        this.powerOfAttack = powerOfAttack;
    }

    int powerOfAttack;
    @Override
    void makeMove() {
    }

    void makeAttack (){
    }

    @Override
    void findTarget() {

    }
//    @Override
//    protected Set<Coordinates> getAvailableMovesCells(Simulation simulation){
//
//    }


//    @Override
//    protected Set<CoordinatesShift> getCreatureMoves() {
//        return null;
//    }
}
