package ca.mcgill.cs.swdesign.m1;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card6> aCards = new ArrayList<>();

    public void addCard(Card6 pCard) {
        aCards.add(pCard);
    }

    public void print(){
        for(Card6 card: aCards) {
            System.out.println(card.toString());
        }
    }
}
