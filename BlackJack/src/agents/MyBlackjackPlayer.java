package agents;

import casino.BlackjackDealer;
import casino.BlackjackPlayer;
import casino.Card;
import casino.Move;

public class MyBlackjackPlayer extends BlackjackPlayer{

	@Override
	public int getBet() {
		if (this.getChips() <= 200) {
			return 2;
		}
		else if (handScore() <= 700) {
			return 1;
		}
		else if (handScore() <= 1000) {
			return 10;
		}
		else {
			return 0;
		}
		
	}

	@Override
	public Move getMove() {

		int hand = this.handScore();
		int dealHand = this.dealer.getVisibleCard().getRank();
		/*if (this.handScore() < 8) {
			return Move.HIT;
		}
		else if (8 <= this.handScore() && this.handScore() <= 17) {
		
			switch (hand) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 13:
				case 14:
				  return Move.HIT;
				  
				case 9:
				case 10:
				case 11:
				case 12:
					return Move.DOUBLE;
				  
				case 15:
				case 16:
				case 17:
					return Move.STAY;
					
				default:
					return Move.STAY;
			}
		}
		
		else {
			return Move.STAY;
		}*/
		
		switch (dealHand) {
			case 2:
			case 3:
				switch (hand) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 12:
				  return Move.HIT;
				
				case 9:
				case 10:
				case 11:
					return Move.DOUBLE;
				
				case 13:
				case 14:
				case 15:
				case 16:
				case 17:
					return Move.STAY;
				}
			case 4:
				switch (hand) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				  return Move.HIT;
				
				case 9:
				case 10:
				case 11:
					return Move.DOUBLE;
				
				case 12:
				case 13:
				case 14:
				case 15:
				case 16:
				case 17:
					return Move.STAY;
				}
			case 5:
			case 6:
				switch (hand) {
				case 1:
				case 2:
				case 4:
				case 6:
				case 8:
				  return Move.HIT;
				
				case 3:
				case 5:
				case 7:
				case 9:
				case 10:
				case 11:
					return Move.DOUBLE;
				
				case 12:
				case 13:
				case 14:
				case 15:
				case 16:
				case 17:
					return Move.STAY;
				}
			case 7:
			case 8:
			case 9:
				switch (hand) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 12:
				case 13:
				case 14:
				case 15:
				case 16:
				  return Move.HIT;
				
				case 10:
				case 11:
					return Move.DOUBLE;
				
				case 17:
					return Move.STAY;
				}
			case 10:
				switch (hand) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
				case 12:
				case 13:
				case 14:
				case 15:
				case 16:
				  return Move.HIT;
				
				case 11:
					return Move.DOUBLE;
				
				case 17:
					return Move.STAY;
				}
			
		default:
			return Move.STAY;
		}
		
	}

	@Override
	public void handOver(Card[] dealerHand) {
		/*
		 * If you care about looking at the dealer's hand once
		 * the hand is over, then you can do it here. This method
		 * is called automatically after every hand and a copy of the dealer's
		 * final hand is given to you to process.
		 */
		
	}

	
}
