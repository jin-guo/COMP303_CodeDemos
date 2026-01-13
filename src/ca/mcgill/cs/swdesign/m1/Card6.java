package ca.mcgill.cs.swdesign.m1;

/**
 * With this version we break the client (force it
 * to adapt), but reap the major benefit of strengthening
 * the interface to the class. This version implements the 
 * "defensive programming" approach to defend against 
 * null values.
 */
public class Card6
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
		CLUBS, DIAMONDS, SPADES, HEARTS
	}

	private Rank aRank;
	private Suit aSuit;


	/**
	 * @param pRank The index of the rank in RANKS
	 * @param pSuit The index of the suit in SUITS
	 * @throws IllegalArgumentException if pRank != null or pSuit != null
	 */
	public Card6(Rank pRank, Suit pSuit)
	{
		if( pRank == null || pSuit == null )
		{
			throw new IllegalArgumentException();
		}
		aRank = pRank;
		aSuit = pSuit;
	}

	public Card6 getCopy() {
		Card6 copy = new Card6(aRank, aSuit);
		return copy;
	}

	public static Card6 makeCopy(Card6 pCard) {
		Card6 copy = new Card6(pCard.aRank, pCard.aSuit);
		return copy;
	}

	/**
	 * @return The index in RANKS corresponding to the rank of the card.
	 */
	public Rank getRank()
	{
		return aRank;
	}

	/**
	 * @return The index in SUITS corresponding to the suit of the card.
	 */
	public Suit getSuit()
	{
		return aSuit;
	}

	/**
	 * Assigns a new rank to the card.
	 * @param pRank The new rank.
	 */
	public void setRank(Rank pRank)
	{
		aRank = pRank;
	}

	/**
	 * Assigns a new suit to the card.
	 * @param pSuit The new suit.
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
