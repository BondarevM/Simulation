package bondarev.entities;

import bondarev.Coordinates;

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
}
