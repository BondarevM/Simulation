package bondarev;

import bondarev.Coordinates;
import bondarev.entities.Creature;
import bondarev.entities.Grass;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {
    Creature creature;

    BFS(Creature creature){
        this.creature = creature;
    }

    Queue<Coordinates> queue = new LinkedList<>();

//    Coordinates currenCoordinates = creature.coordinates;

    public void soutCreature(){
        System.out.println(creature);
    }


    public Coordinates findTarget(Simulation simulation){

        for(Coordinates coordiate : creature.getAvailableMovesCells(simulation)){
            queue.add(coordiate);
        }

        while (queue.isEmpty()){
            Coordinates qqq = queue.poll();
            if(Map.map.get(qqq) instanceof Grass){
                return qqq;
            }
            qqq.canShift(c)
        }

    }

}
