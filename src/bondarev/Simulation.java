package bondarev;

import java.util.Timer;
import java.util.TimerTask;

import bondarev.entities.*;


public class Simulation {
    private String halfOfSpace = " ";
    private final String EMPTY_CELL = " ▫ " + halfOfSpace;
    private final String PREDATOR_CELL = " \uD83E\uDD81 ";
    private final String HERBIVORE_CELL = " \uD83D\uDC07 ";
    private final String TREE_CELL = " \uD83C\uDF33 ";
    private final String ROCK_CELL = " ⛰ ";
    private final String GRASS_CELL = " \uD83C\uDF3F ";


    public void render(Simulation simulation) {
        for (int y = 10; y >= 0; y--) {
            String line = "";
            for (int x = 0; x <= 40; x++) {
                Coordinates coordinates = new Coordinates(x, y);

                if (simulation.isCellEmpty(coordinates)) {
                    line += EMPTY_CELL;
                } else {
                    line += getEntityImage(simulation.getEntity(coordinates));
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


    public boolean isCellEmpty(Coordinates coordinates) {
        return !Mapp.myMap.containsKey(coordinates);
    }




    public Entity getEntity(Coordinates coordinates) {
        return Mapp.myMap.get(coordinates);
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        Mapp.myMap.put(coordinates, entity);
    }


    public void gameLoop() {


        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                for (int i = 0; i < 20; i++) {
                    System.out.println(" ");
                }


                // Ваш код, который нужно выполнить каждую секунду
                new Simulation().render(new Simulation());
            }
        };
        timer.scheduleAtFixedRate(task, 0, 2000);
    }




    public void setupDefaultEntitiesPosition() {
        for (int y = 10; y >= 0; y--) {
            for (int x = 0; x <= 40; x++) {

                //Set Predators
                if (x == 0 && y == 2) {
                    setEntity(new Coordinates(x, y), new Predator(new Coordinates(x, y), 5, 1, 1));
                }
                if (x == 5 && y == 4) {
                    setEntity(new Coordinates(x, y), new Predator(new Coordinates(x, y), 5, 1, 1));
                }
                if (x == 24 && y == 2) {
                    setEntity(new Coordinates(x, y), new Predator(new Coordinates(x, y), 5, 1, 1));
                }
                if (x == 36 && y == 9) {
                    setEntity(new Coordinates(x, y), new Predator(new Coordinates(x, y), 5, 1, 1));
                }

                //Set Herbivores
                if (x == 2 && y == 10) {
                    setEntity(new Coordinates(x, y), new Herbivore(new Coordinates(x, y), 3, 1));
                }
                if (x == 16 && y == 9) {
                    setEntity(new Coordinates(x, y), new Herbivore(new Coordinates(x, y), 3, 1));
                }
                if (x == 33 && y == 0) {
                    setEntity(new Coordinates(x, y), new Herbivore(new Coordinates(x, y), 3, 1));
                }
                if (x == 1 && y == 0) {
                    setEntity(new Coordinates(x, y), new Herbivore(new Coordinates(x, y), 3, 1));
                }
                if (x == 11 && y == 2) {
                    setEntity(new Coordinates(x, y), new Herbivore(new Coordinates(x, y), 3, 1));
                }
                if (x == 30 && y == 6) {
                    setEntity(new Coordinates(x, y), new Herbivore(new Coordinates(x, y), 3, 1));
                }
                if (x == 30 && y == 6) {
                    setEntity(new Coordinates(x, y), new Herbivore(new Coordinates(x, y), 3, 1));
                }
                if (x == 40 && y == 4) {
                    setEntity(new Coordinates(x, y), new Herbivore(new Coordinates(x, y), 3, 1));
                }

                //Set Trees
                if (x == 5 && y == 10) {
                    setEntity(new Coordinates(x, y), new Tree(new Coordinates(x, y)));
                }
                if (x == 17 && y == 8) {
                    setEntity(new Coordinates(x, y), new Tree(new Coordinates(x, y)));
                }
                if (x == 27 && y == 4) {
                    setEntity(new Coordinates(x, y), new Tree(new Coordinates(x, y)));
                }
                if (x == 13 && y == 0) {
                    setEntity(new Coordinates(x, y), new Tree(new Coordinates(x, y)));
                }
                if (x == 2 && y == 0) {
                    setEntity(new Coordinates(x, y), new Tree(new Coordinates(x, y)));
                }
                if (x == 22 && y == 6) {
                    setEntity(new Coordinates(x, y), new Tree(new Coordinates(x, y)));
                }
                if (x == 35 && y == 7) {
                    setEntity(new Coordinates(x, y), new Tree(new Coordinates(x, y)));
                }
                if (x == 14 && y == 5) {
                    setEntity(new Coordinates(x, y), new Tree(new Coordinates(x, y)));
                }

                //Set Rocks
                if (x == 0 && y == 10) {
                    setEntity(new Coordinates(x, y), new Rock(new Coordinates(x, y)));
                }
                if (x == 13 && y == 9) {
                    setEntity(new Coordinates(x, y), new Rock(new Coordinates(x, y)));
                }
                if (x == 7 && y == 7) {
                    setEntity(new Coordinates(x, y), new Rock(new Coordinates(x, y)));
                }
                if (x == 5 && y == 1) {
                    setEntity(new Coordinates(x, y), new Rock(new Coordinates(x, y)));
                }
                if (x == 23 && y == 1) {
                    setEntity(new Coordinates(x, y), new Rock(new Coordinates(x, y)));
                }
                if (x == 35 && y == 4) {
                    setEntity(new Coordinates(x, y), new Rock(new Coordinates(x, y)));
                }
                if (x == 39 && y == 1) {
                    setEntity(new Coordinates(x, y), new Rock(new Coordinates(x, y)));
                }
                if (x == 30 && y == 9) {
                    setEntity(new Coordinates(x, y), new Rock(new Coordinates(x, y)));
                }
                if (x == 19 && y == 3) {
                    setEntity(new Coordinates(x, y), new Rock(new Coordinates(x, y)));
                }
                if (x == 22 && y == 8) {
                    setEntity(new Coordinates(x, y), new Rock(new Coordinates(x, y)));
                }
                if (x == 0 && y == 3) {
                    setEntity(new Coordinates(x, y), new Rock(new Coordinates(x, y)));
                }

                //Set Grasses
                if (x == 2 && y == 2) {
                    setEntity(new Coordinates(x, y), new Grass(new Coordinates(x, y)));
                }
                if (x == 0 && y == 7) {
                    setEntity(new Coordinates(x, y), new Grass(new Coordinates(x, y)));
                }
                if (x == 10 && y == 0) {
                    setEntity(new Coordinates(x, y), new Grass(new Coordinates(x, y)));
                }
                if (x == 24 && y == 10) {
                    setEntity(new Coordinates(x, y), new Grass(new Coordinates(x, y)));
                }
                if (x == 28 && y == 5) {
                    setEntity(new Coordinates(x, y), new Grass(new Coordinates(x, y)));
                }
                if (x == 25 && y == 7) {
                    setEntity(new Coordinates(x, y), new Grass(new Coordinates(x, y)));
                }
                if (x == 40 && y == 10) {
                    setEntity(new Coordinates(x, y), new Grass(new Coordinates(x, y)));
                }
                if (x == 30 && y == 2) {
                    setEntity(new Coordinates(x, y), new Grass(new Coordinates(x, y)));
                }
                if (x == 16 && y == 5) {
                    setEntity(new Coordinates(x, y), new Grass(new Coordinates(x, y)));
                }
                if (x == 19 && y == 0) {
                    setEntity(new Coordinates(x, y), new Grass(new Coordinates(x, y)));
                }
                if (x == 9 && y == 6) {
                    setEntity(new Coordinates(x, y), new Grass(new Coordinates(x, y)));
                }
                if (x == 37 && y == 3) {
                    setEntity(new Coordinates(x, y), new Grass(new Coordinates(x, y)));
                }


            }
        }
    }
}


