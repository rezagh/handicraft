package com.handicraft.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USERS")
//@Cache(usage=org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class UserDO extends BaseDO implements UserDetails{

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "FIRST_NAME")
	private String firstname;
	
	@Column(name = "LAST_NAME")
	private String lastname;
	
	@Column(name = "ADR_LINE_1")
	private String addressLine1;

	@Column(name = "ADR_LINE_2")
	private String addressLine2;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "POST_CODE")
	private String postCode;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "LOGIN_ATTEMPT_COUNT")
	private Integer loginAttemptCount;

	@Column(name = "ACCOUNT_NON_LOCK")
	private Boolean accountNonLocked;

	
	//TODO not mapped yet
	private transient Boolean accountNonExpired = true;
	private transient Boolean credentialsNonExpired = true;

//--------------------------------------------------------------------------
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(1);
		 authList.add(new GrantedAuthorityImpl(this.getRole()));
		return authList;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.SHORT_PREFIX_STYLE).
          append("email", email).
          append("password", password).
          toString();
    }

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		if(accountNonLocked == null) return true;
		return this.accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		 this.accountNonLocked = accountNonLocked;
	}

	@Override
	public boolean isEnabled() {
//		if(super.isActive() == null) return true;
//		return super.isActive();//think they have the same meanings for us
		return true;
	}
	
	@Override
	public String getUsername() {
		return email;
	}


//-----------------------------------------------------------------------------

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public Integer getLoginAttemptCount() {
		if (loginAttemptCount == null) return 0;
		return loginAttemptCount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setLoginAttemptCount(Integer loginAttemptCount) {
		this.loginAttemptCount = loginAttemptCount;
	}
}
