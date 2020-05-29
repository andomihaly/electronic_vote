package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.VotePresenter;

public class SpyVotePresenter implements VotePresenter {

    public String lastErrorMessage;

    @Override
    public void showError(String message) {
        this.lastErrorMessage = message;
    }
}
