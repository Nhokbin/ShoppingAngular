package com.dav.shopping.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Products")
@NamedQuery(name="Products.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private Integer id;
	
	private String name;
	private String alias;
	private String image;
	private String moreImages;
	private Double price;
	private Double promotionPrice;
	private Integer warranty;
	private String description;
	private String content;
	private Boolean homeFlag;
	private int ViewCount;
	private Date createdDate;
	private String createdBy;
	private Date updateDate;
	private String updateBy;
	private String metaKeyword;
	private String metaDescription;
	private Boolean unchecked;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryID",nullable=false)
	private ProductCategory productCategoryID;

	@OneToMany(fetch=FetchType.EAGER,mappedBy="productID")
	private List<OrderDetail> orderDetails;
	
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMoreImages() {
		return moreImages;
	}

	public void setMoreImages(String moreImages) {
		this.moreImages = moreImages;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(Double promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public Integer getWarranty() {
		return warranty;
	}

	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getHomeFlag() {
		return homeFlag;
	}

	public void setHomeFlag(Boolean homeFlag) {
		this.homeFlag = homeFlag;
	}

	public int getViewCount() {
		return ViewCount;
	}

	public void setViewCount(int viewCount) {
		ViewCount = viewCount;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getMetaKeyword() {
		return metaKeyword;
	}

	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public Boolean getUnchecked() {
		return unchecked;
	}

	public void setUnchecked(Boolean unchecked) {
		this.unchecked = unchecked;
	}

	public ProductCategory getProductCategoryID() {
		return productCategoryID;
	}

	public void setProductCategoryID(ProductCategory productCategoryID) {
		this.productCategoryID = productCategoryID;
	}

	
	
}
