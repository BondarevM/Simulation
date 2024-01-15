package bondarev;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.setupDefaultEntitiesPosition();

        simulation.gameLoop();
    }
}