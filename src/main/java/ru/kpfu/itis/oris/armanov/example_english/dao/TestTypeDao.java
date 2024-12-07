package ru.kpfu.itis.oris.armanov.example_english.dao;

import ru.kpfu.itis.oris.armanov.example_english.config.PostgreSQLDS;
import ru.kpfu.itis.oris.armanov.example_english.entity.TestType;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestTypeDao {
    private DataSource ds;
    private Connection conn;


    public TestTypeDao() {
        this.ds = PostgreSQLDS.getDs();
    }

    public List<TestType> getTestTypes() {
        List<TestType> testTypes = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM test_types");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TestType tt = new TestType();
                tt.setTestTypeId(rs.getInt("Id"));
                tt.setName(rs.getString("Name"));
                tt.setDescription(rs.getString("Description"));
                tt.setImageUrl(rs.getString("ImageURL"));

                testTypes.add(tt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return testTypes;
    }

    public TestType getTestType(int id) {
        TestType testType = new TestType();
        PreparedStatement ps = null;
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM test_types WHERE Id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                testType.setTestTypeId(rs.getInt("Id"));
                testType.setName(rs.getString("Name"));
                testType.setDescription(rs.getString("Description"));
                testType.setImageUrl(rs.getString("ImageURL"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return testType;
    }
}
