package com.Models;

public class AccountBenhnhan {
    private String username;
    private String password;
    private Integer id_benhnhan;

    public Integer get_id_benhnhan() {
        return id_benhnhan;
    }

    public void set_id_benhnhan(Integer id_benhnhan) {
        this.id_benhnhan = id_benhnhan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public AccountBenhnhan(String username, String password, int id_benhnhan) {
        this.username = username;
        this.password = password;
        this.id_benhnhan = id_benhnhan;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account [username=" + username + ", password=" + password + "]";
    }

}
