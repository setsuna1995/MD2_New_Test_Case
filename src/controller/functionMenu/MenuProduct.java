package controller.functionMenu;


import service.functionManage.ProductManager;
import service.tools.ExceptionManager;



public class MenuProduct {

    public void menuProduct (ProductManager productManager
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
            choice = ExceptionManager.exceptionChoice();
            switch (choice) {
                case 1:
                    productManager.addData();
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
}
