package ca.mcgill.cs.swdesign.m1;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card7> aCards = new ArrayList<>();

    public void addCard(Card7 pCard) {
        aCards.add(pCard);
    }

    public List<Card7> getCards(){
        return new ArrayList<>(aCards);
    }
    public void print(){
        for(Card7 card: aCards) {
            System.out.println(card.toString());
        }
    }
}
