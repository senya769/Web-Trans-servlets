package com.repository;


import com.model.User;

public interface UserDAO extends BaseDAO{
    //boolean setStatus(String status);
    //boolean deleteUser(User user);
    boolean deleteUser(int id);
    boolean updateUser(User user);
    boolean isDuplicate();
    boolean checkDuplicateNickname(String nick);
    boolean checkDuplicateEmail(String mail);
    boolean checkDuplicateNumber(String number);
}
