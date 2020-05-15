package hu.am.electronicvote.vote.entity;

public class Answer {
    public static Option INVALID_ANSWER = new Option();
    public Question question;
    public Option choice;

    public Answer(Question question, Option choice) {
        this.question = question;
        this.choice = choice;
    }
}
