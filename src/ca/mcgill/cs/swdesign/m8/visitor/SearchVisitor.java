package ca.mcgill.cs.swdesign.m8.visitor;

public class SearchVisitor extends AbstractVisitor
{
	private final String aQuery;
	private OrgNode aResult = new NullOrgNode();
	
	public SearchVisitor(String pQuery)
	{
		aQuery = pQuery;	
	}
	
	OrgNode getResult() {return aResult; }

	@Override
	public void visitCommittee(Committee pCommittee)
	{
		if( pCommittee.getName().equals(aQuery))
		{
			aResult = pCommittee;
		}
		super.visitCommittee(pCommittee);
	}		

}


