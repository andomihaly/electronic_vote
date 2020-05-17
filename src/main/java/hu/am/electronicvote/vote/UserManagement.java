package hu.am.electronicvote.vote;

import hu.am.electronicvote.vote.entity.User;

public interface UserManagement {
    boolean isLoggedIn(User user);

    boolean hasRightToVote(User user);
}
