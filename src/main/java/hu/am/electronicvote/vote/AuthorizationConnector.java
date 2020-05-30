package hu.am.electronicvote.vote;

public interface AuthorizationConnector {
    void showError(String message);

    void getUserInfo(String userInfo);
}
