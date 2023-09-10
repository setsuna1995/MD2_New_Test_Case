package service.userManage;

import model.user.Admin;


import java.util.Scanner;

public class AdminManage {
    private final Scanner scanner;
    private final Admin admin;

    public AdminManage() {
        scanner = new Scanner(System.in);
        admin = new Admin();
    }

    public void logIn() {
        boolean check = false;
        int countFail = 0;
        do {
            System.out.println("Enter user name");
            String name = scanner.nextLine();
            if (name.equals(admin.getName())) {
                countFail = 0;
                do {
                    System.out.println("Enter password");
                    String pass = scanner.nextLine();
                    if (pass.equals(admin.getPass())) {
                        System.out.println("Successful login");
                        check = true;
                    }
                    countFail++;
                    System.out.println("You have " +(5 - countFail) + " entries left");
                    checkFail(countFail);
                }while (!check);

            }
            countFail++;
            System.out.println("You have " +(5 - countFail) + " entries left");
            checkFail(countFail);
        }
        while (!check);
    }
    public void checkFail (int countFail) {
        if (countFail == 5) {
            System.out.println("Because you have entered incorrectly more than three times, please enter again after 30 minutes\n");
            System.exit(0);
        }
    }
}
