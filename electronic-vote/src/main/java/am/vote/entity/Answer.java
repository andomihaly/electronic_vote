package am.vote.entity;

public class Answer {
    public static Optional INVALID_ANSWER = new Optional();
    public Question question;
    public Optional choice;

    public Answer(Question question, Optional choice) {
        this.question = question;
        this.choice = choice;
    }
}
