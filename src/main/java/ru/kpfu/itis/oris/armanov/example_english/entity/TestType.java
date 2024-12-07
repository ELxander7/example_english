package ru.kpfu.itis.oris.armanov.example_english.entity;

import java.util.List;

public class TestType {
    private int testTypeId;
    private String name;
    private String description;
    private String ImageUrl;
    private List<Question> questions;
    private String questionsJson;
    private Feedback feedback;



    public int getTestTypeId() {
        return testTypeId;
    }

    public void setTestTypeId(int testTypeId) {
        this.testTypeId = testTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "TestType{" +
                "TestTypeId=" + testTypeId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", questions=" + questions +
                ", feedback=" + feedback +
                '}';
    }
}