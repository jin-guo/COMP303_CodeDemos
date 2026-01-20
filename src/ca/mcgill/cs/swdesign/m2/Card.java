package ca.mcgill.cs.swdesign.m2;

import java.util.Comparator;

public class Card implements Comparable<Card>
{
	public enum Rank
	{ ACE, TWO, THREE, FOUR, FIVE, SIX,
		SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	/**
	 * A card's suit.
	 */
	public enum Suit
	{
		CLUBS, DIAMONDS, SPADES, HEARTS
	}
	
	private final Rank aRank;
	private final Suit aSuit;
	
	/**
	 * @param pRank The index of the rank in RANKS
	 * @param pSuit The index of the suit in SUITS
	 * @pre pRank != null && pSuit != null
	 */
	public Card(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}
	
	/**
	 * @return The rank of the card.
	 */
	public Rank getRank()
	{
		return aRank;
	}
	
	/**
	 * @return The suit of the card.
	 */
	public Suit getSuit()
	{
		return aSuit;
	}


	@Override
	public int compareTo(Card pCard)
	{
		assert pCard!=null;
		return getRank().compareTo(pCard.getRank());
	}

	/**
	 * Static factory method to create a comparator capable
	 * of comparing cards by rank.
	 * Achieve the same feature with the ByRankComparator class
	 *
	 * @return The created comparator.
	 */
	public static Comparator<Card> createByRankComparator() {
		return new Comparator<Card>() {
			@Override
			public int compare(Card o1, Card o2) {
				assert o1!= null && o2!= null;
				return o1.aRank.compareTo(o2.aRank);
			}
		};
	}

	@Override
	public String toString()
	{
		return getRank() + " of " + getSuit();
	}

}
