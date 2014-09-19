package ca.centennial.assignment;

/**
 * 3.	Develop a Java console program that randomly selects
 *  four cards from a deck of cards, identify and reveal 
 *  their identity in terms of suits (like Spades, Hearts, 
 *  Diamonds, Clubs) and ranks(like Ace, 2, 3, 4, 5, 6, 7, 8, 
 *  9, 10, Jack, Queen, King.) 
 *  @author Chen Feng
 */

import java.util.ArrayList;
import java.util.Random;

public class CardManager {
	private final static int Pick_Card_Number = 4;

	public static void main(String[] args) {
		CardManager manager = new CardManager();
		// create all cards
		ArrayList<Card> cards = new ArrayList<>();
		for (int i = 0; i < Suits.values().length; i++) {
			for (int j = 0; j < Ranks.values().length; j++) {
				Card card = new Card(Suits.values()[i], Ranks.values()[j]);
				cards.add(card);
			}
		}
		System.out.println(cards.size() + " cards have been created");
		// pick cards
		ArrayList<Card> pickCards = new ArrayList<>();
		for (int i = 0; i < Pick_Card_Number; i++) {
			Random random = new Random();
			if (cards.size() > 0) {
				Card card = cards.get(random.nextInt(cards.size()));
				pickCards.add(card);
				cards.remove(card);
			}
		}
		System.out.println(pickCards.size() + " Cards have been picked: ");
		// print cards
		for (int i = 0; i < pickCards.size(); i++) {
			System.out.print("Card " + (i + 1) + ": ");
			System.out.println(pickCards.get(i));
		}
	}
}

// A card consists of a suit and a rank
class Card {
	private Suits suit;
	private Ranks rank;

	public Card(Suits suit, Ranks rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return String.format("%10s", suit.toString()) + String.format("%10s", rank.toString());
	}
}

// suits
enum Suits {
	Spades, Hearts, Diamonds, Clubs
}

// ranks
enum Ranks {
	Ace, Num_2 {
		@Override
		public String toString() {
			return "2";
		}
	},
	Num_3 {
		public String toString() {
			return "3";
		}
	},
	Num_4 {
		public String toString() {
			return "4";
		}
	},
	Num_5 {
		public String toString() {
			return "5";
		}
	},
	Num_6 {
		public String toString() {
			return "6";
		}
	},
	Num_7 {
		public String toString() {
			return "7";
		}
	},
	Num_8 {
		public String toString() {
			return "8";
		}
	},
	Num_9 {
		public String toString() {
			return "9";
		}
	},
	Num_10 {
		public String toString() {
			return "10";
		}
	},
	Jack, Queen, King,
}
