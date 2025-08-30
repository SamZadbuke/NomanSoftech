package com.nomansoftech.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "productsubcategory")
public class ProductSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subcategoryId;

    @NotBlank
    @Size(max = 255)
    private String subcategoryName;

    private float price;

    private String subcategoryImagePath;
    
    private String category_description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;
  

    public ProductSubCategory() {
		super();
	}
	
	public ProductSubCategory(int subcategoryId, @NotBlank @Size(max = 255) String subcategoryName, float price,
			String subcategoryImagePath, String category_description, ProductCategory category) {
		super();
		this.subcategoryId = subcategoryId;
		this.subcategoryName = subcategoryName;
		this.price = price;
		this.subcategoryImagePath = subcategoryImagePath;
		this.category_description = category_description;
		this.category = category;
	}

	// Getters and setters
    public int getSubcategoryId() { return subcategoryId; }
    public void setSubcategoryId(int subcategoryId) { this.subcategoryId = subcategoryId; }
    public String getSubcategoryName() { return subcategoryName; }
    public void setSubcategoryName(String subcategoryName) { this.subcategoryName = subcategoryName; }
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
    public String getSubcategoryImagePath() { return subcategoryImagePath; }
    public void setSubcategoryImagePath(String subcategoryImagePath) { this.subcategoryImagePath = subcategoryImagePath; }
    public ProductCategory getCategory() { return category; }
    public void setCategory(ProductCategory category) { this.category = category; }

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	@Override
	public String toString() {
		return "ProductSubCategory [subcategoryId=" + subcategoryId + ", subcategoryName=" + subcategoryName
				+ ", price=" + price + ", subcategoryImagePath=" + subcategoryImagePath + ", category_description="
				+ category_description + ", category=" + category + ", getSubcategoryId()=" + getSubcategoryId()
				+ ", getSubcategoryName()=" + getSubcategoryName() + ", getPrice()=" + getPrice()
				+ ", getSubcategoryImagePath()=" + getSubcategoryImagePath() + ", getCategory()=" + getCategory()
				+ ", getCategory_description()=" + getCategory_description() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
    
    
    
}
