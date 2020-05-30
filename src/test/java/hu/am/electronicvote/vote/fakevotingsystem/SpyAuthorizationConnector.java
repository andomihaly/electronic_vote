package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.AuthorizationConnector;

public class SpyAuthorizationConnector implements AuthorizationConnector {
    public String lastErrorMessage;
    public String lastUserInfo;
    public String sessionId;

    @Override
    public void showError(String message) {
        lastErrorMessage = message;
        sessionId = message.split("\\|")[1];
    }

    @Override
    public void getUserInfo(String userInfo) {
        lastUserInfo = userInfo;
        sessionId = userInfo;
    }
}
