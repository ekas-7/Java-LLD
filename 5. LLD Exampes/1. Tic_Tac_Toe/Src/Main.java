import Controller.GameController.TicTacToeGame;
import PlayerStrategies.ConcreteStrategies.HumanPlayerStrategy;
import PlayerStrategies.PlayerStrategy;

public class Main {
	public static void main(String[] args) {
		// Create human strategies for both players
		PlayerStrategy xStrategy = new HumanPlayerStrategy("Player X");
		PlayerStrategy oStrategy = new HumanPlayerStrategy("Player O");

		// Create a 3x3 TicTacToe game and start it
		TicTacToeGame game = new TicTacToeGame(xStrategy, oStrategy, 3, 3);
		game.play();
	}
}
