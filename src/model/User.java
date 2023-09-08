package model;

import java.io.Serializable;

public class User implements Serializable {
    private static long serialUID = 123456789;
    private int idUser;
    private String userName;
    private String passWord;


    public User(int idUser, String userName, String passWord) {
        this.idUser = idUser;
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
