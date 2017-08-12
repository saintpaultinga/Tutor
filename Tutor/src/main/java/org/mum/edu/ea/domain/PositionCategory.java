package org.mum.edu.ea.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class PositionCategory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	

	@Column(name="TYPE", length=15, unique=true, nullable=false)
	@Enumerated(EnumType.STRING)
	private Category type ;
	@OneToMany(mappedBy = "category")
	private Collection<Position> positions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getType() {
		return type;
	}

	public void setType(Category type) {
		this.type = type;
	}

	public Collection<Position> getPositions() {
		return positions;
	}

	public void setPositions(Collection<Position> positions) {
		this.positions = positions;
	}
}
