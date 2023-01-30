package ca.mcgill.cs.swdesign.m2;

import java.util.Comparator;

public class Game
{
	private Deck aDeck = new Deck();
	
	public Game()
	{
		aDeck.shuffle();
		System.out.println(aDeck);
		// Using anonymous class to create a comparator instance
		aDeck.sort(new Comparator<Card>() {
			@Override
			public int compare(Card o1, Card o2) {
				return o1.getSuit().compareTo(o2.getSuit());
			}
		});

		System.out.println(aDeck);
	}
	
	public static void main(String[] args)
	{
		new Game();
	}
}
