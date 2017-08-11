package org.mum.edu.ea.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class PositionCategory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ig;	

	@Column(name="TYPE", length=15, unique=true, nullable=false)
	@Enumerated(EnumType.STRING)
	private Category type ;
	@OneToMany
	private Collection<Position> positions;

}
