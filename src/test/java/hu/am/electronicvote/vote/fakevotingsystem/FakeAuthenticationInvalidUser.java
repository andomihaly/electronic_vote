package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.Authentication;
import hu.am.electronicvote.vote.AuthenticationConnector;
import hu.am.electronicvote.vote.VotePresenter;
import hu.am.electronicvote.vote.systemtest.common.KnownVoteObject;

public class FakeAuthenticationInvalidUser implements Authentication {

    private final AuthenticationConnector connector;

    public FakeAuthenticationInvalidUser(AuthenticationConnector connector) {
        this.connector = connector;
    }

    @Override
    public void loginWithPassword() {
        connector.showError("NOT_LOGGED_IN_USER|" + new KnownVoteObject().notLoggedInUser.sessionId);
    }

    @Override
    public void loginWithEIdentityCard() {
        connector.showError("NOT_LOGGED_IN_USER|" + new KnownVoteObject().notLoggedInUser.sessionId);
    }
}
