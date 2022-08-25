package com.repository.impl;

import com.connection.JDBCConnector;
import com.model.User;

import java.util.*;

public class testApp {
    public static void main(String[] args) {
        JDBCConnector connector = new JDBCConnector();
        ImplUser implUser = new ImplUser(connector);
        List<User> res = implUser.getListUsers();
     for(User u : res){
         System.out.println(u);
     }
    }
}
