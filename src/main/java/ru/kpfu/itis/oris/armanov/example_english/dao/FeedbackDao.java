package ru.kpfu.itis.oris.armanov.example_english.dao;

import ru.kpfu.itis.oris.armanov.example_english.config.PostgreSQLDS;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FeedbackDao {

    private DataSource ds;
    private Connection conn;

    public FeedbackDao() {
        this.ds = PostgreSQLDS.getDs();
    }

    private PreparedStatement ps;

    public void addFeedback(int testTypeId, int rating, String description) {
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("INSERT INTO feedback (Fk_TestTypeId_Feedback, Rating, Description) VALUES (?,?,?)");
            ps.setInt(1, testTypeId);
            ps.setInt(2, rating);
            ps.setString(3, description);
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
