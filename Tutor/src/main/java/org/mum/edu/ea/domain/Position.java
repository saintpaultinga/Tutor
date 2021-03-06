/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mum.edu.ea.domain;

import org.springframework.data.geo.Point;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TSPDEV
 */
@Entity
@Table(name = "position")
@NamedQueries({
    @NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p")
    , @NamedQuery(name = "Position.findById", query = "SELECT p FROM Position p WHERE p.id = :id")
    , @NamedQuery(name = "Position.findByCategory", query = "SELECT p FROM Position p WHERE p.category = :category")
    , @NamedQuery(name = "Position.findByDuration", query = "SELECT p FROM Position p WHERE p.duration = :duration")
    , @NamedQuery(name = "Position.findByEstimatedwage", query = "SELECT p FROM Position p WHERE p.estimatedwage = :estimatedwage")
//    , @NamedQuery(name = "Position.findByPosteddate", query = "SELECT p FROM Position p WHERE p.posteddate = :posteddate")
    , @NamedQuery(name = "Position.findByStatus", query = "SELECT p FROM Position p WHERE p.status = :status")
    , @NamedQuery(name = "Position.findByTitle", query = "SELECT p FROM Position p WHERE p.title = :title")
    , @NamedQuery(name = "Position.findByDescription", query = "SELECT p FROM Position p WHERE p.description = :description")})
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
//    @Size(max = 255)
//    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER)
//    @ManyToOne
    private String category;
    @Column(name = "DURATION")
    private Integer duration;
    @Column(name = "ESTIMATEDWAGE")
    private Integer estimatedwage;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "DEADLINE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;
//    @Size(max = 255)
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private PositionStatus status;
    @Size(max = 255)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "posted_by")
    private String postedBy;
    @ManyToMany
    @JoinTable(name = "appliedBy_position", joinColumns = {
        @JoinColumn(name = "positions_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "webUsers_ID", referencedColumnName = "ID")})
    private Set<WebUser> webuserCollection = new HashSet<>();
//    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "ID")
//    @ManyToOne (cascade = CascadeType.PERSIST)
//    private Location locationId;
    private String jobLocation;

    private String selectedUser;

    public Position() {
    }

    public Position(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getEstimatedwage() {
        return estimatedwage;
    }

    public void setEstimatedwage(Integer estimatedwage) {
        this.estimatedwage = estimatedwage;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public PositionStatus getStatus() {
        return status;
    }

    public void setStatus(PositionStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
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
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Set<WebUser> getWebuserCollection() {
        return webuserCollection;
    }

    public void setWebuserCollection(Set<WebUser> webuserCollection) {
        this.webuserCollection = webuserCollection;
    }

    public  void setWebUser(WebUser webUser){
        this.webuserCollection.add(webUser);
    }

    public String getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(String selectedUser) {
        this.selectedUser = selectedUser;
    }

    @Override
    public String toString() {
        return "com.example.domain.Position[ id=" + id + ",Description="+description +" ]";
    }
    
}
