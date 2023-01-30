package ca.mcgill.cs.swdesign.m2;

import java.io.StringWriter;
import java.sql.Array;
import java.util.*;

import ca.mcgill.cs.swdesign.m2.Card.Rank;
import ca.mcgill.cs.swdesign.m2.Card.Suit;

public class Deck implements CardSource
{
	private List<Card> aCards = new ArrayList<>();

	/**
	 * Copy Constructor. Create a Deck instance with the same state of the input Deck
	 * @param pDeck the target of the Deck instance to copy
	 * @pre pDeck!=null
	 */
	public Deck(Deck pDeck)
	{
		assert pDeck!= null;
		for(Card card : pDeck.aCards)
		{
			aCards.add(card);
		}
	}

	/**
	 * @return An unmodifiable list of all the cards in the deck.
	 */
	public List<Card> getCards()
	{
		return Collections.unmodifiableList(aCards);
	}

	/**
	 * 	Creates a new deck of 52 cards, shuffled.
	 */
	public Deck()
	{
		shuffle();
	}

	/**
	 * @return True if and only if there are no cards in the deck.
	 */
	@Override
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}

	/**
	 *  Draw a card from the top of the Deck if it is not empty.
	 * @return The card drawn
	 * @pre !isEmpty()
	 */
	@Override
	public Card draw()
	{
		assert !isEmpty();
		return aCards.remove(aCards.size()-1);
	}

	/**
	 * Reinitialize the deck with all 52 cards and shuffles them.
	 */
	public void shuffle()
	{
		aCards.clear();
		for(Suit suit : Suit.values() )
		{
			for( Rank rank : Rank.values())
			{
				aCards.add(new Card(rank, suit));
			}
		}
		Collections.shuffle(aCards);
	}

	@Override
	public String toString()
	{
		StringWriter writer = new StringWriter();
		for( Card card : aCards )
		{
			writer.append(card.toString() + "\n");
		}
		return writer.toString();
	}

	/**
	 * Sort the card in the deck with the provided comparator
	 * @param pComparator the comparator which defines the sorting behavior
	 * @pre pComparator!=null;
	 */
	public void sort(Comparator<Card> pComparator){
		assert pComparator!=null;
		Collections.sort(aCards, pComparator);
	}
}
