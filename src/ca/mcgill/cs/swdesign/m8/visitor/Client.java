package ca.mcgill.cs.swdesign.m8.visitor;
/***
 * Documentation and design by contact are not included in the code demo.
 *  Please make sure to properly include them in the assignment.
 */

public class Client
{
	public static void main(String[] args)
	{
		
		University mcGill = new University("McGill");
		
		Faculty science = new Faculty("Science");
		Faculty arts = new Faculty("Arts");
		
		Department cs = new Department("Computer Science");
		Department physics = new Department("Physics");
		Department history = new Department("History and Classical Studies");
		
		Committee lAca = new Committee("Academic");
		Committee lSco = new Committee("Scholarship");
		Committee lMsc = new Committee("MSc");
		Committee lWeb = new Committee("Web");
		Committee lStudents = new Committee("Students");
		
		mcGill.addFaculty(science);
		mcGill.addFaculty(arts);
		science.addDepartment(cs);
		science.addDepartment(physics);
		arts.addDepartment(history);
		
		science.addCommittee(lAca);
		science.addCommittee(lSco);
		arts.addCommittee(lStudents);
		
		cs.addCommittee(lMsc);
		lMsc.addCommittee(lWeb);
	
		SearchVisitor searcher = new SearchVisitor("MSc");
		mcGill.accept(searcher);
		OrgNode result = searcher.getResult();
		System.out.println("Search result: " + result.getName());

		mcGill.accept(new PrintVisitor());
	}
}
