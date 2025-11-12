package GameStateHandler;

import GameStateHandler.Context.GameContext;
import Utility.Player;

public interface GameState {
    void next(GameContext context, Player player, boolean hasWon);
    boolean isGameOver();
}
