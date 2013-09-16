package com.handicraft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "PRODUCT")
// @Cache(usage=org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class ProductDO extends BaseDO {

	public ProductDO(Long id){
		super.setId(id);
	}
	
	public ProductDO(){}

	@Column(name="NAME")
	private String name;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="PRICE")
	private Double price;

	@ManyToOne(fetch=FetchType.EAGER,optional=false)
    @JoinColumn(name="CAT_ID")
	private ProductCategoryDO category;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="WEIGHT")
	private Double weight;
	
	@Column(name="WEIGHT_UNIT")
	private String weightUnit;

	@Column(name="QUANTITY")
	private Integer quantity;
	
	@Column(name="IMAGE_REF")
	private String imageRef;//it looks like : productcode.jpg - lowercase



	/**
size
availability: boolean
priceunit
location
posts to
sold history
year made
made by
sub category
attributes
quality level
	

 */

	public String toString() {
		return new ToStringBuilder(this).
			append("name", name).	
			append("code", code).
	    	append("price", price).
	    	toString();
	}

	
	// -------------------------------------------

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductCategoryDO getCategory() {
		return category;
	}

	public void setCategory(ProductCategoryDO dbCategory) {
		this.category = dbCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getImageRef() {
		return imageRef.toLowerCase();
	}

	public void setImageRef(String imageRef) {
		this.imageRef = imageRef;
	}
}
