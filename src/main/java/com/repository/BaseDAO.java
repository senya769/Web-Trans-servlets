package com.repository;



import com.model.User;

import java.sql.SQLException;

public interface BaseDAO {
    User findByEmailAndPassword(String log, String pas) throws SQLException;
    boolean createUser(User user);
}
