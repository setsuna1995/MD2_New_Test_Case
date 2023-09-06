package controller;


import model.Cart;
import model.Product;
import service.CartManager;
import service.CategoriesManager;
import service.ProductManager;


import java.util.Scanner;

public class Menu {
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();
        CategoriesManager categoriesManager = new CategoriesManager();
        ProductManager productManager = new ProductManager();
        CartManager cartManager = new CartManager();
        categoriesManager.loadCategories();
      productManager.loadProduct();
        do {
            System.out.println("MENU:");
            System.out.println("1. Menu Categories");
            System.out.println("2. Menu Product");
            System.out.println("3. Menu Buy");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuCategory(categoriesManager, scanner);
                    break;
                case 2:
                    menuProduct(productManager, categoriesManager ,scanner);
                    break;
                case 3:
                    menuCart(cartManager, productManager,product, scanner);
                    break;
                case 0:
                    System.exit(0);

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (true);

    }

    private void menuCategory(CategoriesManager categoriesManager, Scanner scanner) {
        int choice;
        do {
            System.out.println("Menu Categories:");
            System.out.println("1. Create categories");
            System.out.println("2. Edit categories");
            System.out.println("3. Display categories");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    categoriesManager.Add();
                    break;
                case 2:
                    categoriesManager.Edit();
                    break;
                case 3:
                    categoriesManager.Display();
                    break;
            }

        } while (choice != 0);
    }

    private void menuProduct(ProductManager productManager,
                             CategoriesManager categoriesManager, Scanner scanner
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
                    productManager.Add();
                    break;
                case 2:
                    productManager.deleteProduct();
                    break;
                case 3:
                    productManager.Edit();
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
                    productManager.findPriceRange(new Product());
                    break;
                case 8:
                    productManager.displayProductCategory();
                    break;
                case 9:
                    productManager.Display();
                    break;
            }

        } while (choice != 0);
    }

    private void menuCart(CartManager cartManager,  ProductManager productManager,Product product ,Scanner scanner) {
        int choice;
        do {
            System.out.println("Menu Categories:");
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
                   cartManager.addProductToCart(productManager);
                    break;
                case 2:
                    cartManager.editCart(productManager);
                    break;
                case 3:
                    cartManager.deleteItemsInCart(productManager);
                    break;
                case 4:
                    cartManager.displayCart();
                    break;
                case 5:
                    cartManager.cartCheckout(productManager);
                    break;
            }

        } while (choice != 0);
    }
}

