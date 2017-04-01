package com.dav.shopping.entitytest;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Errors database table.
 * 
 */
@Entity
@Table(name="Errors")
@NamedQuery(name="Error.findAll", query="SELECT e FROM Error e")
public class Error implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Timestamp createdDate;
	private Object message;
	private Object stackTrace;

	public Error() {
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


	@Column(name="CreatedDate", nullable=false)
	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	@Column(name="Message")
	public Object getMessage() {
		return this.message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}


	@Column(name="StackTrace")
	public Object getStackTrace() {
		return this.stackTrace;
	}

	public void setStackTrace(Object stackTrace) {
		this.stackTrace = stackTrace;
	}

}