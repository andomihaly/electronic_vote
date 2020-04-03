package hu.am.fakevotingsystem;

import am.vote.Election;
import am.vote.entity.Answer;
import am.vote.entity.Questionnaire;
import am.vote.entity.User;

import java.util.List;

public class StubElection implements Election {
    private List<Answer> vote;

    public boolean isStarted() {
        return true;
    }

    public Questionnaire getQuestionnaire() {
        return new Questionnaire();
    }

    public void vote(List<Answer> vote) {
        this.vote = vote;
    }

    public List<Answer> getVote(User user) {
        return vote;
    }

    public boolean isVoted(User user) {
        return true;
    }
}
