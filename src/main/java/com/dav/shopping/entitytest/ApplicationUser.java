package com.dav.shopping.entitytest;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ApplicationUsers database table.
 * 
 */
@Entity
@Table(name="ApplicationUsers")
@NamedQuery(name="ApplicationUser.findAll", query="SELECT a FROM ApplicationUser a")
public class ApplicationUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private int accessFailedCount;
	private Object address;
	private Timestamp birthDay;
	private Object email;
	private boolean emailConfirmed;
	private Object fullName;
	private boolean lockoutEnabled;
	private Timestamp lockoutEndDateUtc;
	private Object passwordHash;
	private Object phoneNumber;
	private boolean phoneNumberConfirmed;
	private Object securityStamp;
	private boolean twoFactorEnabled;
	private Object userName;
	private List<IdentityUserLogin> identityUserLogins;

	public ApplicationUser() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", unique=true, nullable=false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(name="AccessFailedCount", nullable=false)
	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}


	@Column(name="Address")
	public Object getAddress() {
		return this.address;
	}

	public void setAddress(Object address) {
		this.address = address;
	}


	@Column(name="BirthDay")
	public Timestamp getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Timestamp birthDay) {
		this.birthDay = birthDay;
	}


	@Column(name="Email")
	public Object getEmail() {
		return this.email;
	}

	public void setEmail(Object email) {
		this.email = email;
	}


	@Column(name="EmailConfirmed", nullable=false)
	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}


	@Column(name="FullName")
	public Object getFullName() {
		return this.fullName;
	}

	public void setFullName(Object fullName) {
		this.fullName = fullName;
	}


	@Column(name="LockoutEnabled", nullable=false)
	public boolean getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}


	@Column(name="LockoutEndDateUtc")
	public Timestamp getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Timestamp lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}


	@Column(name="PasswordHash")
	public Object getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(Object passwordHash) {
		this.passwordHash = passwordHash;
	}


	@Column(name="PhoneNumber")
	public Object getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Object phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Column(name="PhoneNumberConfirmed", nullable=false)
	public boolean getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}


	@Column(name="SecurityStamp")
	public Object getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(Object securityStamp) {
		this.securityStamp = securityStamp;
	}


	@Column(name="TwoFactorEnabled", nullable=false)
	public boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}


	@Column(name="UserName")
	public Object getUserName() {
		return this.userName;
	}

	public void setUserName(Object userName) {
		this.userName = userName;
	}


	//bi-directional many-to-one association to IdentityUserLogin
	@OneToMany(mappedBy="applicationUser", fetch=FetchType.EAGER)
	public List<IdentityUserLogin> getIdentityUserLogins() {
		return this.identityUserLogins;
	}

	public void setIdentityUserLogins(List<IdentityUserLogin> identityUserLogins) {
		this.identityUserLogins = identityUserLogins;
	}

	public IdentityUserLogin addIdentityUserLogin(IdentityUserLogin identityUserLogin) {
		getIdentityUserLogins().add(identityUserLogin);
		identityUserLogin.setApplicationUser(this);

		return identityUserLogin;
	}

	public IdentityUserLogin removeIdentityUserLogin(IdentityUserLogin identityUserLogin) {
		getIdentityUserLogins().remove(identityUserLogin);
		identityUserLogin.setApplicationUser(null);

		return identityUserLogin;
	}

}