package com.fevralev.user_testing;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (!Objects.equals(email, user.email)) return false;
        return Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
