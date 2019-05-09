import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
	public List<Hand> players;
	
	public Game() {
		players = new ArrayList<Hand>();
	}
	public void push(Hand hand) {
		players.add(hand);
	}
	
	public Hand getWinner() {
		
		Collections.sort(players);
		return players.get(0);
	}
}
