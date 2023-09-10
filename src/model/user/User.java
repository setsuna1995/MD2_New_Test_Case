package model.user;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialUID = 123456789;
    private int INDEX;
    private int idUser;
    private String userName;
    private String passWord;

    public User() {
    }

    public User(String userName, String passWord) {
        this.idUser = ++INDEX;
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

    @Override
    public String toString() {
        return "User{" +
                 userName + '\'' +
                '}';
    }
}
