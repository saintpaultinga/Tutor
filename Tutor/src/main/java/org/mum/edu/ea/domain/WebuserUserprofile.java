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
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebuserUserprofile.findAll", query = "SELECT w FROM WebuserUserprofile w")
    , @NamedQuery(name = "WebuserUserprofile.findByWebUserID", query = "SELECT w FROM WebuserUserprofile w WHERE w.webuser = :webUserID")
    , @NamedQuery(name = "WebuserUserprofile.findByUserProfileID", query = "SELECT w FROM WebuserUserprofile w WHERE w.userProfileID = :userProfileID")})
public class WebuserUserprofile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userProfileID;	

	@Column(name="TYPE", length=15, unique=true, nullable=false)
	@Enumerated(EnumType.STRING)
	private WebUserProfileType type ;
    @JoinColumn(name = "WebUser_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WebUser webuser;

    public WebuserUserprofile() {
    }

    public WebUser getWebuser() {
        return webuser;
    }

    public void setWebuser(WebUser webuser) {
        this.webuser = webuser;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userProfileID == null) ? 0 : userProfileID.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		WebuserUserprofile other = (WebuserUserprofile) obj;
		if (userProfileID == null) {
			if (other.userProfileID != null)
				return false;
		} else if (!userProfileID.equals(other.userProfileID))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
    
    

    
}
