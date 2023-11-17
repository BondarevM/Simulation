package bondarev.entities;

import bondarev.Coordinates;

public class Herbivore extends Creature {


    public Herbivore(Coordinates coordinates, Integer health, Integer speed) {
        super(coordinates, health, speed);
    }

    @Override
    public void makeMove() {
    }

    public void eatGrass(){
    }
}
