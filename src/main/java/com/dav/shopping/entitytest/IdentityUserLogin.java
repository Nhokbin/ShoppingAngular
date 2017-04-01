package com.dav.shopping.entitytest;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the IdentityUserLogins database table.
 * 
 */
@Entity
@Table(name="IdentityUserLogins")
@NamedQuery(name="IdentityUserLogin.findAll", query="SELECT i FROM IdentityUserLogin i")
public class IdentityUserLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId;
	private Object loginProvider;
	private Object providerKey;
	private ApplicationUser applicationUser;

	public IdentityUserLogin() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserId", unique=true, nullable=false)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Column(name="LoginProvider")
	public Object getLoginProvider() {
		return this.loginProvider;
	}

	public void setLoginProvider(Object loginProvider) {
		this.loginProvider = loginProvider;
	}


	@Column(name="ProviderKey")
	public Object getProviderKey() {
		return this.providerKey;
	}

	public void setProviderKey(Object providerKey) {
		this.providerKey = providerKey;
	}


	//bi-directional many-to-one association to ApplicationUser
	@ManyToOne
	@JoinColumn(name="ApplicationUser_Id")
	public ApplicationUser getApplicationUser() {
		return this.applicationUser;
	}

	public void setApplicationUser(ApplicationUser applicationUser) {
		this.applicationUser = applicationUser;
	}

}