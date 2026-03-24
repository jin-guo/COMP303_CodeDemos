package ca.mcgill.cs.swdesign.m8;

/**
 * Provide state of interest (interview schedule) to JobSeeker
 * The notification to JobSeeker need to be called explicitly by client
 *  
 */
public interface JobProvider
{
	void acceptApplication(JobSeeker pJobSeeker);
	void withdrawApplication(JobSeeker pJobSeeker);
	void noticeCandidates();
}
