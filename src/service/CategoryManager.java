package service;

import Tools.Add;
import Tools.CRUD;
import Tools.ExceptionManager;
import model.Category;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CategoryManager implements CRUD {
    private List<Category> categoryArrayList;
    private final Scanner scanner;

    public CategoryManager() {
        categoryArrayList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public List<Category> getCategoryArrayList() {
        return categoryArrayList;
    }

    public void setCategoryArrayList(List<Category> categoryArrayList) {
        this.categoryArrayList = categoryArrayList;
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
}
