package ca.mcgill.cs.swdesign.m8;



public interface ApplicationObserver
{
	void applicationAdded(JobSeeker pJobSeeker);
	void applicationRemoved(JobSeeker pJobSeeker);
}
