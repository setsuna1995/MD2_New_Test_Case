package controller;


import controller.functionMenu.MenuCategory;
import controller.functionMenu.MenuProduct;
import controller.userMenu.MenuAdmin;
import controller.userMenu.MenuCustomer;
import model.function.Cart;
import model.function.CartDetail;
import model.function.Product;
import service.functionManage.CartManager;
import service.functionManage.CategoryManager;
import service.functionManage.IOManager;
import service.functionManage.ProductManager;
import service.tools.ExceptionManager;
import service.userManage.UserManage;


public class Menu {
    private final CategoryManager categoryManager;
    private final ProductManager productManager;
    private final IOManager ioManager;
    private final MenuCustomer menuCustomer;
    private final MenuAdmin menuAdmin;

    public Menu() {
        categoryManager = new CategoryManager();
        ioManager = new IOManager();
        UserManage userManage = new UserManage();
        Product product = new Product();
        MenuCategory menuCategory = new MenuCategory();
        MenuProduct menuProduct = new MenuProduct();
        Cart cart = new Cart();
        CartDetail cartDetail = new CartDetail();
        productManager = new ProductManager(categoryManager);
        CartManager cartManager = new CartManager(productManager, userManage);
        menuCustomer = new MenuCustomer(userManage, cartManager, cart, product, cartDetail);
        menuAdmin = new MenuAdmin(productManager, menuCategory, menuProduct, categoryManager);
        categoryManager.loadCategories(ioManager.importData("category.txt"));
        productManager.loadProduct(ioManager.importData("product.txt"));
    }
    public void menu() {

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

