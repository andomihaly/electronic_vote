package hu.am.fakevotingsystem;

import am.vote.Election;
import am.vote.entity.Answer;
import am.vote.entity.Questionnaire;
import am.vote.entity.User;

public class StubElection implements Election {
    public boolean isStarted() {
        return true;
    }

    public Questionnaire getQuestionnaire() {
        return new Questionnaire();
    }

    public void vote(Answer answer) {
    }

    public boolean isVoted(User user) {
        return true;
    }
}
