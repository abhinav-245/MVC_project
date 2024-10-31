package com.mvc.service;

import com.mvc.model.WebSeries;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WebSeriesService 
{
    private String jdbcURL = "jdbc:mysql://localhost:3306/webseries_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "abhinav2005";

    private static final String SELECT_SERIES_BY_USER_ID = "SELECT * FROM web_series WHERE user_id = ?";

    protected Connection getConnection() 
    {
        Connection connection = null;
        try 
        {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return connection;
    }

    public List<WebSeries> selectAllWebSeriesByUser(int userId) 
    {
        List<WebSeries> webSeriesList = new ArrayList<>();
        try
        {
        	Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERIES_BY_USER_ID);
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) 
            {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String platform = rs.getString("platform");
                int releaseYear = rs.getInt("release_year");
                webSeriesList.add(new WebSeries(id, userId, title, genre, platform, releaseYear));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return webSeriesList;
    }
}
