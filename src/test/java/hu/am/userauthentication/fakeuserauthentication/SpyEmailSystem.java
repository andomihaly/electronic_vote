package hu.am.userauthentication.fakeuserauthentication;

import hu.am.userauthentication.EmailSystem;
import hu.am.userauthentication.entity.KindsOfEmail;
import hu.am.userauthentication.entity.UserAccount;

public class SpyEmailSystem implements EmailSystem {

    public UserAccount userAccount;
    public KindsOfEmail subject;

    @Override
    public void sendPasswordEmail(UserAccount userAccount, KindsOfEmail subject) {
        //ToDo: Misivel megbeszélni 1. jó-e gateway-nek 2 Nincs ilyen ág bizonyítása?
        //Assert.assertTrue(userAccount.oneTimePassword);
        this.userAccount = userAccount;
        this.subject = subject;
    }

}
