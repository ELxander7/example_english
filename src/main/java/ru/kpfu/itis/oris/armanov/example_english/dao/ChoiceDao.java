package ru.kpfu.itis.oris.armanov.example_english.dao;

import ru.kpfu.itis.oris.armanov.example_english.config.PostgreSQLDS;
import ru.kpfu.itis.oris.armanov.example_english.entity.Choice;
import ru.kpfu.itis.oris.armanov.example_english.entity.Question;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChoiceDao {
    private DataSource ds;
    private Connection conn;


    public ChoiceDao() {
        this.ds = PostgreSQLDS.getDs();
    }

    public List<Choice> getChoices(int id) {
        List<Choice> choices = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT c.Id AS ChoiceId, c.Description AS ChoiceDescription, c.IsAnswer AS ChoiceIsAnswer FROM choices AS c INNER JOIN questions AS qu ON qu.Id=c.Fk_QuestionId_Choice WHERE qu.Id=?");
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Choice c = new Choice();
                c.setChoiceId(resultSet.getInt("ChoiceId"));
                c.setDescription(resultSet.getString("ChoiceDescription"));
                c.setIsAnswer(resultSet.getInt("ChoiceIsAnswer"));
                choices.add(c);
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
        return choices;
    }
}
