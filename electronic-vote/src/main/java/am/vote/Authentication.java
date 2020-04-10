package am.vote;

import am.vote.entity.User;

public interface Authentication {
    boolean isAuthenticated(User user);

    boolean hasRightToVote(User user);
}
