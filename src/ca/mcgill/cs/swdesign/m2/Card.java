package ca.mcgill.cs.swdesign.m2;

import java.util.Comparator;
import java.util.Objects;

public class Card implements Comparable<Card>
{
	public enum Rank
	{ ACE, TWO, THREE, FOUR, FIVE, SIX,
		SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
		
		@Override
		public String toString()
		{
			return name().substring(0, 1) + name().substring(1).toLowerCase();
		}
	}

	/**
	 * A card's suit.
	 */
	public enum Suit
	{
		CLUBS, DIAMONDS, SPADES, HEARTS
	}
	
	final private Rank aRank;
	final private Suit aSuit;
	
	/**
	 * @param pRank The index of the rank in RANKS
	 * @param pSuit The index of the suit in SUITS
	 * @pre pRank != null && pSuit != null
	 */
	public Card(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		aRank =  pRank;
		aSuit = pSuit;
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


	@Override
	public String toString()
	{
		return getRank() + " of " + getSuit();
	}

	@Override
	public int compareTo(Card pCard)
	{
		assert pCard!=null;
		return getRank().compareTo(pCard.getRank());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Card card = (Card) o;
		return aRank == card.aRank && aSuit == card.aSuit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aRank, aSuit);
	}
}
