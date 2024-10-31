package com.mvc.service;

import com.mvc.model.User;
import java.sql.*;

public class UserService
{
	String jdbcURL = "jdbc:mysql://localhost:3306/webseries_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "abhinav2005";

    private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "SELECT id, username, password FROM users WHERE username = ? AND password = ?";
    
    protected Connection getConnection() throws ClassNotFoundException 
    {
        Connection connection = null;
        try 
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return connection;
    }

    public User validateUser(String username, String password) throws ClassNotFoundException 
    {
        User user = null;
        try 
        {
        	Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()) 
            {
                int id = rs.getInt("id");
                user = new User(id, username, password);
            }
        } 
        catch(SQLException e) 
        {
            e.printStackTrace();
        }
        return user;
    }
}
