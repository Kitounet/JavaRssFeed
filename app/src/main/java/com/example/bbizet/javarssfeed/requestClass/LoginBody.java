package com.example.bbizet.javarssfeed.requestClass;

/**
 * Created by bbizet on 26/04/2017.
 */

public class LoginBody {
    public String username;
    public String password;

    public LoginBody(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
