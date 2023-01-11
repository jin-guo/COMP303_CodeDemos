package ca.mcgill.cs.swdesign.m1;

import ca.mcgill.cs.swdesign.m1.Card7.Suit;
import ca.mcgill.cs.swdesign.m1.Card7.Rank;

/** This client class is a stand in for any client code. 
 *  This version is adapted to work with Card7
 */
public final class Client
{ 
	private Client()
	{}
	
	/**
	 * @param pArgs Not used here
	 */
	public static void main(String[] pArgs)
	{

		Card7 card = new Card7(Rank.TEN, Suit.SPADES);
		System.out.println(card.getSuit().getColor());
		Deck d = new Deck();
		d.addCard(card);
		d.print();

		//Change the card using the reference outside of deck.
		card.setRank(Rank.KING);
		d.print();
	}

	
	
	
	
	
	
	
	
	
	
	

}
