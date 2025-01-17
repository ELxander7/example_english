package ru.kpfu.itis.oris.armanov.example_english.dao;

import ru.kpfu.itis.oris.armanov.example_english.config.PostgreSQLDS;
import ru.kpfu.itis.oris.armanov.example_english.entity.Question;
import ru.kpfu.itis.oris.armanov.example_english.entity.QuestionChoice;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionChoiceDao {
    private DataSource ds;
    private Connection conn;


    public QuestionChoiceDao() {
        this.ds = PostgreSQLDS.getDs();
    }
    public List<QuestionChoice> getTenRandomQuestionsWithChoices(int id) {
        List<QuestionChoice> questions = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("" +
                    "SELECT qu.Id AS QuestionId, qu.Description AS QuestionDescription, c.Id AS ChoiceId, c.Description AS ChoiceDescription, c.IsAnswer AS ChoiceIsAnswer " +
                    "FROM test_types AS tt " +
                    "INNER JOIN questions AS qu ON qt.Id=Fk_TestTypeId_Question " +
                    "INNER JOIN choices AS c ON qu.Id=c.Fk_QuestionId_Choice " +
                    "WHERE qt.Id=? " +
                    "ORDER BY RAND() LIMIT 50");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuestionChoice qu = new QuestionChoice();
                qu.setQuestionId(rs.getInt("QuestionId"));
                qu.setQuestionDescription(rs.getString("QuestionDescription"));
                qu.setChoiceId(rs.getInt("ChoiceId"));
                qu.setChoiceDescription(rs.getString("ChoiceDescription"));
                qu.setChoiceIsAnswer(rs.getInt("ChoiceIsAnswer"));
                qu.setIsSelected(0);
                questions.add(qu);
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
        return questions;
    }
}
