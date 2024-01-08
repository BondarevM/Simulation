package bondarev.entities;

import bondarev.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Herbivore extends Creature {


    public Herbivore(Coordinates coordinates, Integer health, Integer speed) {
        super(coordinates, health, speed);
    }

    @Override
    public void makeMove(Simulation simulation) {
       Map<Coordinates, Entity> copiedMap = new HashMap<>(Mapp.myMap);

        BFS bfs = new BFS(this);
        List<Coordinates> trace = bfs.findShortestPathToTarget(simulation);
        Coordinates коогдитатыКролика = this.coordinates;


        int abc = 1;

        copiedMap.remove(this.coordinates);
        this.coordinates=trace.get(0);
        copiedMap.put(trace.get(0),this);

        int abc1 = 1;
        Mapp.myMap = copiedMap;

        int abc2 = 1;

    }

    @Override
    void findTarget() {

    }
//    @Override
//    public boolean isCellAvailableToMove(Coordinates coordinates, Simulation simulation){
//        super(getAvailableMovesCells())
//    }

//    @Override
//    protected Set<CoordinatesShift> getCreatureMoves() {
//        return null;
//    }


}
