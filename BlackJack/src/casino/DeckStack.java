package casino;

import casino.Card.Suit;

/**
 * A stack of more than one deck used in a casino game
 *
 */
public class DeckStack {
	
	private int decksDone = 0;
	
	private Deck[] decks; 
	
	public DeckStack(int numDecks) {
		decks = new Deck[numDecks];
		for (int i = 0; i < numDecks; i++) {
			decks[i] = new Deck();
		}
	}
	
	public Card dealTopCard() {
		
		if (decks[decksDone].cardsLeft() == 0) {
			decksDone++;
		}
		
		if (decksDone >= decks.length) {
			decksDone = 0;
			restoreDecks();
		}
		

		return decks[decksDone].dealTopCard();
	}
	
	protected void restoreDecks() {
		for (int i = 0; i < decks.length; i++) {
			decks[i].shuffle();
		}
	}
	
	public int cardsLeft() {
		int cardsLeft = 0;
		for (int i = 0; i < decks.length; i++) {
			cardsLeft += decks[i].cardsLeft();
		}
		return cardsLeft;
	}
	
	
}
