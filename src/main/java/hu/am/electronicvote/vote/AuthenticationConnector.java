package hu.am.electronicvote.vote;

public interface AuthenticationConnector {
    void showError(String message);

    void getUserInfo(String userInfo);
}
