package service;

import model.Cart;
import model.Product;

import java.util.ArrayList;
import java.util.Scanner;


public class CartManager {
    private final ArrayList<Cart> cartArrayList;
    private final ProductManager productManager;
    private final Scanner scanner;
    private final Product product;
    private final Cart cart;

    public CartManager() {
        cartArrayList = new ArrayList<>();
        scanner = new Scanner(System.in);
        product = new Product();
        cart = new Cart();
        productManager = new ProductManager();
    }


    public void addProductToCart(ProductManager productManager) {
        System.out.println("Select the type of goods you need by ID:");
        productManager.Display();
        int productID = Integer.parseInt(scanner.nextLine());
        Product product = productManager.findById(productID);
        int idCart = cartArrayList.size() + 1;
        System.out.println("Fill in the number of items to be purchased: ");
        int amount = Integer.parseInt(scanner.nextLine());
        Cart cart = new Cart(idCart, product, amount);
        cartArrayList.add(cart);

    }

    public Cart findCartById(int id) {
        for (Cart cart : cartArrayList) {
            if (cart.getCartID() == id) {
                return cart;
            }
        }
        return null;
    }

    public void editCart(ProductManager productManager) {
        displayCart();
        System.out.println("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Cart cart = findCartById(id);
        if (cart == null) {
            System.out.println("Not found!");
        } else {
            productManager.Display();
            int productID = Integer.parseInt(scanner.nextLine());
            Product product = productManager.findById(productID);
            System.out.println("Fill in the number of items to be purchased: ");
            int amount = Integer.parseInt(scanner.nextLine());
            cart.setProduct(product);
            cart.setNumberOfProduct(amount);
            System.out.println("Edit successfully!");
        }
    }

    public void displayCart() {
        for (Cart cart : cartArrayList) {
            System.out.println(cart);
        }
    }

    public void deleteItemsInCart(ProductManager productManager) {
        displayCart();
        System.out.println("Enter card ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Cart cart = findCartById(id);
        if (cart == null) {
            System.out.println("Not found!");
        } else {
            cartArrayList.remove(cart);
            System.out.println("Delete successfully!");
        }
    }

    public void cartCheckout(ProductManager productManager) {
        displayCart();
        productManager.loadProduct();
        System.out.println("Do you want to check out the cart");
        System.out.println("If you agree fill in Y, otherwise enter N");
        for (Cart c: cartArrayList
             ) {
            System.out.println(c);
            productManager.loadProduct();
            for (Product s : productManager.getProductArrayList()) {
                if (c.getProduct().getIdProduct() == s.getIdProduct()) {
                    int max = s.getNumberOfProductAvailable() - c.getNumberOfProduct();
                    s.setNumberOfProductAvailable(max);
                    System.out.println(s);
                }
            }
        }



    }
}
