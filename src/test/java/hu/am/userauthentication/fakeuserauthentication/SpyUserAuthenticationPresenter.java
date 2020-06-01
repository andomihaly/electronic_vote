package hu.am.userauthentication.fakeuserauthentication;

import hu.am.userauthentication.UserAuthenticationPresenter;

public class SpyUserAuthenticationPresenter implements UserAuthenticationPresenter {
    public String lastErrorMessage;

    @Override
    public void showError(String message) {
        this.lastErrorMessage = message;
    }

}
