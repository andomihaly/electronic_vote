package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.Authorization;
import hu.am.electronicvote.vote.AuthorizationConnector;
import hu.am.electronicvote.vote.exception.ErrorCode;
import hu.am.electronicvote.vote.systemtest.common.KnownVoteObject;

import java.time.LocalDateTime;

public class FakeTimeAuthorization implements Authorization {

    private final AuthorizationConnector connector;
    private int numberOfTries = 0;
    public LocalDateTime lockingTime;

    public FakeTimeAuthorization(AuthorizationConnector connector) {
        this.connector = connector;
    }

    @Override
    public void loginWithPassword() {
        if (numberOfTries < 3) {
            connector.showError(ErrorCode.NOT_LOGGED_IN_USER + "|" + KnownVoteObject.NOT_LOGGED_IN_USER_SESSIONID + "|" + numberOfTries);
            lockingTime = LocalDateTime.now().plusMinutes(10);
        } else {
            if (LocalDateTime.now().isAfter(lockingTime))
                connector.getUserInfo(KnownVoteObject.VALID_USER_SESSIONID);
            else
                connector.showError(ErrorCode.NOT_LOGGED_IN_USER_BECAUSE_OF_USER_LOCK + "|" + KnownVoteObject.NOT_LOGGED_IN_USER_SESSIONID + "|" + numberOfTries);
        }
        numberOfTries++;
    }

    @Override
    public void loginWithEIdentityCard() {

    }

}
