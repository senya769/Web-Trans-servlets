package com.repository.impl;


import com.connection.JDBCConnector;
import com.model.User;
import com.repository.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImplUser implements BaseDAO {

    private static final String CREATE_USER = "INSERT INTO webtrans (email,password,nickname,number,role,status) VALUES (?,?,?,?,?,?)";
    private static final String FIND_BY_EMAIL_AND_PASSWORD = "SELECT * FROM webtrans WHERE email = ? AND password = ?";
    private final JDBCConnector connector;

    public ImplUser(JDBCConnector connector) {
        this.connector = connector;
    }

    @Override
    public User findByEmailAndPassword(String mail, String password) {
        User user = new User();
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_EMAIL_AND_PASSWORD)) {
            preparedStatement.setString(1, mail);
            preparedStatement.setString(2, password);
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                user.setId(set.getInt("id"));
                user.setEmail(mail);
                user.setPassword(password);
                user.setName(set.getString("nickname"));
                user.setNumberPhone(set.getString("number"));
                user.setRoleUser(set.getString("role"));
                user.setStatusUser(set.getString("status"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return user.getName() != null ? user : null;
    }

    @Override
    public boolean createUser(User user) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_USER)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getNumberPhone());
            statement.setString(5, user.getRoleUser());
            statement.setString(6, user.getStatusUser());
            return statement.executeUpdate() == 1;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
