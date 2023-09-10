package controller.userMenu;


import controller.functionMenu.MenuCategory;
import controller.functionMenu.MenuProduct;
import service.functionManage.CategoryManager;
import service.functionManage.ProductManager;
import service.tools.ExceptionManager;
import service.userManage.AdminManage;

import java.util.Scanner;

public class MenuAdmin {
    private final AdminManage adminManage;
    private final Scanner scanner;
    private final MenuProduct menuProduct;
    private final MenuCategory menuCategory;
    private final ProductManager productManager;
private final CategoryManager categoryManager;
    public MenuAdmin(ProductManager productManager, MenuCategory menuCategory, MenuProduct menuProduct, CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
        adminManage = new AdminManage();
        scanner = new Scanner(System.in);
        this.menuCategory = menuCategory;
        this.menuProduct = menuProduct;
        this.productManager = productManager;
    }

    public void menuAdmin() {
        int choice;
        do {
            System.out.println("Menu admin:");
            System.out.println("1. Log in");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = ExceptionManager.exceptionChoice();
            if (choice == 1) {
                adminManage.logIn();
                menuFunctionAdmin(categoryManager, productManager);
            }

        } while (choice != 0);
    }
    public void menuFunctionAdmin(CategoryManager categoryManager, ProductManager productManager) {
        int choice;
        do {
            System.out.println("MENU:");
            System.out.println("1. Menu Category");
            System.out.println("2. Menu Product");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuCategory.menuCategory(categoryManager);
                    break;
                case 2:
                    menuProduct.menuProduct(productManager);
                    break;
            }
        }while (choice != 0);
    }

    }

