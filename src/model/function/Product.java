package model.function;

import java.io.Serializable;

public class Product implements Serializable {
    private static long serialUID = 123456789;
    private int idProduct;
    private String productName;
    private Category category;
    private double productPrice;

    private int numberOfProductAvailable;

    public Product() {
    }

    public Product(Category category, int idProduct, String productName, double productPrice, int numberOfProductAvailable) {

        this.category = category;
        this.idProduct = idProduct;
        this.productName = productName;
        this.productPrice = productPrice;
        this.numberOfProductAvailable = numberOfProductAvailable;

    }

    public int getNumberOfProductAvailable() {
        return numberOfProductAvailable;
    }

    public void setNumberOfProductAvailable(int numberOfProductAvailable) {
        this.numberOfProductAvailable = numberOfProductAvailable;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Category getCategories() {
        return category;
    }


    public int getIdProduct() {
        return idProduct;
    }


    @Override
    public String toString() {
        return "Product{" +
                "idProduct = " + idProduct +
                ", productName = '" + productName + '\'' +
                ", category = " + category.getCategoriesName() +
                ", productPrice=" + productPrice +
                ", numberOfProductAvailable = " + numberOfProductAvailable +
                '}' + '\n';
    }
}
