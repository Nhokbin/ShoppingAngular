package com.dav.shopping.entitytest;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MenuGroups database table.
 * 
 */
@Entity
@Table(name="MenuGroups")
@NamedQuery(name="MenuGroup.findAll", query="SELECT m FROM MenuGroup m")
public class MenuGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Object name;

	public MenuGroup() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name="Name", nullable=false)
	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

}