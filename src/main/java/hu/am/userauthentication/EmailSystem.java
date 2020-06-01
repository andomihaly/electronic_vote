package hu.am.userauthentication;

import hu.am.userauthentication.entity.KindsOfEmail;
import hu.am.userauthentication.entity.UserAccount;

public interface EmailSystem {
    void sendPasswordEmail(UserAccount userAccount, KindsOfEmail subject);
}
