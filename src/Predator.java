public class Predator extends Creature {
    public Predator(Integer health, Integer speed, int powerOfAttack) {
        super(health, speed);
        this.powerOfAttack = powerOfAttack;
    }

    int powerOfAttack;
    @Override
    void makeMove() {
    }

    void makeAttack (){

    }
}
