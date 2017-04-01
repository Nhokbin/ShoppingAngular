package com.dav.shopping.entitytest;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Orders database table.
 * 
 */
@Entity
@Table(name="Orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Object createdBy;
	private Timestamp createdDate;
	private Object customerAddress;
	private Object customerEmail;
	private Object customerMessage;
	private Object customerMobile;
	private Object customerName;
	private Object paymentMethod;
	private Object paymentStatus;
	private boolean status;

	public Order() {
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


	@Column(name="CustomerAddress", nullable=false)
	public Object getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(Object customerAddress) {
		this.customerAddress = customerAddress;
	}


	@Column(name="CustomerEmail", nullable=false)
	public Object getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(Object customerEmail) {
		this.customerEmail = customerEmail;
	}


	@Column(name="CustomerMessage", nullable=false)
	public Object getCustomerMessage() {
		return this.customerMessage;
	}

	public void setCustomerMessage(Object customerMessage) {
		this.customerMessage = customerMessage;
	}


	@Column(name="CustomerMobile", nullable=false)
	public Object getCustomerMobile() {
		return this.customerMobile;
	}

	public void setCustomerMobile(Object customerMobile) {
		this.customerMobile = customerMobile;
	}


	@Column(name="CustomerName", nullable=false)
	public Object getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(Object customerName) {
		this.customerName = customerName;
	}


	@Column(name="PaymentMethod")
	public Object getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(Object paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	@Column(name="PaymentStatus")
	public Object getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(Object paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	@Column(name="Status", nullable=false)
	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}