/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.edu.ea.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TSPDEV
 */
@Entity
@Table(name = "webuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Webuser.findAll", query = "SELECT w FROM Webuser w")
    , @NamedQuery(name = "Webuser.findById", query = "SELECT w FROM Webuser w WHERE w.id = :id")
    , @NamedQuery(name = "Webuser.findByEmail", query = "SELECT w FROM Webuser w WHERE w.email = :email")
    , @NamedQuery(name = "Webuser.findByFirstname", query = "SELECT w FROM Webuser w WHERE w.firstname = :firstname")
    , @NamedQuery(name = "Webuser.findByLastconnected", query = "SELECT w FROM Webuser w WHERE w.lastconnected = :lastconnected")
    , @NamedQuery(name = "Webuser.findByLastname", query = "SELECT w FROM Webuser w WHERE w.lastname = :lastname")
    , @NamedQuery(name = "Webuser.findByPassword", query = "SELECT w FROM Webuser w WHERE w.password = :password")
    , @NamedQuery(name = "Webuser.findByStatus", query = "SELECT w FROM Webuser w WHERE w.status = :status")})
public class Webuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LASTCONNECTED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastconnected;
    @Size(max = 255)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;
    @Lob
    @Column(name = "PICTURE")
    private byte[] picture;
    @ManyToMany(mappedBy = "webuserCollection")
    private Collection<Position> positionCollection;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    @ManyToOne
    private Address addressId;
    @OneToMany(mappedBy = "webuserId")
    private Collection<Message> messageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "webuser")
    private Collection<WebuserUserprofile> webuserUserprofileCollection;

    public Webuser() {
    }

    public Webuser(Long id) {
        this.id = id;
    }

    public Webuser(Long id, Date lastconnected) {
        this.id = id;
        this.lastconnected = lastconnected;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getLastconnected() {
        return lastconnected;
    }

    public void setLastconnected(Date lastconnected) {
        this.lastconnected = lastconnected;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @XmlTransient
    public Collection<Position> getPositionCollection() {
        return positionCollection;
    }

    public void setPositionCollection(Collection<Position> positionCollection) {
        this.positionCollection = positionCollection;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    @XmlTransient
    public Collection<WebuserUserprofile> getWebuserUserprofileCollection() {
        return webuserUserprofileCollection;
    }

    public void setWebuserUserprofileCollection(Collection<WebuserUserprofile> webuserUserprofileCollection) {
        this.webuserUserprofileCollection = webuserUserprofileCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Webuser)) {
            return false;
        }
        Webuser other = (Webuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.domain.Webuser[ id=" + id + " ]";
    }
    
}
