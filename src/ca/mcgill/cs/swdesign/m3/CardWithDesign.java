package ca.mcgill.cs.swdesign.m3;

import ca.mcgill.cs.swdesign.m2.Card;
import java.util.Objects;

public class CardWithDesign extends Card {
    public enum Design{ CLASSIC, ARTISTIC, FUN}
    Design aStyle;

    public CardWithDesign(Rank pRank, Suit pSuit, Design pStyle) {
        super(pRank, pSuit);
        assert pStyle!=null;
        aStyle = pStyle;
    }

    /**
     * Change different implementations in Card and CardWithDesign
     * for how to compare objects of Card and CardWithDesign
     * and see its impact.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CardWithDesign that = (CardWithDesign) o;
        return aStyle == that.aStyle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), aStyle);
    }

    public static void main(String[] args) {
        Card card1 = new CardWithDesign(Card.Rank.FOUR, Card.Suit.CLUBS, 	CardWithDesign.Design.ARTISTIC);
        Card card2 = new CardWithDesign(Card.Rank.FOUR, Card.Suit.CLUBS, 	CardWithDesign.Design.CLASSIC);
        Card card3 = new Card(Card.Rank.FOUR, Card.Suit.CLUBS);
        System.out.println(card1.equals(card2));
        System.out.println(card2.equals(card1));
        System.out.println(card1.equals(card3));
        System.out.println(card3.equals(card1));
    }
   
}
