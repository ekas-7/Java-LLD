package GameStateHandler.ConcreteStates;

import GameStateHandler.Context.GameContext;
import CommonEnum.Symbol;
import GameStateHandler.GameState;
import Utility.Player;

public class XTurnState implements GameState {
    @Override
    public void next(GameContext context, Player player, boolean hasWon){
        if(hasWon){
            context.setState(player.getSymbol() == Symbol.X ? new XWonState() : new OWonState());
        }
        else {
            // If current state was X's turn and there's no winner, switch to O's turn
            context.setState(new OTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
    
}
