package hu.am.fakevotingsystem;

import am.vote.Election;
import am.vote.Presenter;
import am.vote.entity.Answer;
import am.vote.entity.Questionnaire;
import am.vote.entity.User;

import java.util.List;

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
        if(user.name.equals("Valid User") ) {
            if(this.vote == null) {
                this.vote = vote;
            }else{
                presenter.showError("-1");
            }
        }else{
            presenter.showError("-2");
        }
    }

    public List<Answer> getVote(User user) {
        return vote;
    }

    public boolean isVoted(User user) {
        return this.vote != null;
    }
}
