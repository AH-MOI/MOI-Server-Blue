package com.dsm.moi.utils.form;

public class AccessTokenResponseForm {

    private String accessToken;

    public AccessTokenResponseForm() {}
    public AccessTokenResponseForm(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
