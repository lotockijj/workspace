package tutorial.oracle;

public class TestDeck {

	public static void main(String[] args) {

		Deck deck = new Deck();
			for(int i = 1; i <= deck.numRanks; i++){
				for(int j = 1; j <= deck.numSuits; j++){
				System.out.println(Card.rankToString(deck.getCard(j, i).getRank()) + " " 
						+ Card.suitToString(deck.getCard(j, i).getSuit()));
			} 
		}
	}
}
