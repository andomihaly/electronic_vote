package hu.am.fakevotingsystem;

import am.vote.Authentication;
import am.vote.entity.User;

public class FakeAuthentication implements Authentication {
    public boolean isAuthenticated(User user) {
        return user.name.equals("Valid User");
    }

    public boolean alreadyVoted = true;

    public boolean hasRightToVote(User user) {
        return (alreadyVoted) ? false : true;
    }

}
