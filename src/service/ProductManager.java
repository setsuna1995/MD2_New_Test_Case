package service;

import Interface.CRUD;
import model.Categories;
import model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static service.ReadAndWriteFile.importData;


public class ProductManager implements CRUD {
    private final ArrayList<Product> productArrayList;
    private final Scanner scanner;
    private final CategoriesManager categoriesManager;

    public ProductManager() {
        productArrayList = new ArrayList<>();
        scanner = new Scanner(System.in);
        categoriesManager = new CategoriesManager();
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void loadProduct() {
        categoriesManager.loadCategories();
        ArrayList<String[]> studentDataList = importData("src/Data/Product.csv");
        for (String[] strings : studentDataList) {
            int idCategory = Integer.parseInt(strings[0]);
            int id = Integer.parseInt(strings[1]);
            String name = strings[2];
            double price = Double.parseDouble(strings[3]);
            int amount = Integer.parseInt(strings[4]);
            Product productLoad = new Product(categoriesManager.findCategoryById(idCategory), id, name, price, amount);
            productArrayList.add(productLoad);
        }
    }

    @Override
    public void Add() {
        System.out.println("Select the category you want to add: ");
        categoriesManager.Display();
        System.out.println("Select your category's ID:");
        int categoriesID = Integer.parseInt(scanner.nextLine());
        Categories categories = categoriesManager.findCategoryById(categoriesID);
        int idProduct = productArrayList.size() + 1;
        System.out.println("Input product name: ");
        String name = scanner.nextLine();
        System.out.println("Input price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Input amount: ");
        int amount = Integer.parseInt(scanner.nextLine());
        Product product = new Product(categories, idProduct, name, price, amount);
        productArrayList.add(product);
        try {
            ReadAndWriteFile.writeProductFile("C:\\Users\\vanan\\IdeaProjects\\NewTestCase\\src\\Data\\Product.csv", productArrayList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Edit() {
        Display();
        System.out.println("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = findById(id);
        if (product == null) {
            System.out.println("Not found!");
        } else {
            System.out.println("Enter new product name: ");
            String name = scanner.nextLine();
            System.out.println("Input new price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Input new amount: ");
            int amount = Integer.parseInt(scanner.nextLine());
            product.setProductName(name);
            product.setProductPrice(price);
            product.setNumberOfProductAvailable(amount);
            System.out.println("Edit successfully!");
            try {
                ReadAndWriteFile.writeProductFile("C:\\Users\\vanan\\IdeaProjects\\NewTestCase\\src\\Data\\Product.csv", getProductArrayList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void Display() {
        for (Product product : productArrayList) {
            System.out.println(product);
        }
    }

    public Product findById(int id) {
        for (Product s : productArrayList) {
            if (s.getIdProduct() == id) {
                return s;
            }
        }
        return null;
    }

    public void findProduct() {
        ArrayList<Product> listFind = new ArrayList<>();
        System.out.println("Enter product name: ");
        String nameSearch = scanner.nextLine();
        for (Product s : productArrayList) {
            if (s.getProductName().contains(nameSearch)) {
                listFind.add(s);
            }
        }
        if (listFind.isEmpty()) {
            System.out.println("Not exists product have this name!");
        } else {
            for (Product product : listFind) {
                System.out.println(product);
            }
        }
    }

    public void displayProductCategory() {
        System.out.println("Choice category: ");
        categoriesManager.Display();
        System.out.println("Enter id category your choice: ");
        int idCategory = Integer.parseInt(scanner.nextLine());
        for (Product p : productArrayList
        ) {
            if (p.getCategories().getId() == idCategory) {
                System.out.println(p);
            }
        }
    }

    public void findPriceRange(Product product) {
        ArrayList<Product> listFind = new ArrayList<>();
        System.out.println("Enter the price range you want to find");
        System.out.println("From the price");
        double priceFrom = Double.parseDouble(scanner.nextLine());
        System.out.println("To price");
        double priceTo = Double.parseDouble(scanner.nextLine());
        for (double i = priceFrom; i <= priceTo; i++) {
            if (product.getProductPrice() == i) {
                listFind.add(product);
            }
        }
        if (listFind.isEmpty()) {
            System.out.println("Not exists product have this name!");
        } else {
            for (Product p : listFind) {
                System.out.println(p);
            }
        }
    }

    public void deleteProduct() {
        System.out.println("Enter product ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = findById(id);
        if (product == null) {
            System.out.println("Not found!");
        } else {
            productArrayList.remove(product);
            System.out.println("Delete successfully!");
            try {
                ReadAndWriteFile.writeProductFile("C:\\Users\\vanan\\IdeaProjects\\NewTestCase\\src\\Data\\Product.csv", productArrayList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void sortByAscendingPrice() {
        productArrayList.sort(Comparator.comparingDouble(Product::getProductPrice));
    }

    public void sortByDescendingPrice() {
        productArrayList.sort(Comparator.comparingDouble(Product::getProductPrice).reversed());
    }

}
