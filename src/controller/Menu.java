package controller;


import model.Product;
import service.CartManager;
import service.CategoryManager;
import service.ProductManager;
import service.ReadAndWriteFile;


import java.io.Serializable;
import java.util.Scanner;

public class Menu implements Serializable {
    private static long serialUID = -1793359086321202973L;
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        CategoryManager categoryManager = new CategoryManager();
        ProductManager productManager = new ProductManager(categoryManager);
        CartManager cartManager = new CartManager(productManager);
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        readAndWriteFile.readCategoryData(categoryManager);
        readAndWriteFile.readProductData(productManager);
        do {
            System.out.println("MENU:");
            System.out.println("1. Menu Category");
            System.out.println("2. Menu Product");
            System.out.println("3. Menu Buy");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuCategory(categoryManager,readAndWriteFile ,scanner);
                    break;
                case 2:
                    menuProduct(productManager, new Product(),readAndWriteFile,scanner);
                    break;
                case 3:
                    menuCart(cartManager, scanner);
                    break;
                case 0:
                    System.exit(0);

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (true);

    }

    private void menuCategory(CategoryManager categoryManager,ReadAndWriteFile readAndWriteFile ,Scanner scanner) {
        int choice;
        do {
            System.out.println("Menu Category:");
            System.out.println("1. Create categories");
            System.out.println("2. Edit categories");
            System.out.println("3. Display categories");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    categoryManager.addData();
                    readAndWriteFile.writeCategoryFile(categoryManager);
                    break;
                case 2:
                    categoryManager.edit();
                    readAndWriteFile.writeCategoryFile(categoryManager);
                    break;
                case 3:
                    categoryManager.display();
                    break;
            }

        } while (choice != 0);
    }

    private void menuProduct(ProductManager productManager, Product product, ReadAndWriteFile readAndWriteFile
                             ,Scanner scanner
    ) {
        int choice;
        do {
            System.out.println("Menu Product");
            System.out.println("1. Add Product: ");
            System.out.println("2. Delete Product: ");
            System.out.println("3. Edit Product: ");
            System.out.println("4. Find Product by name: ");
            System.out.println("5. Sort by ascending price: ");
            System.out.println("6. Sort by descending price: ");
            System.out.println("7. Find products by price range: ");
            System.out.println("8. Show products by category: ");
            System.out.println("9. Display: ");
            System.out.println("0. Back to menu: ");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManager.addData();
                    readAndWriteFile.writeProductFile(product);
                    break;
                case 2:
                    productManager.deleteProduct();
                    break;
                case 3:
                    productManager.edit();
                    break;
                case 4:
                    productManager.findProduct();
                    break;
                case 5:
                    productManager.sortByAscendingPrice();
                    break;
                case 6:
                    productManager.sortByDescendingPrice();
                    break;
                case 7:
                    productManager.findPriceRange();
                    break;
                case 8:
                    productManager.displayProductCategory();
                    break;
                case 9:
                    productManager.display();
                    break;
            }

        } while (choice != 0);
    }

    private void menuCart(CartManager cartManager, Scanner scanner) {
        int choice;
        do {
            System.out.println("Menu Category:");
            System.out.println("1. Add product to cart");
            System.out.println("2. Change the quantity of goods in the cart");
            System.out.println("3. Remove products from cart");
            System.out.println("4. Show products in the cart");
            System.out.println("5. Cart checkout");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    cartManager.addProductToCart();
                    break;
                case 2:
                    cartManager.editCart();
                    break;
                case 3:
                    cartManager.deleteItemsInCart();
                    break;
                case 4:
                    cartManager.displayCart();
                    break;
                case 5:
                    cartManager.cartCheckout();
                    break;
            }

        } while (choice != 0);
    }
}

