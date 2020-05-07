package hu.am.vote.fakevotingsystem;

import hu.am.vote.Presenter;

public class SpyPresenter implements Presenter {

    public String lastErrorMessage;

    @Override
    public void showError(String message) {
        this.lastErrorMessage = message;
    }
}
