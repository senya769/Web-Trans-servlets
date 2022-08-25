package com.repository;


import com.model.User;

import java.util.List;

public interface UserDAO extends BaseDAO{
    //boolean setStatus(String status);
    //boolean deleteUser(User user);
    boolean deleteUser(int id);
    boolean updateUser(User user);
    boolean isDuplicate();
    List<User> getListUsers();
    boolean checkDuplicateNickname(String nick);
    boolean checkDuplicateEmail(String mail);
    boolean checkDuplicateNumber(String number);
}
