package hu.am.electronicvote.vote;

import hu.am.electronicvote.vote.entity.User;

public interface UserManagement {
    boolean isLoggedIn(String sessionId);

    boolean hasRightToVote(User user);
}
