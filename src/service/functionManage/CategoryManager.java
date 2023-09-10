package service.functionManage;


import service.tools.CRUD;
import service.tools.ExceptionManager;
import model.function.Category;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;



public class CategoryManager implements CRUD {
    private final ArrayList<Category> categoryArrayList;
    private final Scanner scanner;
    public CategoryManager() {
        categoryArrayList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public ArrayList<Category> getCategoryArrayList() {
        return categoryArrayList;
    }

    public void loadCategories(ArrayList<String[]> arrayList) {
        for (String[] strings : arrayList) {
            int id = Integer.parseInt(strings[0]);
            String name = strings[1];
            Category newCategory = new Category(id, name);
            categoryArrayList.add(newCategory);
        }
    }
    @Override
    public void addData() {
        int id = categoryArrayList.size() + 1;
        System.out.println("Input category name: ");
        String categoriesName = scanner.nextLine();
        Category category = new Category(id, categoriesName);
        categoryArrayList.add(category);
    }

    @Override
    public void edit() {
        int id = ExceptionManager.exceptionPositiveInteger();
        Category category = findCategoryById(id);
        if (category == null) {
            System.out.println("Not found!");
        } else {
            System.out.println("Enter new name: ");
            String name = scanner.nextLine();
            category.setCategoriesName(name);
            System.out.println("Edit successfully!");
        }
    }

    @Override
    public void display() {
        for (Category category : categoryArrayList) {
            System.out.println(category);
        }
    }

    public Category findCategoryById(int id) {
        for (Category s : categoryArrayList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
    public Category findCategoryByName(String name) {
        for (Category s : categoryArrayList) {
            if (Objects.equals(s.getCategoriesName(), name)) {
                return s;
            }
        }
        return null;
    }
}
