package controller;


import controller.functionMenu.MenuCategory;
import controller.functionMenu.MenuProduct;
import controller.userMenu.MenuAdmin;
import controller.userMenu.MenuCustomer;
import model.function.Cart;
import model.user.User;
import service.functionManage.CartManager;
import service.functionManage.CategoryManager;
import service.functionManage.IOManager;
import service.functionManage.ProductManager;
import service.tools.ExceptionManager;
import service.userManage.UserManage;


public class Menu {
    public void menu() {
        CategoryManager categoryManager = new CategoryManager();
        ProductManager productManager = new ProductManager(categoryManager);
        IOManager ioManager = new IOManager();
        UserManage userManage = new UserManage();
        CartManager cartManager = new CartManager(productManager);
        MenuCategory menuCategory = new MenuCategory();
        MenuProduct menuProduct = new MenuProduct();
        Cart cart = new Cart();
        MenuCustomer menuCustomer = new MenuCustomer(userManage, cartManager, cart);
        MenuAdmin menuAdmin = new MenuAdmin(productManager, menuCategory, menuProduct, categoryManager);
        categoryManager.loadCategories(ioManager.importData("category.txt"));
        productManager.loadProduct(ioManager.importData("product.txt"));
        do {
            System.out.println("MENU:");
            System.out.println("1. Menu Admin");
            System.out.println("2. Menu Customer");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = ExceptionManager.exceptionChoice();
            switch (choice) {
                case 1:
                    menuAdmin.menuAdmin();
                    break;
                case 2:
                    menuCustomer.menuCustomer();
                    break;
                case 0:
                    ioManager.exportData(productManager.getProductArrayList(), categoryManager.getCategoryArrayList());
                    System.exit(0);
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (true);

    }

}

