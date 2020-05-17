package hu.am.electronicvote.ongoingvotingresultview.systemtest.fakesystem;

import hu.am.electronicvote.vote.entity.User;
import hu.am.electronicvote.vote.Election;
import hu.am.electronicvote.vote.entity.Answer;
import hu.am.electronicvote.vote.entity.Questionnaire;

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
