package ca.mcgill.cs.swdesign.m8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company is observed by the JobSeeker and ApplicationObserver at the same time
 * JobSeeker is interested in its interview schedule and 
 * ApplicationObserver is interested in the characteristics of JobSeekers.
 * The observable interfaces to JobSeeker and ApplicationObserver are defined 
 * in JobProvider and ApplicationPool respectively.
 * 
 * @author jinguo_office
 *
 */
public class Company implements JobProvider, ApplicationPool
{
	private final String aName;
	private final List<JobSeeker> aJobSeekers;
	private boolean acceptApplication;
	private final Map<JobSeeker, LocalDateTime> aInterviewSchedules;
	
	private List<ApplicationObserver> aApplicationObservers;
	
	public Company(String pName)
	{
		assert pName!=null;
		aName = pName;
		aJobSeekers = new ArrayList<>();
		aInterviewSchedules = new HashMap<>();
		aApplicationObservers = new ArrayList<>();
		acceptApplication = true;
	}

	@Override
	public void noticeCandidates() {
        aInterviewSchedules.forEach((k,v) -> k.noticeMe(v)); // The same effect with the following way of iterating the map
// for(Map.Entry<JobSeeker, LocalDateTime> entry : aInterviewSchedules.entrySet()) {
// 	entry.getKey().noticeMe(entry.getValue());
// }
	}
	
	@Override  
	public void addApplicationObserver(ApplicationObserver pApplicationObservers) {
		assert pApplicationObservers!=null;
		aApplicationObservers.add(pApplicationObservers);
	}
	
	@Override
	public void removeApplicationObserver(ApplicationObserver pApplicationObservers) {
		assert pApplicationObservers!=null;
		aApplicationObservers.remove(pApplicationObservers);
	}
	
	@Override
	public void acceptApplication(JobSeeker pJobseeker)
	{
		assert pJobseeker != null;
		if (acceptApplication)
		{
			aJobSeekers.add(pJobseeker);
			pJobseeker.setAppliedJob(this);
			scheduleInterview(pJobseeker);
			notifyApplicationAdded(pJobseeker);
		}
	}
	
	
	@Override
	public void withdrawApplication(JobSeeker pJobSeeker)
	{
		assert pJobSeeker!=null;
		if(aJobSeekers.contains(pJobSeeker))
		{
			aJobSeekers.remove(pJobSeeker);
			notifyApplicationRemoved(pJobSeeker);
		}
		
		if(aInterviewSchedules.containsKey(pJobSeeker))
		{
			aInterviewSchedules.remove(pJobSeeker);
		}
		
	}

	
	/**
	 * Setup interview date is three days from today 
	 * @param pJobseeker the candidate to schedule an interview for.
	 */
	private void scheduleInterview(JobSeeker pJobseeker) {
		assert pJobseeker != null;
        aInterviewSchedules.put(pJobseeker, LocalDateTime.now().plusDays(3));
	}
	
	/**
	 * The notification to ApplicationObserver is triggered automatically 
	 * when application is added.
	 */
	private void notifyApplicationAdded(JobSeeker pJobseeker)
	{
		assert pJobseeker != null;
		for(ApplicationObserver observer:aApplicationObservers)
		{
			observer.applicationAdded(pJobseeker);
		}
		
	}

	/**
	 * The notification to ApplicationObserver is triggered automatically 
	 * when application is removed.
	 */
	private void notifyApplicationRemoved(JobSeeker pJobseeker)
	{
		for(ApplicationObserver observer:aApplicationObservers)
		{
			observer.applicationRemoved(pJobseeker);
		}
	}

	@Override
	public String toString()
	{
		return aName;
	}

	public static void main(String[] arg)
	{
		JobSeeker j1 = new UndergradJobSeeker(TechSpecialty.Testing, 0, true);
		JobSeeker j2 = new UndergradJobSeeker(TechSpecialty.Programming,5,true);
		JobSeeker j3 = new UndergradJobSeeker(TechSpecialty.UI_Design, 10, true);
		JobSeeker j4 = new UndergradJobSeeker(TechSpecialty.Programming,2,false);

		Company startup = new Company("Frontier");
		ApplicationObserver hrTeam = new HRTeam();
		ApplicationObserver designTeam = new DesignTeam();
		startup.addApplicationObserver(hrTeam);
		startup.addApplicationObserver(designTeam);

		startup.acceptApplication(j1);
		startup.acceptApplication(j2);
		startup.acceptApplication(j3);
		startup.acceptApplication(j4);
		startup.withdrawApplication(j3);
		startup.withdrawApplication(j4);
		startup.withdrawApplication(j4);
	}
}
