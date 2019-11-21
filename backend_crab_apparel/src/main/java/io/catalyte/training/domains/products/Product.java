package io.catalyte.training.domains.products;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @NotNull(message = "Creation Date is required")
    private Date createDate;
    @NotNull
    @PositiveOrZero
    private Integer viewCount;
    @NotBlank(message = "Demographic is required")
    private String demographic;
    @NotBlank(message = "Category is required")
    private String category;
    @NotBlank(message = "Clothing Type is required")
    private String clothingType;
    private Boolean promotionFlag;
    @NotNull(message = "Price is required")
    @Positive
    private Double price;
    @NotBlank(message = "Product Name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Stock is required")
    @PositiveOrZero
    private Integer inStock;
    @NotNull(message = "Image Id is required")
    @Positive
    private Integer imgId;

    public Product() {
    }

    public Product(@NotNull(message = "Creation Date is required") Date createDate,
                   @NotNull @PositiveOrZero Integer viewCount,
                   @NotBlank(message = "Demographic is required") String demographic,
                   @NotBlank(message = "Category is required") String category,
                   @NotBlank(message = "Clothing Type is required") String clothingType,
                   Boolean promotionFlag,
                   @NotNull @Positive Double price,
                   @NotBlank(message = "Product Name is required") String name,
                   @NotBlank(message = "Description is required") String description,
                   @NotNull @PositiveOrZero Integer inStock,
                   @NotNull @Positive Integer imgId) {
        this.createDate = createDate;
        this.viewCount = viewCount;
        this.demographic = demographic;
        this.category = category;
        this.clothingType = clothingType;
        this.promotionFlag = promotionFlag;
        this.price = price;
        this.name = name;
        this.description = description;
        this.inStock = inStock;
        this.imgId = imgId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getDemographic() {
        return demographic;
    }

    public void setDemographic(String demographic) {
        this.demographic = demographic;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClothingType() {
        return clothingType;
    }

    public void setClothingType(String clothingType) {
        this.clothingType = clothingType;
    }

    public Boolean getPromotionFlag() {
        return promotionFlag;
    }

    public void setPromotionFlag(Boolean promotionFlag) {
        this.promotionFlag = promotionFlag;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", createDate=" + createDate +
                ", viewCount=" + viewCount +
                ", demographic='" + demographic + '\'' +
                ", category='" + category + '\'' +
                ", clothingType='" + clothingType + '\'' +
                ", promotionFlag=" + promotionFlag +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", inStock=" + inStock +
                ", imgId=" + imgId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) &&
                Objects.equals(createDate, product.createDate) &&
                Objects.equals(viewCount, product.viewCount) &&
                Objects.equals(demographic, product.demographic) &&
                Objects.equals(category, product.category) &&
                Objects.equals(clothingType, product.clothingType) &&
                Objects.equals(promotionFlag, product.promotionFlag) &&
                Objects.equals(price, product.price) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(inStock, product.inStock) &&
                Objects.equals(imgId, product.imgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, createDate, viewCount, demographic, category, clothingType, promotionFlag, price, name, description, inStock, imgId);
    }
}

