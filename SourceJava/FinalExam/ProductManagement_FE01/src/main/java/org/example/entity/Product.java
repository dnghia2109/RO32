package org.example.entity;

public class Product {
    private int productId, ratingStar;
    private String productName, productPrice, productInfo, productDetail, productImageName;

    private Category category;
    private Manufacturer manufacturer;

    public Product() {
        super();
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getRatingStar() {
        return ratingStar;
    }

    public void setRatingStar(int ratingStar) {
        this.ratingStar = ratingStar;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public String getProductImageName() {
        return productImageName;
    }

    public void setProductImageName(String productImageName) {
        this.productImageName = productImageName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", ratingStar=" + ratingStar +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productInfo='" + productInfo + '\'' +
                ", productDetail='" + productDetail + '\'' +
                ", productImageName='" + productImageName + '\'' +
                ", category=" + category.getCategoryName() +
                ", manufacturer=" + manufacturer.getManufacturerName() +
                '}';
    }
}
