package GameStateHandler.ConcreteStates;

import GameStateHandler.Context.GameContext;
import CommonEnum.Symbol;
import GameStateHandler.GameState;
import Utility.Player;

public class OTurnState implements GameState {
    @Override
    public void next(GameContext context, Player player, boolean hasWon){
        if(hasWon){
            context.setState(player.getSymbol() == Symbol.X ? new XWonState() : new OWonState());
        }
        else {
            // If no winner, switch back to X's turn
            context.setState(new XTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
    
}
