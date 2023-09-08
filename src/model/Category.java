package model;

import java.io.Serializable;

public class Category implements Serializable {
    private static long serialUID = -1793359086321202973L;
    private int id;
    private String categoriesName;

    public Category() {
    }

    public Category(int id, String categoriesName) {
        this.id = id;
        this.categoriesName = categoriesName;
    }

    public int getId() {
        return id;
    }


    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoriesName='" + categoriesName + '\'' +
                '}';
    }
}
