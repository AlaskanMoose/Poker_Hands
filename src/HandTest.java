import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HandTest {
	Hand handOne;

	@Before
	public void setUp() throws Exception {
		handOne = new Hand("Andy");
	}

	@Test
	public void testIsStraight() {
		handOne.push(new Card(1, Suit.DIAMOND));
		handOne.push(new Card(2, Suit.CLUB));
		handOne.push(new Card(3, Suit.SPADE));
		handOne.push(new Card(4, Suit.CLUB));
		handOne.push(new Card(5, Suit.HEART));

		assertTrue(handOne.isStraight());
	}
	
	@Test
	public void testIsFlush() {
		handOne.push(new Card(1, Suit.CLUB));
		handOne.push(new Card(10, Suit.CLUB));
		handOne.push(new Card(3, Suit.CLUB));
		handOne.push(new Card(4, Suit.CLUB));
		handOne.push(new Card(5, Suit.CLUB));
		assertTrue(handOne.isFlush());

		handOne.empty();
		
		handOne.push(new Card(1, Suit.DIAMOND));
		handOne.push(new Card(10, Suit.CLUB));
		handOne.push(new Card(3, Suit.CLUB));
		handOne.push(new Card(4, Suit.CLUB));
		handOne.push(new Card(5, Suit.CLUB));
		assertFalse(handOne.isFlush());
	}
	
	@Test
	public void testIsStraightFlush() {
		handOne.push(new Card(1, Suit.CLUB));
		handOne.push(new Card(2, Suit.CLUB));
		handOne.push(new Card(3, Suit.CLUB));
		handOne.push(new Card(4, Suit.CLUB));
		handOne.push(new Card(5, Suit.CLUB));
		assertTrue(handOne.isStraightFlush());
	}
	@Test
	public void testIsFullHouse() {
		handOne.push(new Card(1, Suit.DIAMOND));
		handOne.push(new Card(1, Suit.CLUB));
		handOne.push(new Card(1, Suit.HEART));
		handOne.push(new Card(2, Suit.SPADE));
		handOne.push(new Card(2, Suit.CLUB));
		
		assertTrue(handOne.isFullHouse());		
	}
	
	@Test
	public void testIsFourOfKind() {
		handOne.push(new Card(1, Suit.DIAMOND));
		handOne.push(new Card(1, Suit.CLUB));
		handOne.push(new Card(1, Suit.HEART));
		handOne.push(new Card(1, Suit.SPADE));
		handOne.push(new Card(5, Suit.CLUB));
		
		assertTrue(handOne.isFourOfKind());		
	}

	@Test
	public void testIsThreeOfKind() {
		handOne.push(new Card(1, Suit.DIAMOND));
		handOne.push(new Card(1, Suit.CLUB));
		handOne.push(new Card(1, Suit.HEART));
		handOne.push(new Card(6, Suit.CLUB));
		handOne.push(new Card(5, Suit.CLUB));
		
		assertTrue(handOne.isThreeOfKind());		
	}
	public void testIsTwoPair() {
		handOne.push(new Card(1, Suit.DIAMOND));
		handOne.push(new Card(1, Suit.CLUB));
		handOne.push(new Card(2, Suit.HEART));
		handOne.push(new Card(2, Suit.CLUB));
		handOne.push(new Card(5, Suit.CLUB));
		
		assertTrue(handOne.isTwoPair());		
	}
	@Test
	public void testIsPair() {
		handOne.push(new Card(1, Suit.DIAMOND));
		handOne.push(new Card(1, Suit.CLUB));
		handOne.push(new Card(2, Suit.HEART));
		handOne.push(new Card(6, Suit.CLUB));
		handOne.push(new Card(5, Suit.CLUB));
		
		assertTrue(handOne.isPair());		
	}
	
	@Test
	public void testGetHighCard() {
		handOne.push(new Card(1, Suit.DIAMOND));
		handOne.push(new Card(3, Suit.CLUB));
		handOne.push(new Card(5, Suit.HEART));
		handOne.push(new Card(7, Suit.CLUB));
		handOne.push(new Card(13, Suit.CLUB));
		Card highCard = handOne.getHighCard();
		
		assertEquals(13, highCard.getCardValue());		
	}
	
	@Test
	public void testGetRank() {
		handOne.push(new Card(1, Suit.DIAMOND));
		handOne.push(new Card(3, Suit.CLUB));
		handOne.push(new Card(5, Suit.HEART));
		handOne.push(new Card(7, Suit.CLUB));
		handOne.push(new Card(13, Suit.CLUB));
		
		assertEquals(9, handOne.getRank());		
	}
}
