package model;

public class Categories {
    private final int id;
    private String categoriesName;

    public Categories(int id, String categoriesName) {
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
        return "Categories{" +
                "id=" + id +
                ", categoriesName='" + categoriesName + '\'' +
                '}';
    }
}
