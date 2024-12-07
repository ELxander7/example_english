package ru.kpfu.itis.oris.armanov.example_english.entity;

public class Feedback {
    private int feedbackId;
    private int fkTestTypeIdFeedback;
    private int rating;
    private String description;

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getFkTestTypeIdFeedback() {
        return fkTestTypeIdFeedback;
    }

    public void setFkTestTypeIdFeedback(int fkTestTypeIdFeedback) {
        this.fkTestTypeIdFeedback = fkTestTypeIdFeedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", fkTestTypeIdFeedback=" + fkTestTypeIdFeedback +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}