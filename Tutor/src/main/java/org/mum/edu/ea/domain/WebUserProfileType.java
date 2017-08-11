package org.mum.edu.ea.domain;

import java.io.Serializable;


public enum WebUserProfileType implements Serializable {
	
	ADMIN("Admin"), JOBSEEKER("JobSeeker"), JOBPROVIDER("JobProvider");
	

	String profileType;
	
	private WebUserProfileType(String profileType){
		this.profileType = profileType;
	}
	
	public String getUserProfileType(){
		return profileType;
	}

}
