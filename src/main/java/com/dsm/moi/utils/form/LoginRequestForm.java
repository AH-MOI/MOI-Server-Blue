package com.dsm.moi.utils.form;

public class LoginRequestForm {

    private String id;
    private String password;

    public LoginRequestForm() {}
    public LoginRequestForm(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
