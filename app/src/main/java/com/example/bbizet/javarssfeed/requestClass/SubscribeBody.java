package com.example.bbizet.javarssfeed.requestClass;

/**
 * Created by bbizet on 26/04/2017.
 */

public class SubscribeBody {
    public String username;
    public String password;
    public String passwordConfirm;

    public SubscribeBody(String username, String password, String passwordConfirm) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }



}
