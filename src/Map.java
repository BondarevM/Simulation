import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> map = new HashMap<>();

    public void setEntity(Coordinates coordinates, Entity entity){
        entity.coordinates = coordinates;
        map.put(coordinates,entity);
    }

    public void setupStartEntitiesPosition(){

    }

}
