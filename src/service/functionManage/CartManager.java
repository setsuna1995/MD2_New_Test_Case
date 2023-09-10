package service.functionManage;

import model.function.CartDetail;
import model.user.User;
import service.tools.ExceptionManager;
import model.function.Cart;
import model.function.Product;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CartManager {
    private final ProductManager productManager;
    private final Scanner scanner;
    private Cart cart;
    private List<Cart> bills;

    public CartManager(ProductManager productManager) {
        scanner = new Scanner(System.in);
        this.productManager = productManager;
        bills = new ArrayList<>();
    }

    public void changeIndex() {
        Cart.INDEX = bills.get(bills.size() - 1).getId();
    }

    public void addProductToCart() {
        productManager.display();
        System.out.println("Enter id you want to buy: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = productManager.findById(id);
        boolean check = false;

        if (product != null) {
            System.out.println("Enter quantity you want to buy: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            checkCartIsEmpty(product, quantity);
            checkProductExit(product, quantity, check);
        }
    }

    public void checkCartIsEmpty(Product product, int quantity) {
        if (cart == null) {
            cart = new Cart();
            CartDetail cartDetail = new CartDetail(product, quantity);
            cart.getCartDetails().add(cartDetail);
            cart.setTotal(product.getProductPrice() * quantity);
        }
    }

    public void checkProductExit(Product product, int quantity, boolean check) {
        for (CartDetail cartDetail : cart.getCartDetails()) {
            if (cartDetail.getProduct().getIdProduct() == product.getIdProduct()) {
                check = true;
                cartDetail.setQuantity(cartDetail.getQuantity() + quantity);
            }
        }
        if (!check) {
            CartDetail cartDetail = new CartDetail(product, quantity);
            cart.getCartDetails().add(cartDetail);
        }
        double money = 0;
        for (CartDetail cartDetail : cart.getCartDetails()) {
            money += cartDetail.getProduct().getProductPrice() * cartDetail.getQuantity();
        }
        cart.setTotal(money);
    }

    public CartDetail findCartById(int id) {
        for (CartDetail cartDetail : cart.getCartDetails()) {
            if (cartDetail.getId() == id) {
                return cartDetail;
            }
            return null;
        }
        return null;
    }

    public void editCart() {
        display();
        System.out.println("Enter card ID you want edit: ");
        int id = ExceptionManager.exceptionPositiveInteger();
        CartDetail cartDetail = findCartById(id);
        if (cartDetail == null) {
            System.out.println("Not found!");
        } else {
            System.out.println("Enter new quantity you want buy");
            int quantity = ExceptionManager.exceptionPositiveInteger();
            cartDetail.setQuantity(quantity);

        }
    }


    public void display() {
        if (cart != null) {
            for (CartDetail cartDetail : cart.getCartDetails()) {
                System.out.println(cartDetail);
            }
        } else {
            System.out.println("Not exist product in cart!!!");
        }
    }

    public void deleteItemsInCart() {
        display();
        System.out.println("Enter card ID you want delete: ");
        int id = ExceptionManager.exceptionPositiveInteger();
        CartDetail cartDetail = findCartById(id);
        if (cartDetail == null) {
            System.out.println("Not found!");
        } else {
            cart.getCartDetails().remove(cartDetail);
            System.out.println("Delete successfully!");
        }
    }

    public void payment() {
        if (cart != null) {
            cart.setStatus(true);
            bills.add(cart);
            write();
            cart = null;
        } else {
            System.out.println("Not exist cart!!!");
        }
    }

    public void displayBill() {
        read();
        for (Cart c : bills) {
            System.out.println(c.getId());
            for (CartDetail cartDetail : c.getCartDetails()) {
                System.out.println(cartDetail);
            }
            System.out.println("Tổng tiền: " + c.getTotal());
            System.out.println("---------------------------------------");
        }
    }

    private void read() {
        List<Cart> billsFile = new ArrayList<>();
        File file = new File("bill");
        try (ObjectInputStream obj = new ObjectInputStream(Files.newInputStream(file.toPath()))) {
            billsFile = (List<Cart>) obj.readObject();
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        bills = billsFile;
        changeIndex();
    }

    private void write() {
        File file = new File("bill");
        try (ObjectOutputStream obj = new ObjectOutputStream(Files.newOutputStream(file.toPath()))) {
            obj.writeObject(bills);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
