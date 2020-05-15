package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.Authentication;
import hu.am.electronicvote.vote.entity.User;
import hu.am.electronicvote.vote.systemtest.common.KnownVoteObject;

public class FakeAuthentication implements Authentication {

    @Override
    public User loginWithPassword() {
        return new KnownVoteObject().validUser;
    }
}
