package hu.am.fakevotingsystem;

import am.vote.Election;
import am.vote.Presenter;
import am.vote.entity.Answer;
import am.vote.entity.Question;
import am.vote.entity.Questionnaire;
import am.vote.entity.User;

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
        int hasProblem = 0;
        hasProblem += checkUser(user);
        hasProblem += checkVote(vote);
        if (hasProblem == 0) {
            this.vote = vote;
        }
    }

    private int checkUser(User user) {
        int hasProblem = 0;
        if (!user.name.equals("Valid User")) {
            presenter.showError("-2");
            hasProblem--;
        }
        if (this.vote != null) {
            presenter.showError("-1");
            hasProblem--;
        }
        return hasProblem;
    }

    private int checkVote(List<Answer> vote) {
        Set<Question> questionSet = new HashSet<>();
        for (Answer answer: vote) {
            questionSet.add(answer.question);
        }
        if (vote.size() != questionSet.size()) {
            presenter.showError("-3");
            return -1;
        }
        return 0;
    }

    public List<Answer> getVote(User user) {
        return vote;
    }

    public boolean isVoted(User user) {
        return this.vote != null;
    }
}
