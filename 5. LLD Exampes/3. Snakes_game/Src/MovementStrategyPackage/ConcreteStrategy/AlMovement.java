package MovementStrategyPackage.ConcreteStrategy;

import MovementStrategyPackage.MovementStrategy;
import Utility.Pair;

public class AlMovement implements MovementStrategy {
    @Override
    public Pair getNextPosition(Pair currentHead, String direction) {
        // Implement AI movement logic here
        return currentHead;
    }
}

