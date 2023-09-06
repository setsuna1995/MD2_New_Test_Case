package model;

public class Cart {
    private int cartID;
    private Product product;
    private int numberOfProduct;

    public Cart() {
    }

    public Cart(int productID, Product product ,int numberOfProduct) {
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

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID =" + cartID +
                ", product name =" + product.getProductName() +
                ", numberOfProduct =" + numberOfProduct +
                ", total price = " + product.getProductPrice()*numberOfProduct +
                '}';
    }
}
