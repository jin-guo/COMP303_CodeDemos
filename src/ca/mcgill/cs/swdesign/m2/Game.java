package ca.mcgill.cs.swdesign.m2;

import java.util.Comparator;

public class Game
{



	private Deck aDeck = new Deck();
	
	public Game()
	{
		aDeck.shuffle();
		System.out.println("--------------Original Order---------------");
		System.out.println(aDeck);


		System.out.println("--------------Ordered By Rank---------------");
		aDeck.sort(new ByRankComparator()); // same effect with aDeck.sort(Card.createByRankComparator());
		System.out.println(aDeck);

		System.out.println("--------------Ordered By Suit---------------");

		// Using anonymous class to create a comparator instance
		aDeck.sort(new Comparator<>() {
			@Override
			public int compare(Card o1, Card o2) {
				return o1.getSuit().compareTo(o2.getSuit());
			}
		});
		System.out.println(aDeck);

		System.out.println("--------------Iterating Each Card in Deck---------------");
		for(Card c:aDeck) {
			System.out.println(c);
		}

	}
	
	public static void main(String[] args)
	{
		new Game();
	}


}
