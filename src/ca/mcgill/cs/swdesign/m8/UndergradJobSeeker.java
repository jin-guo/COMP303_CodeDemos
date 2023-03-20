package ca.mcgill.cs.swdesign.m8;

import java.time.LocalDateTime;

public class UndergradJobSeeker implements JobSeeker
{
	private boolean aReadyForInterview = false;
	private TechSpecialty aTechSpecialty;
	private int aYearOfExperience;
	private boolean aHasReference;
	private JobProvider aDreamJob;
	
	
	public UndergradJobSeeker(TechSpecialty pTechSpecialty, int pYearOfExperience, boolean pHasReference)
	{
		assert pTechSpecialty!=null && pYearOfExperience>=0;
		aTechSpecialty = pTechSpecialty;
		aYearOfExperience = pYearOfExperience;
		aHasReference = pHasReference;
	}

	@Override
	public void setDreamJob(JobProvider pDreamJob)
	{
		assert  pDreamJob != null;
		aDreamJob = pDreamJob;
	}

	@Override
	public void noticeMe(LocalDateTime interviewDate)
	{
		assert interviewDate != null;
		System.out.println("Received interview date for " + aDreamJob.toString());
		System.out.println(interviewDate.toString());
		practice();
	}

	private void practice()
	{
		aReadyForInterview = true;
	}

	@Override
	public TechSpecialty getTechSpecialty()
	{
		return aTechSpecialty;
		
	}

	@Override
	public int getYearOfExperience()
	{
		return aYearOfExperience;
	}

	@Override
	public boolean haveReference()
	{
		return aHasReference; 
	}

}
