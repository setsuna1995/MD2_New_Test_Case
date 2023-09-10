package controller.functionMenu;

import model.function.Cart;
import service.functionManage.CartManager;
import service.functionManage.IOManager;
import service.tools.ExceptionManager;


public class MenuCart {
    public void menuCart (CartManager cartManager, IOManager ioManager, Cart cart) {
        int choice;
        do {

            System.out.println("Menu Cart:");
            System.out.println("1. Add product to cart");
            System.out.println("2. Change the quantity of goods in the cart");
            System.out.println("3. Remove products from cart");
            System.out.println("4. Show products in the cart");
            System.out.println("5. Cart checkout");
            System.out.println("6. Show bills");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = ExceptionManager.exceptionChoice();
            switch (choice) {
                case 1:
                    cartManager.addProductToCart();
                    ioManager.writeCart(cart);
                    break;
                case 2:
                    cartManager.editCart();
                    ioManager.writeCart(cart);
                    break;
                case 3:
                    cartManager.deleteItemsInCart();
                    ioManager.writeCart(cart);
                    break;
                case 4:
                    cartManager.display();
                    break;
                case 5:
                    cartManager.payment();
                    ioManager.writeCart(cart);
                    break;
                case 6:
                    cartManager.displayBill();
                    break;
            }
        } while (choice != 0);
    }
}
