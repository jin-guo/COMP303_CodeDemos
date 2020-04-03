package ca.mcgill.cs.swdesign.m7.comparison;

import java.util.List;

import ca.mcgill.cs.swdesign.m2.Card;
import ca.mcgill.cs.swdesign.m2.Card.Rank;
import ca.mcgill.cs.swdesign.m2.Card.Suit;

/**
 * 
 * Inheritance example of subclass depend on the super class implementation 
 * to work properly, i.e. count the number of list member access.
 *
 */
public class AccessCountCardList extends CardList
{

	private int count = 0;
	
	AccessCountCardList(Card[] pCards)
	{
		super(pCards);
	}

	@Override
	public Card get(int pIndex)
	{
		assert pIndex>=0 && pIndex<size();
		Card card = super.get(pIndex);
		count++;
		return card;
	}
	
	public List<Card> getRange(int pStartIndex, int pEndIndex)
	{
		assert pStartIndex>=0 && pEndIndex<size();
		List<Card> cards = super.getRange(pStartIndex, pEndIndex);
		count += cards.size();
		return cards;
	}
	
	public void printAccessCount() 
	{
		System.out.printf("Total Access Count: %d", count);
	}


	public static void main(String[] pArgs)
	{
		Card[] cards = new Card[3];
		cards[0] = new Card(Rank.ACE, Suit.CLUBS);
		cards[1] = new Card(Rank.FIVE, Suit.DIAMONDS);
		cards[2] = new Card(Rank.EIGHT, Suit.HEARTS);
		AccessCountCardList cardList = new AccessCountCardList(cards);


		for (Card card: cardList.getRange(0, 1))
		{
			System.out.println(card);
		}

		cardList.printAccessCount();

	}

}
