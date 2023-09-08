package service;


import model.Category;
import model.Product;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile implements Serializable {
    private static final long serialVersionUID = -4024148923274413365L;
    public void writeProductFile(Product product) {
        File file = new File("product");
        try (ObjectOutputStream obj = new ObjectOutputStream(Files.newOutputStream(file.toPath()))) {
            obj.writeObject(product);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
    public void writeCategoryFile(CategoryManager categoryManager) {
        File file = new File("category");
        try (ObjectOutputStream obj = new ObjectOutputStream(Files.newOutputStream(file.toPath()))) {
            obj.writeObject(categoryManager.getCategoryArrayList());
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
    public void readCategoryData (CategoryManager categoryManager){
        List<Category> categoriesFile = new ArrayList<>();
        File file = new File("C:\\Users\\vanan\\IdeaProjects\\NewTestCase\\category");
        try (ObjectInputStream obj = new ObjectInputStream(Files.newInputStream(file.toPath()))) {
            categoriesFile = (List<Category>) obj.readObject();
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        categoryManager.setCategoryArrayList(categoriesFile);
    }
//    public void readProductData (ProductManager productManager){
//        List<Product> productFile = new ArrayList<>();
//        File file = new File("C:\\Users\\vanan\\IdeaProjects\\NewTestCase\\product");
//        try (ObjectInputStream obj = new ObjectInputStream(Files.newInputStream(file.toPath()))) {
//            productFile = (List<Product>) obj.readObject();
//        } catch (IOException | ClassCastException | ClassNotFoundException e) {
//            e.printStackTrace(System.err);
//        }
//        productManager.setProductArrayList(productFile);
//    }
}
