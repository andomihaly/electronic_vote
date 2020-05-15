package hu.am.electronicvote.logging.entity;

public class UserInfo {

    public String username;
    public String authorizationLevel;

    public UserInfo(String username, String authorizationLevel) {
        this.username = username;
        this.authorizationLevel = authorizationLevel;
    }

}
