package ca.mcgill.cs.swdesign.m8;

import java.util.ArrayList;
import java.util.List;

public class DesignTeam implements ApplicationObserver
{
	private List<JobSeeker> aCandidate;

	DesignTeam()
	{
		aCandidate = new ArrayList<JobSeeker>();
	}
	
	@Override
	public void applicationAdded(JobSeeker pJobSeeker)
	{
		assert pJobSeeker != null;
		if (pJobSeeker.getTechSpecialty() == TechSpecialty.UI_Design
			&& pJobSeeker.getYearOfExperience()>=5)
		{
			aCandidate.add(pJobSeeker);
			System.out.println("*DesignTeam* Candidate Found!");
		}
	}

	@Override
	public void applicationRemoved(JobSeeker pJobSeeker)
	{
		assert pJobSeeker != null;
		if(aCandidate.contains(pJobSeeker)) 
		{
			aCandidate.remove(pJobSeeker);
			System.out.println("*DesignTeam* Candidate Removed!");
	
		}
	}


}
