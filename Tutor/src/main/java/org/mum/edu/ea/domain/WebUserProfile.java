/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.edu.ea.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TSPDEV
 */
@Entity
@Table(name = "webuser_userprofile")
@NamedQueries({
    @NamedQuery(name = "WebUserProfile.findAll", query = "SELECT w FROM WebUserProfile w")
    , @NamedQuery(name = "WebUserProfile.findByWebUserID", query = "SELECT w FROM WebUserProfile w WHERE w.webuser = :webUserID")
    , @NamedQuery(name = "WebUserProfile.findByUserProfileID", query = "SELECT w FROM WebUserProfile w WHERE w.userProfileID = :userProfileID")})
public class WebUserProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userProfileID;	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="role_id")
	private WebUserProfileType role ;
    @JoinColumn(name = "WebUser_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private WebUser webuser;

    public WebUserProfile() {
    }

    public WebUser getWebuser() {
        return webuser;
    }

    public void setWebuser(WebUser webuser) {
        this.webuser = webuser;
    }
    
    

	public Integer getUserProfileID() {
		return userProfileID;
	}

	public void setUserProfileID(Integer userProfileID) {
		this.userProfileID = userProfileID;
	}

	public WebUserProfileType getRole() {
		return role;
	}

	public void setRole(WebUserProfileType role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userProfileID == null) ? 0 : userProfileID.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebUserProfile other = (WebUserProfile) obj;
		if (userProfileID == null) {
			if (other.userProfileID != null)
				return false;
		} else if (!userProfileID.equals(other.userProfileID))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
    
    

    
}
