package ca.mcgill.cs.swdesign.m2;

import java.io.StringWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

import ca.mcgill.cs.swdesign.m2.Card.Rank;
import ca.mcgill.cs.swdesign.m2.Card.Suit;

public class Deck implements CardSource
{
	private final Stack<Card> aCards;
	
	public Deck(Deck pDeck)
	{
		aCards = new Stack<>();
		for(Card card : pDeck.aCards)
		{
			aCards.add(card);
		}
	}
	
	public Collection<Card> getCards()
	{
		return Collections.unmodifiableCollection(aCards);
	}
	
	public Deck()
	{
		aCards = new Stack<>();
		shuffle();
	}

	@Override
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}

	@Override
	public Card draw()
	{
		if( !isEmpty() )
		{
			return aCards.pop();
		}
		return aCards.pop();
	}
	
	public void shuffle()
	{
		aCards.clear();
		for(Suit suit : Suit.values() )
		{
			for( Rank rank : Rank.values())
			{
				aCards.push(new Card(rank, suit));
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

	public void sort(Comparator<Card> pComparator){
		Collections.sort(aCards, pComparator);
	}
}
