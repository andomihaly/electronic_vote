package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.Election;
import hu.am.electronicvote.vote.VotePresenter;
import hu.am.electronicvote.vote.entity.Answer;
import hu.am.electronicvote.vote.entity.Question;
import hu.am.electronicvote.vote.entity.Questionnaire;
import hu.am.electronicvote.vote.exception.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FakeElection implements Election {

    private final VotePresenter votePresenter;
    private List<Answer> vote;

    public FakeElection(VotePresenter votePresenter) {
        this.votePresenter = votePresenter;
    }

    public boolean isOngoing() {
        return true;
    }

    public Questionnaire getQuestionnaire() {
        return new Questionnaire();
    }

    public void vote(String userId, List<Answer> vote) {
        try {
            checkUser(userId);
            checkVote(vote);
            this.vote = vote;
        } catch (VoteException e) {
            votePresenter.showError(e.errorCode.toString());
        } catch (Exception e) {
            votePresenter.showError(ErrorCode.UNEXPECTED_ERROR.toString());
        }

    }

    private void checkUser(String userId) {
        if (!userId.equals("Valid User ID")) {
            throw new InvalidUserException();
        }
        if (this.vote != null) {
            throw new DoubledVoteException();
        }
    }

    private void checkVote(List<Answer> vote) {
        Set<Question> questionSet = new HashSet<>();
        for (Answer answer : vote) {
            questionSet.add(answer.question);
        }
        if (vote.size() != questionSet.size()) {
            throw new MultipleAnswerException();
        }
    }

    public boolean isVoted(String userId) {
        return this.vote != null;
    }
}
