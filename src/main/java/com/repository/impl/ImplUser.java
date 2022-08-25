package com.repository.impl;


import com.connection.JDBCConnector;
import com.model.BuilderUser;
import com.model.User;
import com.repository.BaseDAO;
import com.repository.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplUser implements UserDAO {

    private static final String CREATE_USER = "INSERT INTO webtrans (email,password,nickname,number,role,status) VALUES (?,?,?,?,?,?)";
    public static final String DELETE_USER = "DELETE FROM webtrans WHERE id= ?";
    private static final String FIND_BY_EMAIL_AND_PASSWORD = "SELECT * FROM webtrans WHERE email = ? AND password = ?";
    private static final String FIND_BY_EMAIL = "SELECT * FROM webtrans WHERE email = ?";
    private static final String FIND_BY_NICKNAME = "SELECT * FROM webtrans WHERE nickname = ?";
    private static final String FIND_BY_NUMBER = "SELECT * FROM webtrans WHERE number = ?";
    private static final String FIND_DUPLICATE = "SELECT * FROM webtrans WHERE email = ? OR nickname = ? OR number = ?";
    public static final String UPDATE_USER = "UPDATE webtrans SET nickname = ?, email = ?, number = ?, password = ? WHERE id = ?";
   public static final String GET_ALL_USERS = "SELECT * FROM webtrans";

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

    @Override
    public boolean deleteUser(int id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setString(1, String.valueOf(id));
            return preparedStatement.executeUpdate() != 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getNumberPhone());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getId());
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("!!!!!!!");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isDuplicate() {

        return false;
    }

    @Override
    public List<User> getListUsers() {
        List<User> list = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_USERS);
            int ind = 1;
            while (resultSet.next()){
                User user = new BuilderUser()
                        .id(resultSet.getInt(1))
                        .email(resultSet.getString(2))
                        .password(resultSet.getString(3))
                        .name(resultSet.getString(4))
                        .numberPhone(resultSet.getString(5))
                        .roleUser(resultSet.getString(6))
                        .statusUser(resultSet.getString(7))
                        .build();
                list.add(user);
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkDuplicateNickname(String nick) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NICKNAME)) {
            preparedStatement.setString(1, nick);
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkDuplicateEmail(String mail) {
        return false;
    }

    @Override
    public boolean checkDuplicateNumber(String number) {
        return false;
    }
}
