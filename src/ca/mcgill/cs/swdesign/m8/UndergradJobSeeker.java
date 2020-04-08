package ca.mcgill.cs.swdesign.m8;

import java.time.LocalDateTime;

public class UndergradJobSeeker implements JobSeeker
{
	private boolean aReadyForInterview = false;
	private TechSpecialty aTechSpecialty;
	private int aYearOfExperience;
	private boolean aHasReference;
	
	
	public UndergradJobSeeker(TechSpecialty pTechSpecialty, int pYearOfExperience, boolean pHasReference)
	{
		aTechSpecialty = pTechSpecialty;
		aYearOfExperience = pYearOfExperience;
		aHasReference = pHasReference;
	}

	@Override
	public void noticeMe(LocalDateTime interviewDate)
	{
		System.out.println("Received interview date:");
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
