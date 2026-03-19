package ca.mcgill.cs.swdesign.m7.comparison;

import java.util.*;

import ca.mcgill.cs.swdesign.m2.Card;
import ca.mcgill.cs.swdesign.m2.Card.Rank;
import ca.mcgill.cs.swdesign.m2.Card.Suit;

public class CardList extends AbstractList<Card>
{
    private final Card[] aCards;

    CardList(Card[] pCards)
    {
        assert pCards!= null;
        aCards = pCards.clone();
    }

    @Override
    public Card get(int pIndex)
    {
        assert pIndex>=0 && pIndex<size();
        return aCards[pIndex];
    }

    @Override
    public int size()
    {
        return aCards.length;
    }


    public List<Card> getRange(int pStartIndex, int pEndIndex)
    {
        assert pStartIndex>=0 && pEndIndex<size();
        List<Card> cards = new ArrayList<>();
        for (int i = pStartIndex; i<=pEndIndex; i++)
        {
            // The proper behavior of the subclass depends on the implementation in super class
            // get(i) vs aCards[i] in this step:
            cards.add(get(i));
//            cards.add(aCards[i]);

        }
        return cards;
    }


    static void main(String[] pArgs)
    {
        Card[] cards = new Card[2];
        cards[0] = new Card(Rank.ACE, Suit.CLUBS);
        cards[1] = new Card(Rank.FIVE, Suit.DIAMONDS);
        CardList cardList = new CardList(cards);
        cardList.add(new Card(Rank.FOUR, Suit.SPADES));

        System.out.println(cardList.contains(cards[1]));
        for (Iterator<Card> iter = cardList.iterator(); iter.hasNext(); ) {
            Card element = iter.next();
            System.out.println(element);
        }

        // CardList is unmodifiable.
        // Will throw UnsupportedOperationException in the text statement
        // cardList.set(0, new Card(Rank.ACE, Suit.CLUBS));
    }


}
