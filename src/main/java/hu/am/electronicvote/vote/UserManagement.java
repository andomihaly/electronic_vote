package hu.am.electronicvote.vote;

public interface UserManagement {
    boolean isLoggedIn(String userSessionId);

    boolean hasRightToVote(String userSessionId);

    String getUserIdBySessionId(String userSessionId);
}
