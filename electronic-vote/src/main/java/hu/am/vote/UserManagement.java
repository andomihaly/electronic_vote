package hu.am.vote;

import hu.am.vote.entity.User;

public interface UserManagement {
    boolean isLoggedIn(User user);

    boolean hasRightToVote(User user);
}
