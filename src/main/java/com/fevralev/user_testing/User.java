package com.fevralev.user_testing;

import org.apache.commons.validator.routines.EmailValidator;

public class User {

    private String email;
    private String password;

    public User(String email, String password) {
        EmailValidator validator = EmailValidator.getInstance();
        if(validator.isValid(email)){
            this.email = email;
        }else {
        throw new IllegalArgumentException("Неверный email");}
        this.password = password;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
