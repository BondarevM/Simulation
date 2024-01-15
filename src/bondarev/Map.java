package bondarev;

import bondarev.entities.Entity;

import java.util.HashMap;

public class Map {
    private static java.util.Map<Coordinates, Entity> map = new HashMap<>();

    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        map.put(coordinates, entity);
    }

    public HashMap<Coordinates, Entity> getCopiedMap() {
        return new HashMap<>(map);
    }

    public void equatingMaps(java.util.Map<Coordinates, Entity> copiedMap) {
        map = copiedMap;
    }

}
