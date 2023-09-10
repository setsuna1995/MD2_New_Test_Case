package controller.userMenu;


import controller.functionMenu.MenuCart;
import model.function.Cart;
import model.function.CartDetail;
import model.function.Product;
import service.functionManage.CartManager;

import service.functionManage.IOManager;
import service.tools.ExceptionManager;
import service.userManage.UserManage;


public class MenuCustomer {
    private final UserManage userManage;
    private final CartManager cartManager;
    private final IOManager ioManager;
    private final Cart cart;
private final Product product;
private final MenuCart menuCart;
private final CartDetail cartDetail;
    public MenuCustomer(UserManage userManage, CartManager cartManager, Cart cart, Product product, CartDetail cartDetail) {
        this.userManage = userManage;
        this.cartDetail = cartDetail;
        this.cart = cart;
        menuCart = new MenuCart();
        this.cartManager = cartManager;
        ioManager = new IOManager();
        this.product = product;
    }

    public void menuCustomer() {
        int choice;
        do {
            System.out.println("Menu Customer:");
            System.out.println("1. Log in");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = ExceptionManager.exceptionChoice();
            switch (choice) {
                case 1:
                        userManage.logIn();
                    menuCart.menuCart(cartManager, ioManager, cart, product);
                    break;
                case 2:
                    userManage.creatUser();
                    break;
            }

        } while (choice != 0);
    }
}
