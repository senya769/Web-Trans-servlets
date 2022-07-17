package com.model;

public class BuilderUser {
    private final User user;

    public BuilderUser() {
        user = new User();
    }

    public BuilderUser name(String name) {
        this.user.setName(name);
        return this;
    }

    public BuilderUser email(String mail) {
        this.user.setEmail(mail);
        return this;
    }

    public BuilderUser numberPhone(String number) {
        this.user.setNumberPhone(number);
        return this;
    }

    public BuilderUser password(String password) {
        this.user.setPassword(password);
        return this;
    }

    public BuilderUser id(int id) {
        this.user.setId(id);
        return this;
    }

    public BuilderUser roleUser(String role) {
        this.user.setRoleUser(role);
        return this;
    }
    public BuilderUser statusUser(String status) {
        this.user.setStatusUser(status);
        return this;
    }


    public User build() {
        return this.user;
    }
}

