package service.userManage;



import model.function.CartDetail;
import model.user.User;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManage implements Serializable {
    private final Scanner scanner;
    private List<User> userArrayList;
private List<String> logInList;
private CartDetail cartDetail;

    public List<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(List<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public List<String> getLogInList() {
        return logInList;
    }

    public void setLogInList(List<String> logInList) {
        this.logInList = logInList;
    }

    public UserManage(CartDetail cartDetail) {
        scanner = new Scanner(System.in);
        userArrayList = new ArrayList<>();
        logInList = new ArrayList<String>();
       this.cartDetail = cartDetail;
    }

    public void creatUser() {
        read();
        boolean check = false;
        boolean checkExit = false;
        int countFail = 0;
        do {
            System.out.println("Enter you user name: ");
            String name = scanner.nextLine();
            for (User u : userArrayList
            ) {
                if (u.getUserName().equals(name)) {
                    checkExit = true;
                }
            }
            if (!checkExit) {
                    System.out.println("Enter your password");
                    String pass = scanner.nextLine();
                    User user = new User(name, pass);
                    userArrayList.add(user);
                    write();
                    check = true;
                }
            else {
                checkExit = false;
                countFail++;
                System.out.println("You have " +(5 - countFail) + " entries left");
                System.out.println("The username already exists, please enter another username\n");
            }
        }
        while (!check);
    }
    public void logIn() {
        read();
        boolean check = false;
        int countFail = 0;
        do {
            System.out.println("Enter you user name");
            String name = scanner.nextLine();
            for (User u : userArrayList
            ) {
                if (u.getUserName().equals(name)) {
                    countFail = 0;
                    do {
                        System.out.println("Enter your password");
                        String pass = scanner.nextLine();
                        if (u.getPassWord().equals(pass) && userArrayList.indexOf(checkUserName(name)) == userArrayList.indexOf(checkUserPass(pass))) {
                            System.out.println("Successful login");
                            cartDetail.setUser(name);
                            System.out.println(name);
                            check = true;
                        }
                        else {
                            countFail++;
                            System.out.println("You have " + (5 - countFail) + " entries left");
                            checkFail(countFail);
                        }
                    }
                    while (!check);
                }
            }
            countFail++;
            System.out.println("You have " + (5 - countFail) + " entries left");
            checkFail(countFail);
        }

        while (!check);
    }

    public void checkFail(int countFail) {
        if (countFail == 5) {
            System.out.println("Because you have entered incorrectly more than three times, please enter again after 30 minutes\n");
            System.exit(0);
        }
    }

    public User checkUserName(String name) {
        for (User u : userArrayList
        ) {
            if (u.getUserName().equals(name)) {
                return u;
            }
        }
        return null;
    }

    public User checkUserPass(String pass) {
        for (User u : userArrayList
        ) {
            if (u.getUserName().equals(pass)) {
                return u;
            }
        }
        return null;
    }

    private void read() {
        List<User> usersFile = new ArrayList<>();
        File file = new File("user");
        try (ObjectInputStream obj = new ObjectInputStream(Files.newInputStream(file.toPath()))) {
            usersFile = (List<User>) obj.readObject();
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        userArrayList = usersFile;

    }

    private void write() {
        File file = new File("user");
        try (ObjectOutputStream obj = new ObjectOutputStream(Files.newOutputStream(file.toPath()))) {
            obj.writeObject(userArrayList);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
