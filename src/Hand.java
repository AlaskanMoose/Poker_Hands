import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Hand implements Comparable<Hand> {
	
	private List<Card> myHand;
	private int handRank;
	public String myName;
	public Hand(String name) {
		myHand = new ArrayList<Card>();
		handRank = 9;
		myName = name;
	}
	
	public void push(Card c) {
		myHand.add(c);
	}
	public void empty() {
		myHand.clear();
	}
	
	public boolean isStraight() {
		Collections.sort(myHand);
		boolean fiveInRow = true;
		for (int i = 1; i < myHand.size(); i++) {
			if (myHand.get(i).compareTo(myHand.get(i - 1)) != 1)
				fiveInRow = false;
		}
		return fiveInRow;
	}
	
	public boolean isFlush() {
		Map<Suit,Integer> numberOfEachSuit = countNumberOfEachSuit();
		boolean flush = false;
		if (numberOfEachSuit.containsValue(5))
			flush = true;
		return flush;
		
	}
	
	public boolean isStraightFlush() {
		return isStraight() && isFlush();
	}
	
	public boolean isFourOfKind() {
		boolean fourInRow = false;
		Map<Integer,Integer> numberOfEachValue = countNumberOfEachValue();
		if(numberOfEachValue.containsValue(4)) 
			fourInRow = true;
		return fourInRow;
	}
	
	public boolean isFullHouse() {
		boolean fullHouse = false;
		Map<Integer,Integer> numberOfEachValue = countNumberOfEachValue();
		if(numberOfEachValue.containsValue(3) && numberOfEachValue.containsValue(2)) 
			fullHouse = true;
		return fullHouse;
	}
	
	public boolean isThreeOfKind() {
		boolean threeInRow = false;
		Map<Integer,Integer> numberOfEachValue = countNumberOfEachValue();
		if(numberOfEachValue.containsValue(3)) 
			threeInRow = true;
		return threeInRow;
	}
	public boolean isTwoPair() {
		boolean twoPair = false;
		int count = 2;
		Map<Integer,Integer> numberOfEachValue = countNumberOfEachValue();
		for (int key : numberOfEachValue.keySet()) {
			if (numberOfEachValue.get(key) == 2) count--;
		}
		if(count == 0) 
			twoPair = true;
		
		return twoPair;
	}
	
	public boolean isPair() {
		boolean pair = false;
		Map<Integer,Integer> numberOfEachValue = countNumberOfEachValue();
		if(numberOfEachValue.containsValue(2)) 
			pair = true;
		return pair;
	}
	public Card getHighCard() {
		Collections.sort(myHand);
		return myHand.get(myHand.size() - 1);
	}
	
	public int getRank() {
		int rank = 99;
		if (isStraightFlush()) {
			rank = 1;
		} else if (isFourOfKind()) {
			rank = 2;
		} else if (isFullHouse()) {
			rank = 3;
		} else if (isFlush()) {
			rank = 4;
		} else if (isStraight()) {
			rank = 5;
		} else if (isThreeOfKind()) {
			rank = 6;
		} else if (isTwoPair()) {
			rank = 7;
		} else if (isPair()) {
			rank = 8;
		} else {
			rank = 9;
		}
		return rank;
	}
	private Map<Integer,Integer> countNumberOfEachValue() {
		Map<Integer,Integer> numberOfEachValue = new TreeMap<Integer, Integer>();
		for (Card c : myHand) {
			numberOfEachValue.putIfAbsent(c.getCardValue(), 0);
			numberOfEachValue.put(c.getCardValue(), numberOfEachValue.get(c.getCardValue()) + 1);
		}
		return numberOfEachValue;
	}
	private Map<Suit,Integer> countNumberOfEachSuit() {
		Map<Suit,Integer> numberOfEachSuit = new TreeMap<Suit, Integer>();
		for (Card c : myHand) {
			numberOfEachSuit.putIfAbsent(c.getSuit(), 0);
			numberOfEachSuit.put(c.getSuit(), numberOfEachSuit.get(c.getSuit()) + 1);
		}
		return numberOfEachSuit;
	}
	public int compareTo(Hand h) {
		return h.handRank - handRank;
	}
	

}
