package com.dav.shopping.entitytest;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Footers database table.
 * 
 */
@Entity
@Table(name="Footers")
@NamedQuery(name="Footer.findAll", query="SELECT f FROM Footer f")
public class Footer implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Object content;

	public Footer() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name="Content", nullable=false)
	public Object getContent() {
		return this.content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

}