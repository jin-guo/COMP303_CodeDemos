package ca.mcgill.cs.swdesign.m8;

public class JobService
{
	public static void main(String[] arg)
	{
		JobSeeker j1 = new UndergradJobSeeker(TechSpecialty.Testing, 0, true);
		JobSeeker j2 = new UndergradJobSeeker(TechSpecialty.Programming,5,true);
		Company startup = new Company("NewAge");
		startup.acceptApplication(j1);
		startup.acceptApplication(j2);
//		startup.noticeCandidates();
		
	}

}
