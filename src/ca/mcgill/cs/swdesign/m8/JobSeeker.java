package ca.mcgill.cs.swdesign.m8;

import java.time.LocalDateTime;

public interface JobSeeker
{
	void noticeMe(LocalDateTime date);
	TechSpecialty getTechSpecialty();
	int getYearOfExperience();
	boolean haveReference();
}
