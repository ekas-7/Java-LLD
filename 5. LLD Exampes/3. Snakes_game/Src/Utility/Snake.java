package Utility;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;


public class Snake {
    private Deque<Pair> body;
    private Map<Pair, Boolean>  positionMap;

     public Snake() {
            this.body = new LinkedList<>();
            this.positionMap = new HashMap<>();
            // Initialize snake at position [0,0]
            Pair initialPos = new Pair(0, 0);
            this.body.offerFirst(initialPos);
            this.positionMap.put(initialPos, true);
        }
}
