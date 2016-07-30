/*
 * Write a class whose instances represent a single playing card from a deck of cards. Playing cards have two distinguishing properties: rank and suit. Be sure to keep your solution as you will be asked to rewrite it in Enum Types.
  
 Hint:

 You can use the assert statement to check your assignments. You write:

 assert (boolean expression to test);

 If the boolean expression is false, you will get an error message. For example,

 assert toString(ACE) == "Ace";

 should return true, so there will be no error message.

 If you use the assert statement, you must run your program with the ea flag:

 java -ea YourProgram.class

 Write a class whose instances represent a full deck of cards. You should also keep this solution.

 3. Write a small program to test your deck and card classes. The program can be as simple as creating a deck of cards and displaying its cards.

 */
public class PlayingDeck{ 
	 static final String[] rang = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9",
			 		"10", "J", "Q", "K"};
	 static final String[] suit = { "clubs", "spades", "hearts", "diamonds"};
	 static PlayingCard[][] deck;
	 
	 public PlayingDeck() {
		 deck = new PlayingCard[4][13];
		 for (int i = 0; i < deck.length; i++) { 
			 for (int j = 0; j < deck[i].length; j++) { 
				 deck[i][j] = new PlayingCard(suit[i], rang[j]);
			 }
		 }
	 }
	  
	public static void main(String[] args) {
		PlayingDeck pd = new PlayingDeck();
		//System.out.println(Arrays.deepToString(pd.deck));
		for(PlayingCard[] pa : PlayingDeck.deck) {
			for(PlayingCard p : pa){
				System.out.print(p.rang + " ");
				System.out.println(p.suit);
			}
		}
	}
	
	public static class PlayingCard {
		public final String suit;
		public final String rang;

		public PlayingCard(String suit, String rang) {
			this.suit = suit;
			this.rang = rang;
		}
	}
	
}


