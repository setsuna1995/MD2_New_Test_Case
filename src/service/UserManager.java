//package service;
//
//import Tools.ExceptionManager;
//import model.Cart;
//import model.Product;
//import model.User;
//
//import java.util.ArrayList;
//
//public class UserManager {
//    private ArrayList<User> userArrayList;
//    public void creatUser() {
//        System.out.println("Select the type of goods you need by ID:");
//        productManager.display();
//        int productID = ExceptionManager.exceptionPositiveInteger();
//        Product product = productManager.findById(productID);
//        int idCart = userArrayList.size() + 1;
//        System.out.println("Fill in the number of items to be purchased: ");
//        int amount = ExceptionManager.exceptionQuantity();
//        User user = new Cart(idCart, product, amount);
//        userArrayList.add(cart);
//    }
//}
