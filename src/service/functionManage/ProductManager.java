package service.functionManage;


import service.tools.CRUD;
import service.tools.ExceptionManager;
import model.function.Category;
import model.function.Product;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;



public class ProductManager implements CRUD {
    private final ArrayList<Product> productArrayList;
    private final Scanner scanner;
private final CategoryManager categoryManager;

    public ProductManager(CategoryManager categoryManager) {
        productArrayList = new ArrayList<>();
        this.categoryManager = categoryManager;
        scanner = new Scanner(System.in);
    }
    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void loadProduct(ArrayList<String[]> arrayList) {
        for (String[] strings : arrayList) {
            String nameCategory = strings[0];
            int id = Integer.parseInt(strings[1]);
            String name = strings[2];
            double price = Double.parseDouble(strings[3]);
            int quantity = Integer.parseInt(strings[4]);
            Category category = categoryManager.findCategoryByName(nameCategory);
            Product product = new Product(category, id, name, price, quantity);
            productArrayList.add(product);
        }
    }
    @Override
    public void addData() {
        int countFail = 0;
        boolean check = false;
        do {
            if (categoryManager.getCategoryArrayList().isEmpty()) {
                System.out.println("You need creat new category");
                categoryManager.addData();
            }
            System.out.println("Select the category you want to add: ");
            categoryManager.display();
            int categoriesID = ExceptionManager.exceptionPositiveInteger();
            for (Category c1 : categoryManager.getCategoryArrayList()
            ) {
                if (categoriesID == c1.getId()) {
                    Category category = categoryManager.findCategoryById(categoriesID);
                    int idProduct = productArrayList.size() + 1;
                    System.out.println("Input product name: ");
                    String name = scanner.nextLine();
                    double price = ExceptionManager.exceptionPrice();
                    int amount = ExceptionManager.exceptionQuantity();
                    Product product = new Product(category, idProduct, name, price, amount);
                    productArrayList.add(product);
                    System.out.println("Add successful");
                    check = true;
                } else {
                    check = false;
                }
            }
            if (!check) {
                System.out.println("Id not found, re-enter!!!");
                countFail++;
            }
            if (countFail == 3) {
                check = true;
                System.out.println("If you have entered it incorrectly more than three times, please select again");
            }
        }
        while (!check);
    }
    @Override
    public void edit() {
        display();
        System.out.println("Enter ID: ");
        int id = ExceptionManager.exceptionPositiveInteger();
        Product product = findById(id);
        if (product == null) {
            System.out.println("Not found!");
        } else {
            System.out.println("Enter new product name: ");
            String name = scanner.nextLine();
            double price = ExceptionManager.exceptionPrice();
            int amount = ExceptionManager.exceptionQuantity();
            product.setProductName(name);
            product.setProductPrice(price);
            product.setNumberOfProductAvailable(amount);
            System.out.println("Edit successfully!");
        }
    }

    @Override
    public void display() {
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

    @Override
    public String toString() {
        return "ProductManager{" +
                 productArrayList +
                '}';
    }

    public void displayProductCategory() {
        System.out.println("Choice category: ");
        categoryManager.display();
        System.out.println("Enter id category your choice: ");
        int idCategory = ExceptionManager.exceptionPositiveInteger();
        for (Product p : productArrayList
        ) {
            if (p.getCategories().getId() == idCategory) {
                System.out.println(p);
            }
        }
    }

    public void findPriceRange() {
        ArrayList<Product> listFind = new ArrayList<>();
        System.out.println("Enter the price range you want to find");
        System.out.println("From the price");
        double priceFrom = ExceptionManager.exceptionPrice();
        System.out.println("To price");
        double priceTo = ExceptionManager.exceptionPrice();
        for (double i = priceFrom; i <= priceTo; i++) {
            for (Product p: productArrayList
                 ) {
                if (p.getProductPrice() == i) {
                    listFind.add(p);
                }
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
        int id = ExceptionManager.exceptionPositiveInteger();
        Product product = findById(id);
        if (product == null) {
            System.out.println("Not found!");
        } else {
            productArrayList.remove(product);
            System.out.println("Delete successfully!");
        }
    }

    public void sortByAscendingPrice() {
        productArrayList.sort(Comparator.comparingDouble(Product::getProductPrice));
    }

    public void sortByDescendingPrice() {
        productArrayList.sort(Comparator.comparingDouble(Product::getProductPrice).reversed());
    }

}
