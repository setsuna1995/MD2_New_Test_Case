package model;

public class Product {
    private int idProduct;
    private String productName;
    private Categories categories;
    private double productPrice;

private int numberOfProductAvailable;

    public Product() {
    }

    public Product(Categories categories, int idProduct, String productName, double productPrice, int numberOfProductAvailable) {

        this.categories = categories;
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

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct = " + idProduct +
                ", productName = '" + productName + '\'' +
                ", category = " + categories.getCategoriesName() +
                ", productPrice=" + productPrice +
                ", numberOfProductAvailable = " + numberOfProductAvailable +
                '}';
    }
}
