package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.Authorization;
import hu.am.electronicvote.vote.AuthorizationConnector;
import hu.am.electronicvote.vote.systemtest.common.KnownVoteObject;

public class FakeAuthorization implements Authorization {

    private final AuthorizationConnector connector;

    public FakeAuthorization(AuthorizationConnector connector) {
        this.connector = connector;
    }

    @Override
    public void loginWithPassword() {
        connector.getUserInfo(KnownVoteObject.VALID_USER_SESSIONID);
    }

    @Override
    public void loginWithEIdentityCard() {
        connector.getUserInfo(KnownVoteObject.VALID_USER_SESSIONID);
    }
}
