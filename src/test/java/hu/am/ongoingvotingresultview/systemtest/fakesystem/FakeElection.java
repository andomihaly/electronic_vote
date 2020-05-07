package hu.am.ongoingvotingresultview.systemtest.fakesystem;

import hu.am.vote.Election;
import hu.am.vote.entity.Answer;
import hu.am.vote.entity.Questionnaire;
import hu.am.vote.entity.User;

import java.util.List;

public class FakeElection implements Election {
    @Override
    public boolean isOngoing() {
        return true;
    }

    @Override
    public Questionnaire getQuestionnaire() {
        return null;
    }

    @Override
    public void vote(User user, List<Answer> vote) {

    }

    @Override
    public boolean isVoted(User user) {
        return false;
    }
}
