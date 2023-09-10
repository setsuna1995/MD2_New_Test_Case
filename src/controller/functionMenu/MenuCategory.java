package controller.functionMenu;


import service.functionManage.CategoryManager;
import service.tools.ExceptionManager;

public class MenuCategory {

    public void menuCategory(CategoryManager categoryManager) {
        int choice;
        do {
            System.out.println("Menu Category:");
            System.out.println("1. Create categories");
            System.out.println("2. Edit categories");
            System.out.println("3. Display categories");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = ExceptionManager.exceptionChoice();
            switch (choice) {
                case 1:
                    categoryManager.addData();
                    break;
                case 2:
                    categoryManager.edit();
                    break;
                case 3:
                    categoryManager.display();
                    break;

            }
        } while (choice != 0);
    }

}
