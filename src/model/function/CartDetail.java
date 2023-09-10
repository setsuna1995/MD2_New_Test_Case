package model.function;


import model.user.User;

import java.io.Serializable;

public class CartDetail implements Serializable {
    private static long serialUID = 123456789;
private int INDEX;
    private int id;
    private Product product;
    private int quantity;

    public CartDetail(Product product, int quantity) {
        this.id = ++INDEX;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartDetail{" +
                product +
                ", quantity=" + quantity +
                '}';
    }
}
