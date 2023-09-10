package model.user;

import java.io.Serializable;

public class Admin implements Serializable {
    private static final long serialUID = 123456789;
    private final String name;
    private final String pass;

    public Admin() {
        this.name = "admin";
        this.pass = "admin";
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}
