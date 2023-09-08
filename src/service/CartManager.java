package service;

import Tools.ExceptionManager;
import model.Cart;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class CartManager {
    private final List<Cart> cartArrayList;
    private ProductManager productManager;
    private Cart cart;
    private Scanner scanner;
    private List<Cart> bills;

    public CartManager(ProductManager productManager) {
        cartArrayList = new ArrayList<>();
        this.productManager = productManager;
    }


    public void addProductToCart() {
                System.out.println("Select the type of goods you need by ID:");
                productManager.display();
                int productID = ExceptionManager.exceptionPositiveInteger();
                Product product = productManager.findById(productID);
                if (product != null) {
                    int idCart = cartArrayList.size() + 1;
                    System.out.println("Fill in the number of items to be purchased: ");
                    int amount = ExceptionManager.exceptionQuantity();
                    checkCartBuy(idCart,product, amount);
                }
            }
public void checkCartBuy (int id,Product product, int quantity) {
    if (cart == null) {
        cart = new Cart(product, quantity);
    } else {
        boolean check = false;
        for (Cart c : cartArrayList) {
            if (cart.getProduct().getIdProduct() == product.getIdProduct()) {
                check = true;
                cart.setNumberOfProduct(cart.getNumberOfProduct() + quantity);
            }
        }
        if (!check) {
            cart = new Cart(product, quantity);
        }
        for (Cart c: cartArrayList) {
            cart.setMoney(cart.getProduct().getProductPrice() * cart.getNumberOfProduct());
        }
    }

}

    public Cart findCartById(int id) {
        for (Cart cart : cartArrayList) {
            if (cart.getCartID() == id) {
                return cart;
            }
        }
        return null;
    }

    public void editCart() {
        boolean input = true;
        do {
            try {
        displayCart();
        int id = ExceptionManager.exceptionPositiveInteger();
        Cart cart = findCartById(id);
        if (cart == null) {
            System.out.println("Not found!");
        } else {
            productManager.display();
            int productID = ExceptionManager.exceptionPositiveInteger();
            Product product = productManager.findById(productID);
            System.out.println("Fill in the number of items to be purchased: ");
            int amount = ExceptionManager.exceptionQuantity();
            cart.setProduct(product);
            cart.setNumberOfProduct(amount);
            System.out.println("Edit successfully!");
        }
    }catch (NumberFormatException e) {
                input = false;
                System.out.println("You entered the wrong data type");
                System.out.println("ID and quantity sections to fill in integers");
            }
        }
        while (!input);
    }

    public void displayCart() {
        for (Cart cart : cartArrayList) {
            System.out.println(cart);
        }
    }

    public void deleteItemsInCart() {
        displayCart();
        System.out.println("Enter card ID: ");
        int id = ExceptionManager.exceptionPositiveInteger();
        Cart cart = findCartById(id);
        if (cart == null) {
            System.out.println("Not found!");
        } else {
            cartArrayList.remove(cart);
            System.out.println("Delete successfully!");
        }
    }

    public void cartCheckout() {
        displayCart();
        System.out.println("Do you want to check out the cart");
        System.out.println("If you agree fill in Y, otherwise enter N");
        for (Cart c: cartArrayList
             ) {
            for (Product s : productManager.getProductArrayList()) {
                if (Objects.equals(c.getProduct().getProductName(), s.getProductName())) {
                    int max = s.getNumberOfProductAvailable() - c.getNumberOfProduct();
                    s.setNumberOfProductAvailable(max);
                }
            }

        }


    }
}
