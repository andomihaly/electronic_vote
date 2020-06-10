package hu.am.userauthentication;

import hu.am.userauthentication.entity.UserAccount;

public interface UserAuthentication {
    void addAccount(String userName, String emailAddress);
    void indicateForgotPassword(String userName);
}
