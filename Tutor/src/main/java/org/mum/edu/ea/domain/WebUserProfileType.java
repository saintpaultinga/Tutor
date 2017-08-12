package org.mum.edu.ea.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class WebUserProfileType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long profileTypeId;
	private String profilename;
	@Basic(optional = true)
	@OneToMany(mappedBy = "role", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<WebUserProfile> userRoles = new HashSet<>();

	public Long getProfileTypeId() {
		return profileTypeId;
	}

	public void setProfileTypeId(Long profileTypeId) {
		this.profileTypeId = profileTypeId;
	}

	public String getProfilename() {
		return profilename;
	}

	public void setProfilename(String profilename) {
		this.profilename = profilename;
	}

	public Set<WebUserProfile> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<WebUserProfile> userRoles) {
		this.userRoles = userRoles;
	}
	
     
}
