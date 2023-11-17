package bondarev;

import bondarev.entities.*;


public class Simulation {
    private final String EMPTY_CELL = " - ";
    private final String PREDATOR = "X";

    public void render(Simulation simulation) {
        for (int y = 10; y >= 0; y--) {
            String line = "";
            for (int x = 0; x <= 40; x++) {
                Coordinates coordinates = new Coordinates(x,y);

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
        return "X";
    }

    public void setupDefaultEntitiesPosition() {
        for (int y = 10; y >= 0; y--) {
            for (int x = 0; x <= 40; x++) {
                if ((x + y) % 5 == 4) {
                    setEntity(new Coordinates(x,y), new Predator(new Coordinates(x,y), 5, 1,1)) ;
                }
            }
        }
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !Map.map.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return Map.map.get(coordinates);
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        Map.map.put(coordinates, entity);
    }
}
