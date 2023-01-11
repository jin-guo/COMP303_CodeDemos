package ca.mcgill.cs.swdesign.m1;

/**
 * Same as version 6 but with design by contract
 * instead of defensive programming.
 */
public class Card7
{
	/**
 	 * A card's rank.
	 */
	public enum Rank 
	{ ACE, TWO, THREE, FOUR, FIVE, SIX,
		SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}
	
	/**
	 * A card's suit.
	 */
	public enum Suit
	{
		CLUBS(Card7.Suit.Color.BLACK),
		DIAMONDS(Card7.Suit.Color.RED),
		SPADES(Card7.Suit.Color.BLACK),
		HEARTS(Card7.Suit.Color.RED);

		private Card7.Suit.Color aColor;

		private enum Color {BLACK, RED}

		Suit(Card7.Suit.Color pColor){
			this.aColor = pColor;
		}

		public Card7.Suit.Color getColor(){
			return this.aColor;
		}

	}

	private Rank aRank; // Invariant: != null
	private Suit aSuit; // Invariant: != null
	
	/**
	 * @param pRank The index of the rank in RANKS
	 * @param pSuit The index of the suit in SUITS
	 * @pre pRank != null && pSuit != null
	 */
	public Card7(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		
		aRank = pRank;
		aSuit = pSuit;
		
		assert getRank() == pRank && getSuit() == pSuit;

	}
	
	/**
	 * @return The index in RANKS corresponding to the rank of the card.
	 * @post return != null
	 */
	public Rank getRank()
	{
		return aRank;
	}
	
	/**
	 * @return The index in SUITS corresponding to the suit of the card.
	 * @post return != null
	 */
	public Suit getSuit()
	{
		return aSuit;
	}
	
	/**
	 * Assigns a new rank to the card.
	 * @param pRank The new rank.
	 * @pre pRank != null
	 */
	public void setRank(Rank pRank)
	{
		aRank = pRank;
	}
	
	/**
	 * Assigns a new suit to the card.
	 * @param pSuit The new suit.
	 * @pre pSuit != null
	 */
	public void setSuit(Suit pSuit)
	{
		aSuit = pSuit;
	}
	
	@Override
	public String toString()
	{
		return aRank + " of " + aSuit;
	}
}