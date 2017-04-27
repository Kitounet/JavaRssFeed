package com.example.bbizet.javarssfeed.receiver;

import java.io.Serializable;

/**
 * Created by bbizet on 25/04/2017.
 */

public class Register implements Serializable{

    private Integer iduser;
    private String login;
    private String password;

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
