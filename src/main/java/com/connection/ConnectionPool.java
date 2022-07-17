package com.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private BlockingQueue<Connection> connections;
    public static AtomicBoolean isPoolCreated = new AtomicBoolean();
    public static Lock lock = new ReentrantLock();
    public static final Integer POOL_SIZE = 5;
    public static ConnectionPool instance;

    public ConnectionPool() throws SQLException, ClassNotFoundException {
        this.connections = new LinkedBlockingDeque<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            connections.offer(new JDBCConnector().getConnection());
        }
    }

    public static ConnectionPool getInstance() {
        if (!isPoolCreated.get()) {
            try {
                lock.lock();
                if (instance == null) {
                    instance = new ConnectionPool();
                    isPoolCreated.set(true);
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }

    public void releaseConnection(Connection connection) {
        connections.offer(connection);
    }
    public void closePool() throws SQLException {
        while (!connections.isEmpty()){
            connections.poll().close();
        }
    }
}
