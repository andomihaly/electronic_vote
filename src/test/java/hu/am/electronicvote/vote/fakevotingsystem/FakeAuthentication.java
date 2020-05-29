package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.Authentication;
import hu.am.electronicvote.vote.AuthenticationConnector;
import hu.am.electronicvote.vote.VotePresenter;
import hu.am.electronicvote.vote.systemtest.common.KnownVoteObject;

public class FakeAuthentication implements Authentication {

    private final AuthenticationConnector connector;

    public FakeAuthentication(AuthenticationConnector connector) {
        this.connector = connector;
    }

    @Override
    public void loginWithPassword() {
        connector.getUserInfo(new KnownVoteObject().validUser.sessionId);
    }

    @Override
    public void loginWithEIdentityCard() {
        connector.getUserInfo(new KnownVoteObject().validUser.sessionId);
    }
}
