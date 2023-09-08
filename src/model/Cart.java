package model;

import java.io.Serializable;

public class Cart implements Serializable {
    private static long serialUID = -1793359086321202973L;
    private int cartID;
    private Product product;
    private int numberOfProduct;
private double money;
    public Cart() {
    }

    public Cart(Product product, int numberOfProduct) {
        this.product = product;
        this.numberOfProduct = numberOfProduct;
    }

    public Cart (int productID, Product product , int numberOfProduct) {
        this.cartID = productID;
        this.product = product;
        this.numberOfProduct = numberOfProduct;
    }

    public int getCartID() {
        return cartID;
    }



    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }



    public void setProduct(Product product) {
        this.product = product;
    }



    public Product getProduct() {
        return product;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID=" + cartID +
                ", product=" + product.getProductName() +
                ", numberOfProduct=" + numberOfProduct +
                ", money=" + money +
                '}';
    }
}
