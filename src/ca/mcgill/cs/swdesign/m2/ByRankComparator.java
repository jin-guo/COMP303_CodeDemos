package ca.mcgill.cs.swdesign.m2;

import java.util.Comparator;

public class ByRankComparator implements Comparator<Card>
{
	@Override
	public int compare(Card o1, Card o2)
	{
		assert o1!=null && o2!=null;
		return o1.getRank().compareTo(o2.getRank());
	}

}
