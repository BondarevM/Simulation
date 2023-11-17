package bondarev.entities;

import bondarev.Coordinates;

public abstract  class Creature extends Entity {
    public final Integer health;
    public final Integer speed;

    public Creature(Coordinates coordinates, Integer health, Integer speed) {
        super(coordinates);
        this.health = health;
        this.speed = speed;
    }

    abstract void makeMove();


}
