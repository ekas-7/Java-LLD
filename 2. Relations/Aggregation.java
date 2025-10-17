import java.util.ArrayList;
import java.util.List;

class Player{
	String name;
	Player(String name){
		this.name = name;
	}
}

class Team{
	String teamname;
	// List of players
	List<Player>players = new ArrayList<Player>();

	Team(String teamname){
		this.teamname = teamname;	
	}
	
	void addPlayer(Player p){
		players.add(p);
	}
	
	void showTeam(){
		System.out.println("Players of "+teamname);
		for(Player p : players){
			System.out.println(p.name);
		}
	}
}

public class Aggregation {
  public static void main(String[] args) {
    Team team = new Team("Warriors");
    team.addPlayer(new Player("Stephen"));
    team.addPlayer(new Player("Klay"));
    team.showTeam();
  }
}
