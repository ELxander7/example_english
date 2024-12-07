package ru.kpfu.itis.oris.armanov.example_english.entity;

public class Result {
    private int resultId;
    private int fkUserIdResult;
    private int fkTestTypeIdResult;
    private int fkQuestionIdResult;
    private int fkChoiceIdResult;
    private int selAnswer;
    private int isAnswer;

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getFkUserIdResult() {
        return fkUserIdResult;
    }

    public void setFkUserIdResult(int fkUserIdResult) {
        this.fkUserIdResult = fkUserIdResult;
    }

    public int getFkTestTypeIdResult() {
        return fkTestTypeIdResult;
    }

    public void setFkTestTypeIdResult(int fkTestTypeIdResult) {
        this.fkTestTypeIdResult = fkTestTypeIdResult;
    }

    public int getFkQuestionIdResult() {
        return fkQuestionIdResult;
    }

    public void setFkQuestionIdResult(int fkQuestionIdResult) {
        this.fkQuestionIdResult = fkQuestionIdResult;
    }

    public int getFkChoiceIdResult() {
        return fkChoiceIdResult;
    }

    public void setFkChoiceIdResult(int fkChoiceIdResult) {
        this.fkChoiceIdResult = fkChoiceIdResult;
    }

    public int getSelAnswer() {
        return selAnswer;
    }

    public void setSelAnswer(int selAnswer) {
        this.selAnswer = selAnswer;
    }

    public int getIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(int isAnswer) {
        this.isAnswer = isAnswer;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultId=" + resultId +
                ", fkUserIdResult=" + fkUserIdResult +
                ", fkTestTypeIdResult=" + fkTestTypeIdResult +
                ", fkQuestionIdResult=" + fkQuestionIdResult +
                ", fkChoiceIdResult=" + fkChoiceIdResult +
                ", selAnswer=" + selAnswer +
                ", isAnswer=" + isAnswer +
                '}';
    }
}