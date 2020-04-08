package ca.mcgill.cs.swdesign.m8;

import java.util.HashMap;
import java.util.Map;

public class HRTeam implements ApplicationObserver
{
	Map<TechSpecialty, Integer> aSpectialtyCount;
	
	HRTeam()
	{
		aSpectialtyCount = new HashMap<>();
		for(TechSpecialty specialty: TechSpecialty.values())
		{
			aSpectialtyCount.put(specialty, 0);
		}
	}

	@Override
	public void applicationAdded(JobSeeker pJobSeeker)
	{
		assert pJobSeeker != null;
		int count = aSpectialtyCount.get(pJobSeeker.getTechSpecialty()) + 1;
		aSpectialtyCount.put(pJobSeeker.getTechSpecialty(), count);
		
		System.out.printf("Updated: %s - %d\n", pJobSeeker.getTechSpecialty(), count);
	}

	@Override
	public void applicationRemoved(JobSeeker pJobSeeker)
	{
	
		int count = aSpectialtyCount.get(pJobSeeker.getTechSpecialty())-1;
		aSpectialtyCount.put(pJobSeeker.getTechSpecialty(), count);	
		
		System.out.printf("Updated: %s - %d\n", pJobSeeker.getTechSpecialty(), count);

	}
	

}
