package hu.am.vote;

import hu.am.vote.entity.User;

public interface Authentication {
    boolean isAuthenticated(User user);

    boolean hasRightToVote(User user);
}
