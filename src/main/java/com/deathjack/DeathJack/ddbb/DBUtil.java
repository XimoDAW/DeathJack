package com.deathjack.DeathJack.ddbb;
import java.sql.*;
import java.util.List;

public class DBUtil {
    private static final String URL = "jdbc:mariadb://localhost:3306/DeathJack";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection open(boolean autoCommit) {
        try {
            Connection connection = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            connection.setAutoCommit(autoCommit);
            return connection;
        }catch (SQLException e) {
            throw new RuntimeException("Error");
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement setParameters(Connection connection, String sql, List<Object> values){
        try {
            PreparedStatement preparedStatement =  connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if(values != null) {
                for(int i=0;i<values.size();i++) {
                    Object value = values.get(i);
                    preparedStatement.setObject(i+1,value);
                }
            }
            return preparedStatement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet select (Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            return preparedStatement.executeQuery();
        }catch (Exception e){
            throw new RuntimeException("Error");
        }
    }

    public static int insert (Connection connection, String sql, List<Object> values) {
        try {
            PreparedStatement preparedStatement = setParameters(connection, sql, values);
            preparedStatement.executeUpdate();
            return 1;
        }catch (Exception e){
            throw new RuntimeException("Error");
        }
    }
}