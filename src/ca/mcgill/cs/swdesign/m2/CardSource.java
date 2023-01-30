package ca.mcgill.cs.swdesign.m2;

/**
 * Primitive for representing card sources.
 */
public interface CardSource
{
	public static CardSource NULL = new CardSource() {
		@Override
		public Card draw() {
			assert isEmpty();
			return null;
		}

		@Override
		public boolean isEmpty() {
			return true;
		}
	};
	/**
	 * Remove a card from the source and return it.
	 * 
	 * @return The card that was removed from the source
	 * @pre size()>0	 
	 */
	Card draw();
	
	/**
	 * @return True if and only if there is no card in the deck.
	 */
	boolean isEmpty();
}

