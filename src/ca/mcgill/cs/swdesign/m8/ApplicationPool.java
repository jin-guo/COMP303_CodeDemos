package ca.mcgill.cs.swdesign.m8;

/**
 * Provide state of interest (JobSeeker added or removed) to ApplicationObserver
 * The notification to ApplicationObserver is called automatically
 *  
 */
public interface ApplicationPool
{
	void addApplicationObserver(ApplicationObserver pApplicationObservers);
	void removeApplicationObserver(ApplicationObserver pApplicationObservers);
}
