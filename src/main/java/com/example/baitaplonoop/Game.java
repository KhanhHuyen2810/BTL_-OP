package com.example.baitaplonoop;
public class Game {
    private String Question;
    private String Answer;

    Game(){

    }

    Game(String Question, String Answer) {
        this.Question = Question;
        this.Answer = Answer;
    }

    public String getQuestion() {
        return this.Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public String getAnswer() {
        return this.Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }
}
