package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.entity.User;
import hu.am.electronicvote.vote.exception.*;
import hu.am.electronicvote.vote.Election;
import hu.am.electronicvote.vote.Presenter;
import hu.am.electronicvote.vote.entity.Answer;
import hu.am.electronicvote.vote.entity.Question;
import hu.am.electronicvote.vote.entity.Questionnaire;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FakeElection implements Election {

    private final Presenter presenter;
    private List<Answer> vote;

    public FakeElection(Presenter presenter){
        this.presenter = presenter;
    }

    public boolean isOngoing() {
        return true;
    }

    public Questionnaire getQuestionnaire() {
        return new Questionnaire();
    }

    public void vote(User user, List<Answer> vote) {
        try {
            checkUser(user);
            checkVote(vote);
            this.vote = vote;
        } catch (VoteException e) {
            presenter.showError(e.errorCode.toString());
        } catch (Exception e) {
            presenter.showError(ErrorCode.UNEXPECTED_ERROR.toString());
        }

    }

    private void checkUser(User user) {
        if (!user.sessionId.equals("Valid User")) {
            throw new InvalidUserException();
        }
        if (this.vote != null) {
            throw new DoubledVoteException();
        }
    }

    private void checkVote(List<Answer> vote) {
        Set<Question> questionSet = new HashSet<>();
        for (Answer answer: vote) {
            questionSet.add(answer.question);
        }
        if (vote.size() != questionSet.size()) {
            throw new MultipleAnswerException();
        }
    }

    public boolean isVoted(User user) {
        return this.vote != null;
    }
}
