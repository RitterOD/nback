package org.maslov.nback.controller.security.model;

public class LoginResponse {
    private String login;
    private String token;

    public LoginResponse(String login, String token) {
        this.login = login;
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
