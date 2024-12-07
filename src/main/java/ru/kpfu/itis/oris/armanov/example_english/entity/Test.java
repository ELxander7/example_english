package ru.kpfu.itis.oris.armanov.example_english.entity;

import java.util.List;

public class Test {
    private TestType testType;
    private List<Question> questions;
    private String questionsJson;

    public String getQuestionsJson() {
        return questionsJson;
    }

    public void setQuestionsJson(String questionsJson) {
        this.questionsJson = questionsJson;
    }

    public TestType getTestType() {
        return testType;
    }

    public void setTestType(TestType testType) {
        this.testType = testType;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testType=" + testType +
                ", questions=" + questions +
                '}';
    }
}