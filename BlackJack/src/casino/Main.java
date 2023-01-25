package casino;

import agents.MyBlackjackPlayer;

public class Main {
	
	public static void main(String[] args) {
		/*int j = 0;
		int sumchips = 0;
		double stdsum = 0;
		int[] currentchips = new int [10000];*/
		
		//while (j<=10) {
			System.out.println("Let's play some blackjack!");
			
			int numGames = 10000;
			MyBlackjackPlayer p = new MyBlackjackPlayer();
			BlackjackDealer dealer = new BlackjackDealer(p);
			p.setDealer(dealer);
			
			for(int i=0; i<numGames; i++) {
				dealer.playHand();
				//currentchips[i] = p.getChips();
			}
			
			System.out.println("_____________SUMMARY_______________");
			System.out.println("FINAL CHIP COUNT: " + p.getChips());
			
			//j++;
			
			//sumchips += p.getChips();
		//}
		
			/*float average = (float)(-sumchips)/10000;
			System.out.println("YOUR AVERAGE CHIP COUNT: " + average);
			
			//standard deviation
			for (int i=0; i<10000; i++) {
				stdsum += Math.pow(currentchips[i] - average,2);
			}
			System.out.println("YOUR STANDARD DEVIATION IS: " + Math.sqrt(stdsum/(10000-1)));*/
		
		
	}

}
