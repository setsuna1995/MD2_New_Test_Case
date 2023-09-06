package service;



import model.Categories;
import model.Product;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteFile {
    public static ArrayList<String[]> importData(String link) {
        ArrayList<String[]> result = new ArrayList<>();
        File file = new File(link);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line.split(","));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void writeProductFile(String filePath, ArrayList<Product> productArrayList) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (Product item : productArrayList
        ) {
            bufferedWriter.write(
                    item.getCategories().getId() + "," +
                            item.getIdProduct() + "," +
                            item.getProductName() + "," +
                            item.getProductPrice() + "," +
                            item.getNumberOfProductAvailable());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
    public static void writeCategoryFile(String filePath, ArrayList<Categories> categoriesArrayList) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (Categories item : categoriesArrayList
        ) {
            bufferedWriter.write(
                    item.getId() + "," +
                            item.getCategoriesName());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
