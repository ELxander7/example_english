package ru.kpfu.itis.oris.armanov.example_english.dao;

import ru.kpfu.itis.oris.armanov.example_english.config.PostgreSQLDS;
import ru.kpfu.itis.oris.armanov.example_english.entity.Choice;
import ru.kpfu.itis.oris.armanov.example_english.entity.Question;
import ru.kpfu.itis.oris.armanov.example_english.entity.Test;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TestDao {
    private DataSource ds;
    private Connection conn;

    public TestDao() {
        this.ds = PostgreSQLDS.getDs();
    }

    private PreparedStatement ps;
    public Test getTest(int id) {
        Test test = new Test();

        test.setTestType(new TestTypeDao().getTestType(id));
        test.setQuestions(new QuestionDao().getTenRandomQuestions(id));
        for (int i=0; i < test.getQuestions().size(); i++) {
            int questionId = test.getQuestions().get(i).getQuestionId();
            test.getQuestions().get(i).setChoices(new ChoiceDao().getChoices(questionId));
        }
        return test;
    }
}
