package hu.am.userauthentication.fakeuserauthentication;

import hu.am.userauthentication.EmailSystem;
import hu.am.userauthentication.UserAuthentication;
import hu.am.userauthentication.UserAuthenticationPresenter;
import hu.am.userauthentication.entity.KindsOfEmail;
import hu.am.userauthentication.entity.UserAccount;
import hu.am.userauthentication.exception.InvalidEmailException;
import hu.am.userauthentication.exception.UserAuthenticationException;
import hu.am.userauthentication.systemtest.common.KnownUserAuthenticationObject;

public class FakeUserAuthentication implements UserAuthentication {
    public static final String ONE_TIME_PASSWORD = "ONE_TIME_PASSWORD";
    private final UserAuthenticationPresenter presenter;
    private final EmailSystem emailSystem;

    private UserAccount userAccount;

    public FakeUserAuthentication(UserAuthenticationPresenter presenter, EmailSystem emailSystem) {
        this.presenter = presenter;
        this.emailSystem = emailSystem;
    }

    @Override
    public void addAccount(String userName, String emailAddress) {
        try {
            if (emailAddress.equals(KnownUserAuthenticationObject.INVALID_EMAIL_ADDRESS)) {
                throw new InvalidEmailException();
            }

            userAccount = new UserAccount();
            userAccount.userName = userName;
            userAccount.emailAddress = emailAddress;
            userAccount.password = ONE_TIME_PASSWORD;
            userAccount.oneTimePassword = true;

            emailSystem.sendPasswordEmail(userAccount, KindsOfEmail.NEW_ACCOUNT);
        } catch (UserAuthenticationException e) {
            presenter.showError(e.errorCode.toString());

        }
    }
}
