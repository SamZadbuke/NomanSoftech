package com.nomansoftech.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String categoryName;

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String categoryDescription;

    @Size(max = 255)
    private String categoryImageName;

    private Timestamp registeredAt;
    private Timestamp lastModifiedAt;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<ProductSubCategory> subCategories;

    public ProductCategory() {}

    
    public ProductCategory(int categoryId, @NotBlank @Size(max = 255) String categoryName,
			@NotBlank @Size(max = 255) String categoryDescription, @Size(max = 255) String categoryImageName,
			Timestamp registeredAt, Timestamp lastModifiedAt, List<ProductSubCategory> subCategories) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryImageName = categoryImageName;
		this.registeredAt = registeredAt;
		this.lastModifiedAt = lastModifiedAt;
		this.subCategories = subCategories;
	}


	// Getters and setters
    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getCategoryDescription() { return categoryDescription; }
    public void setCategoryDescription(String categoryDescription) { this.categoryDescription = categoryDescription; }
    public String getCategoryImageName() { return categoryImageName; }
    public void setCategoryImageName(String categoryImageName) { this.categoryImageName = categoryImageName; }
    public Timestamp getRegisteredAt() { return registeredAt; }
    public void setRegisteredAt(Timestamp registeredAt) { this.registeredAt = registeredAt; }
    public Timestamp getLastModifiedAt() { return lastModifiedAt; }
    public void setLastModifiedAt(Timestamp lastModifiedAt) { this.lastModifiedAt = lastModifiedAt; }
    public List<ProductSubCategory> getSubCategories() { return subCategories; }
    public void setSubCategories(List<ProductSubCategory> subCategories) { this.subCategories = subCategories; }
}
