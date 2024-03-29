package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.Authorization;
import hu.am.electronicvote.vote.AuthorizationConnector;
import hu.am.electronicvote.vote.exception.ErrorCode;
import hu.am.electronicvote.vote.systemtest.common.KnownVoteObject;

public class FakeAuthorizationInvalidUser implements Authorization {

    private final AuthorizationConnector connector;

    public FakeAuthorizationInvalidUser(AuthorizationConnector connector) {
        this.connector = connector;
    }


    public void loginWithPassword() {
        connector.showError(ErrorCode.NOT_LOGGED_IN_USER + "|" + KnownVoteObject.NOT_LOGGED_IN_USER_SESSIONID + "|3");
    }


    public void loginWithEIdentityCard() {
        connector.showError(ErrorCode.NOT_LOGGED_IN_USER + "|" + KnownVoteObject.NOT_LOGGED_IN_USER_SESSIONID);
    }
}
