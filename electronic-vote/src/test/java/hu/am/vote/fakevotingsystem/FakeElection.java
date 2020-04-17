package hu.am.vote.fakevotingsystem;

import hu.am.vote.Election;
import hu.am.vote.Presenter;
import hu.am.vote.entity.Answer;
import hu.am.vote.entity.Question;
import hu.am.vote.entity.Questionnaire;
import hu.am.vote.entity.User;
import hu.am.vote.exception.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FakeElection implements Election {

    private final Presenter presenter;
    private List<Answer> vote;

    public FakeElection(Presenter presenter){
        this.presenter = presenter;
    }

    public boolean isStarted() {
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
        if (!user.name.equals("Valid User")) {
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

    public List<Answer> getVote(User user) {
        return vote;
    }

    public boolean isVoted(User user) {
        return this.vote != null;
    }
}
