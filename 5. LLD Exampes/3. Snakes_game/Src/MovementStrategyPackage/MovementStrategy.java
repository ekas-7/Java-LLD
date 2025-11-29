package MovementStrategyPackage;

import Utility.Pair;

public interface MovementStrategy {
     Pair getNextPosition(Pair currentHead, String direction);
} 