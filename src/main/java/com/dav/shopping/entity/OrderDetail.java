package com.dav.shopping.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name ="OrderDetails")
@NamedQuery(name="OrderDetail.findAll", query="SELECT od FROM OrderDetail od")
public class OrderDetail implements Serializable{

	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="orderID",unique=true, nullable=false)
	private Order orderID;
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="productID",unique=true, nullable=false)
	private Product productID;
	
	private Integer Quantitty;

	public Order getOrderID() {
		return orderID;
	}

	public void setOrderID(Order orderID) {
		this.orderID = orderID;
	}

	public Product getProductID() {
		return productID;
	}

	public void setProductID(Product productID) {
		this.productID = productID;
	}

	public Integer getQuantitty() {
		return Quantitty;
	}

	public void setQuantitty(Integer quantitty) {
		Quantitty = quantitty;
	}
	
	
}
