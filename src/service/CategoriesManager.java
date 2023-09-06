package service;

import Interface.CRUD;
import model.Categories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static service.ReadAndWriteFile.writeCategoryFile;


public class CategoriesManager implements CRUD {
    private final ArrayList<Categories> categoriesArrayList;
    private final Scanner scanner;

    public CategoriesManager() {
        categoriesArrayList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void loadCategories() {
        ArrayList<String[]> categoriesDataList = ReadAndWriteFile.importData("src/Data/Catagories.csv");
        for (String[] strings : categoriesDataList) {
            int id = Integer.parseInt(strings[0]);
            System.out.println(id);
            String name = strings[1];
            Categories categories = new Categories(id, name);
            categoriesArrayList.add(categories);
        }
    }
    @Override
    public void Add() {
        int id = categoriesArrayList.size() + 1;
        System.out.println("Input categories name: ");
        String categoriesName = scanner.nextLine();
        Categories categories = new Categories(id, categoriesName);
        categoriesArrayList.add(categories);
        try {
            writeCategoryFile("C:\\Users\\vanan\\IdeaProjects\\NewTestCase\\src\\Data\\Catagories.csv", categoriesArrayList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Edit() {
        System.out.println("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Categories categories = findCategoryById(id);
        if (categories == null) {
            System.out.println("Not found!");
        } else {
            System.out.println("Enter new name: ");
            String name = scanner.nextLine();
            categories.setCategoriesName(name);
            System.out.println("Edit successfully!");
            try {
                writeCategoryFile("C:\\Users\\vanan\\IdeaProjects\\NewTestCase\\src\\Data\\Catagories.csv", categoriesArrayList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void Display() {
        for (Categories categories : categoriesArrayList) {
            System.out.println(categories);
        }
    }


   public Categories findCategoryById(int id) {
        for (Categories s : categoriesArrayList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
