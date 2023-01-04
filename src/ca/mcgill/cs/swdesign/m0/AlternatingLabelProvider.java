package ca.mcgill.cs.swdesign.m0;

/**
 * Provides one of two pre-selected labels.
 */
public class AlternatingLabelProvider
{
	private final String aLabel1;
	private final String aLabel2;
	
	/**
	 * Initializes the two labels.
	 * @param pLabel1 The first label. 
	 * @param pLabel2 The second label.
	 * @pre {@code pLabel1 != null && pLabel2 != null;}
	 */
	public AlternatingLabelProvider(String pLabel1, String pLabel2) {
		assert pLabel1 != null && pLabel2 != null;
		aLabel1 = pLabel1;
		aLabel2 = pLabel2;
	}
	
	/**
	 * Returns one of the two labels as controlled by the parameter.
	 * @param pLabel True to return the first label, false otherwise.
	 * @return The selected label.
	 * @post return != null
	 */
	public String getLabel(boolean pLabel)
	{
		if( pLabel )
		{
			return aLabel1;
		}
		else
		{
			return aLabel2;
		}
	}
	
	/**
	 * @return Both labels separated by a space.
	 */
	public String getBoth()
	{
		return aLabel1 + " " + aLabel2;
	}
}
