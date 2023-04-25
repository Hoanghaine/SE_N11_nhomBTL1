package com.Models;

public class AccountBacsi {
    private String username;
    private String password;
    private Integer id_bacsi;

    public Integer get_id_bacsi() {
        return id_bacsi;
    }

    public void set_id_bacsi(Integer id) {
        this.id_bacsi = id_bacsi;
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

    public AccountBacsi(String username, String password, int id_bacsi) {
        this.username = username;
        this.password = password;
        this.id_bacsi = id_bacsi;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account [username=" + username + ", password=" + password + "]";
    }
}
