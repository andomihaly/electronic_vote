package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.Presenter;

public class SpyPresenter implements Presenter {

    public String lastErrorMessage;

    @Override
    public void showError(String message) {
        this.lastErrorMessage = message;
    }
}
