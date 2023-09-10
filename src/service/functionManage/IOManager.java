package service.functionManage;

import model.function.Cart;
import model.function.Category;
import model.function.Product;

import java.io.*;
import java.util.ArrayList;

public class IOManager implements Serializable{
    public void exportData(ArrayList<Product> productList, ArrayList<Category> categoryList) {
        try {
            File fileOutClasses = new File("category.txt");
            BufferedWriter brCategories = new BufferedWriter(new FileWriter(fileOutClasses));
            for (Category c : categoryList) {
                brCategories.write(c.getId() + "," + c.getCategoriesName() + "\n");
            }
            brCategories.close();
            File fileOutProduct = new File("product.txt");
            BufferedWriter brProducts = new BufferedWriter(new FileWriter(fileOutProduct));
            for (Product p : productList) {
                brProducts.write(p.getCategories().getCategoriesName() + ","
                        + p.getIdProduct() + ","
                        + p.getProductName() + ","
                        + p.getProductPrice() + ","
                        + p.getNumberOfProductAvailable() + "\n");
            }
            brProducts.close();
        } catch (IOException | NullPointerException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
    }
    public ArrayList<String[]> importData(String linkFile) {
        ArrayList<String[]> listData = new ArrayList<>();
        try {
            File file = new File(linkFile);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listData.add(line.split(","));
            }
        } catch (IOException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
        return listData;
    }
    public void writeCart (Cart cart) {
        File file = new File("cart");
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(file))) {
            obj.writeObject(cart);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
    public Cart readCart () {
        Cart cartFile = null;
        File file = new File("cart");
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(file))) {
            cartFile = (Cart) obj.readObject();
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return cartFile;
    }
}