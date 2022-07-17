package com.repository;


import com.model.User;

public interface UserDAO extends BaseDAO{
    boolean setStatus(String status);
    boolean deleteUser(User user);
}
