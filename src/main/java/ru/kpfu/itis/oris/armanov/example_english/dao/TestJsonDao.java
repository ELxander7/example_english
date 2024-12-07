package ru.kpfu.itis.oris.armanov.example_english.dao;

import ru.kpfu.itis.oris.armanov.example_english.config.PostgreSQLDS;
import ru.kpfu.itis.oris.armanov.example_english.entity.Choice;
import ru.kpfu.itis.oris.armanov.example_english.entity.Question;
import ru.kpfu.itis.oris.armanov.example_english.entity.Test;
import ru.kpfu.itis.oris.armanov.example_english.entity.TestJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.sql.DataSource;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class TestJsonDao {

    private DataSource ds;
    private Connection conn;

    public TestJsonDao() {
        this.ds = PostgreSQLDS.getDs();
    }

    private PreparedStatement ps;
    public Test getTest(int id) {
        Test test = new Test();

        test.setTestType(new TestTypeDao().getTestType(id));
        List<Question> questions = new QuestionDao().getTenRandomQuestions(id);

        for (int i=0; i < questions.size(); i++) {
            int questionId = questions.get(i).getQuestionId();
            List<Choice> choices = new ChoiceDao().getChoices(questionId);
            Gson gson = new Gson();
            JsonArray jarray = gson.toJsonTree(choices).getAsJsonArray();
            System.out.println(jarray);
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("choices", jarray);

            questions.get(i).setChoicesJson(jsonObject.get("choices").toString());
        }

        Gson gson = new Gson();
        JsonArray jarray = gson.toJsonTree(questions).getAsJsonArray();
        System.out.println(jarray);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("questions", jarray);
        test.setQuestionsJson(jsonObject.get("questions").toString());


        return test;
    }
}