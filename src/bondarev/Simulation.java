package bondarev;

import java.util.*;

import bondarev.entities.*;

public class Simulation {
    public Map MAP = new Map();
    private String halfOfSpace = " ";
    private final String EMPTY_CELL = " □ " + halfOfSpace;
    private final String PREDATOR_CELL = " \uD83E\uDD81 ";
    private final String HERBIVORE_CELL = " \uD83D\uDC07 ";
    private final String TREE_CELL = " \uD83C\uDF33 ";
    private final String ROCK_CELL = " ⛰ ";
    private final String GRASS_CELL = " ✿ ";

    public void render(Simulation simulation) {
        for (int y = 10; y >= 0; y--) {
            String line = "";
            for (int x = 0; x <= 40; x++) {
                Coordinates coordinates = new Coordinates(x, y);

                if (MAP.isCellEmpty(coordinates)) {
                    line += EMPTY_CELL;
                } else {
                    line += getEntityImage(simulation.MAP.getEntity(coordinates));
                }
            }
            System.out.println(line);
        }
    }

    private String getEntityImage(Entity entity) {
        if (entity instanceof Predator) {
            return PREDATOR_CELL;
        }
        if (entity instanceof Herbivore) {
            return HERBIVORE_CELL;
        }
        if (entity instanceof Tree) {
            return TREE_CELL;
        }
        if (entity instanceof Rock) {
            return ROCK_CELL;
        }
        if (entity instanceof Grass) {
            return GRASS_CELL;
        }
        return "";
    }

    public void checkingNumberOfCreatures() {
        List<Entity> listOfHerbivores = new ArrayList<>();
        List<Entity> listOfGrasses = new ArrayList<>();
        HashMap<Coordinates, Entity> copiedMap = MAP.getCopiedMap();

        for (java.util.Map.Entry<Coordinates, Entity> entry : copiedMap.entrySet()) {
            if (entry.getValue() instanceof Herbivore) {
                listOfHerbivores.add(entry.getValue());
            }
            if (entry.getValue() instanceof Grass) {
                listOfGrasses.add(entry.getValue());
            }
        }

        if (listOfHerbivores.size() < 3) {
            setHerbivores();
        }

        if (listOfGrasses.size() < 3) {
            setGrasses();
        }
    }

    public int getRandomNumberX() {
        return (int) ((Math.random() * (40 - 0)) + 0);
    }

    public int getRandomNumberY() {
        return (int) ((Math.random() * (10 - 0)) + 0);
    }

    private void setGrasses() {
        int counter = 0;

        while (counter != 3) {
            int X;
            int Y;
            X = getRandomNumberX();
            Y = getRandomNumberY();
            if (MAP.isCellEmpty(new Coordinates(X, Y))) {
                MAP.setEntity(new Coordinates(X, Y), new Grass(new Coordinates(X, Y)));
                counter++;
            }
        }
    }

    private void setHerbivores() {
        int counter = 0;

        while (counter != 3) {
            int X;
            int Y;
            X = getRandomNumberX();
            Y = getRandomNumberY();
            if (MAP.isCellEmpty(new Coordinates(X, Y))) {
                MAP.setEntity(new Coordinates(X, Y), new Herbivore(new Coordinates(X, Y), 3, 1));
                counter++;
            }
        }

    }

    public void gameLoop() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(" ");

                new Simulation().render(new Simulation());
                checkingNumberOfCreatures();
                makeAction();
            }
        };
        timer.scheduleAtFixedRate(task, 0, 2000);
    }

    public void makeAction() {
        for (java.util.Map.Entry<Coordinates, Entity> entry : MAP.getCopiedMap().entrySet()) {
            Entity entity = entry.getValue();

            if (entity instanceof Creature) {
                ((Creature) entity).makeMove(this);
            }
        }
    }

    public void setupDefaultEntitiesPosition() {
        setDefaultHerbivoresPosition();
        setDefaultPredatorsPosition();
        setDefaultGrassesPosition();
        setDefaultRocksPosition();
        setDefaultTreesPosition();
    }

    private void setDefaultTreesPosition() {
        int counter = 0;

        while (counter != 10) {
            int X;
            int Y;
            X = getRandomNumberX();
            Y = getRandomNumberY();
            if (MAP.isCellEmpty(new Coordinates(X, Y))) {
                MAP.setEntity(new Coordinates(X, Y), new Tree(new Coordinates(X, Y)));
                counter++;
            }
        }
    }

    private void setDefaultRocksPosition() {
        int counter = 0;

        while (counter != 10) {
            int X;
            int Y;
            X = getRandomNumberX();
            Y = getRandomNumberY();
            if (MAP.isCellEmpty(new Coordinates(X, Y))) {
                MAP.setEntity(new Coordinates(X, Y), new Rock(new Coordinates(X, Y)));
                counter++;
            }
        }
    }

    private void setDefaultGrassesPosition() {
        int counter = 0;

        while (counter != 7) {
            int X;
            int Y;
            X = getRandomNumberX();
            Y = getRandomNumberY();
            if (MAP.isCellEmpty(new Coordinates(X, Y))) {
                MAP.setEntity(new Coordinates(X, Y), new Grass(new Coordinates(X, Y)));
                counter++;
            }
        }
    }

    private void setDefaultPredatorsPosition() {
        int counter = 0;

        while (counter != 5) {
            int X;
            int Y;
            X = getRandomNumberX();
            Y = getRandomNumberY();
            if (MAP.isCellEmpty(new Coordinates(X, Y))) {
                MAP.setEntity(new Coordinates(X, Y), new Predator(new Coordinates(X, Y), 3, 1, 1));
                counter++;
            }
        }
    }

    private void setDefaultHerbivoresPosition() {
        int counter = 0;

        while (counter != 5) {
            int X;
            int Y;
            X = getRandomNumberX();
            Y = getRandomNumberY();
            if (MAP.isCellEmpty(new Coordinates(X, Y))) {
                MAP.setEntity(new Coordinates(X, Y), new Herbivore(new Coordinates(X, Y), 3, 1));
                counter++;
            }
        }
    }
}