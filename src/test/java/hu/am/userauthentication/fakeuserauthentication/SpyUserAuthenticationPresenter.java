package hu.am.userauthentication.fakeuserauthentication;

import hu.am.userauthentication.UserAuthenticationPresenter;

public class SpyUserAuthenticationPresenter implements UserAuthenticationPresenter {
    public String lastErrorMessage;
    public String lastUserMessage;

    @Override
    public void showErrorMessage(String message) {
        this.lastErrorMessage = message;
    }

    @Override
    public void showUserMessage(String message) {
        this.lastUserMessage = message;
    }

}
