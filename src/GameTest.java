import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@Test
	public void testGetWinner() {
		Hand handOne = new Hand("Andy");
		Hand handTwo = new Hand("Andrew");
		
		handOne.push(new Card(1, Suit.DIAMOND));
		handOne.push(new Card(1, Suit.CLUB));
		handOne.push(new Card(2, Suit.HEART));
		handOne.push(new Card(2, Suit.CLUB));
		handOne.push(new Card(5, Suit.CLUB));
		
		handTwo.push(new Card(1, Suit.DIAMOND));
		handTwo.push(new Card(1, Suit.CLUB));
		handTwo.push(new Card(5, Suit.HEART));
		handTwo.push(new Card(2, Suit.CLUB));
		handTwo.push(new Card(5, Suit.CLUB));
		
		game.push(handOne);
		game.push(handTwo);
		
		Hand Winner = game.getWinner();
		assertSame(Winner, handOne);
		
	}

}
