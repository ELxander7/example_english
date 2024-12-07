package ru.kpfu.itis.oris.armanov.example_english.dao;
import ru.kpfu.itis.oris.armanov.example_english.entity.User;
import ru.kpfu.itis.oris.armanov.example_english.config.PostgreSQLDS;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    private DataSource ds;
    private Connection conn;

    public UserDao(){
        this.ds = PostgreSQLDS.getDs();
    }

    private PreparedStatement preparedStatement;

    public boolean checkCredentials(String username, String password)
    {
        boolean st =false;
        try {
            this.conn = ds.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM users WHERE Email=? AND Password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs =preparedStatement.executeQuery();
            st = rs.next();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    public User getUserId(String username) {
        User user = new User();
        try {
            this.conn = ds.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM users WHERE Email=?");
            preparedStatement.setString(1, username);
            ResultSet rs =preparedStatement.executeQuery();
            if (rs.next()) {
                user.setUserId(rs.getInt("Id"));
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean userExists(String username) {
        int result = 0;
        try {
            this.conn = ds.getConnection();
            preparedStatement = conn.prepareStatement("SELECT IF (EXISTS(SELECT * FROM users WHERE Email=?),1,0) AS userExists");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                result = rs.getInt("userExists");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result == 1;
    }

    public void addUser(String username, String password) {
        try {
            this.conn = ds.getConnection();
            preparedStatement = conn.prepareStatement("INSERT INTO users (Email, Password) VALUES (?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

