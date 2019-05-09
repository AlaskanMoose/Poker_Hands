public class Card implements Comparable<Card>{
	private int cardValue;
	private Suit suit;
	public Card(int v, Suit s) {
		cardValue = v;
		suit = s;
	}
	public int getCardValue() {
		return cardValue;
	}
	public Suit getSuit() {
		return suit;
	}
	public int compareTo(Card c) {
		return cardValue - c.cardValue;
	}
}
