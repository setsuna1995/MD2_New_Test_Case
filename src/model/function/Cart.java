package model.function;

import model.user.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
    private static long serialUID = 123456789;
    private int id;
    public static int INDEX = 0;
    private List<CartDetail> cartDetails;
    private double total;

    private boolean status;

    public Cart() {
        this.cartDetails = new ArrayList<>();
        this.total = 0;
        this.status = false;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
