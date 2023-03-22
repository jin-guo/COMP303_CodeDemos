package ca.mcgill.cs.swdesign.m8.visitor;

public class PrintVisitor extends AbstractVisitor
{
	
	private final StringBuilder aPrefix = new StringBuilder();
	private static final String TAB = "   ";
	
	private void increaseTab()
	{
		aPrefix.append(TAB);
	}
	
	private void decreaseTab()
	{
		aPrefix.delete(aPrefix.length()-TAB.length(), aPrefix.length());
	}
	
	private String tab()
	{
		return aPrefix.toString();
	}

	@Override
	public void visitUniversity(University pUniversity)
	{
		System.out.println(pUniversity.getName());
		increaseTab();
		super.visitUniversity(pUniversity);
		decreaseTab();
		
	}

	@Override
	public void visitFaculty(Faculty pFaculty)
	{
		System.out.println(tab() + pFaculty.getName());
		increaseTab();
		super.visitFaculty(pFaculty);
		decreaseTab();
		
		
	}

	@Override
	public void visitDepartment(Department pDepartment)
	{
		System.out.println(tab() + pDepartment.getName());
		increaseTab();
		super.visitDepartment(pDepartment);
		decreaseTab();
	}

	@Override
	public void visitCommittee(Committee pCommittee)
	{
		System.out.println(tab() + "C: " + pCommittee.getName());
		increaseTab();
		super.visitCommittee(pCommittee);
		decreaseTab();
	}	
}
