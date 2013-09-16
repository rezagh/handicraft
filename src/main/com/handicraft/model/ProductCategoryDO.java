package com.handicraft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_CATEGORY")
// @Cache(usage=org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class ProductCategoryDO extends BaseDO {
	public ProductCategoryDO(){}
	
	public ProductCategoryDO(Long id){
		super.setId(id);
	}
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CODE")
	private String code;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=true)
    @JoinColumn(name="PARENT_CAT")
	private ProductCategoryDO parentCategory;

	@Column(name="SHORT_DESC")
	private String shortDesc;
	
	@Column(name="LONG_DESC")
	private String longDesc;

	@Column(name="IMAGE_REF")
	private String imageRef;//it looks like categorycode.jpg lowercase

//--------------------------------------------------------------------------------
	
	/*
	ceramics
	bamboo
	khatam
	mina
	glass?
	kilim
	poster
	card
	book
	silver
	 */

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public String getImageRef() {
		return imageRef.toLowerCase();
	}
	public void setImageRef(String imageRef) {
		this.imageRef = imageRef;
	}

	public ProductCategoryDO getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(ProductCategoryDO parentCategory) {
		this.parentCategory = parentCategory;
	}
}
