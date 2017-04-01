package com.dav.shopping.entitytest;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Pages database table.
 * 
 */
@Entity
@Table(name="Pages")
@NamedQuery(name="Page.findAll", query="SELECT p FROM Page p")
public class Page implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String alias;
	private Object content;
	private Object createdBy;
	private Timestamp createdDate;
	private Object metaDescription;
	private Object metaKeyword;
	private Object name;
	private boolean status;
	private Object updatedBy;
	private Timestamp updatedDate;

	public Page() {
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


	@Column(name="Alias", nullable=false, length=256)
	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}


	@Column(name="Content")
	public Object getContent() {
		return this.content;
	}

	public void setContent(Object content) {
		this.content = content;
	}


	@Column(name="CreatedBy")
	public Object getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Object createdBy) {
		this.createdBy = createdBy;
	}


	@Column(name="CreatedDate")
	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	@Column(name="MetaDescription")
	public Object getMetaDescription() {
		return this.metaDescription;
	}

	public void setMetaDescription(Object metaDescription) {
		this.metaDescription = metaDescription;
	}


	@Column(name="MetaKeyword")
	public Object getMetaKeyword() {
		return this.metaKeyword;
	}

	public void setMetaKeyword(Object metaKeyword) {
		this.metaKeyword = metaKeyword;
	}


	@Column(name="Name", nullable=false)
	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}


	@Column(name="Status", nullable=false)
	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	@Column(name="UpdatedBy")
	public Object getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Object updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Column(name="UpdatedDate")
	public Timestamp getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

}