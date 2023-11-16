
public abstract  class Creature extends Entity {
    public final Integer health;
    public final Integer speed;

    public Creature(Integer health, Integer speed) {
        this.health = health;
        this.speed = speed;
    }

    abstract void makeMove();


}
