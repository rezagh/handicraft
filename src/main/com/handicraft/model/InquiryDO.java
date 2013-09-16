/**
 * For customer feed backs.
 * 
 */
package com.handicraft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Inquiry is like a question or suggestion.
 * no need to be a registered user.
 * 
 *
 */
@Entity
@Table(name = "INQUIRY")
//@Cache(usage=org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class InquiryDO extends BaseDO {

	@Column(name="NAME")
	private String name;//when the user is not logged in
	
	@Column(name="EMAIL")
	private String email;//when the user is not logged in.

	@Column(name="MESSAGE")
	private String message;
	
	@Column(name="TYPE")
	private String type;

	
//------------------------------------------------

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
