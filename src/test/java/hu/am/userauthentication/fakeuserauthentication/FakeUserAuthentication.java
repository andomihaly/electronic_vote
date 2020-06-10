package hu.am.userauthentication.fakeuserauthentication;

import hu.am.userauthentication.EmailSystem;
import hu.am.userauthentication.UserAuthentication;
import hu.am.userauthentication.UserAuthenticationPresenter;
import hu.am.userauthentication.entity.KindsOfEmail;
import hu.am.userauthentication.entity.UserAccount;
import hu.am.userauthentication.exception.*;
import hu.am.userauthentication.systemtest.common.KnownUserAuthenticationObject;

import javax.xml.validation.Validator;

public class FakeUserAuthentication implements UserAuthentication {
    public static final String ONE_TIME_PASSWORD = "ONE_TIME_PASSWORD";
    public static final String VALID_PASSWORD = "VALID_PASSWORD";
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
            if (userName.equals(KnownUserAuthenticationObject.RESERVED_USER_NAME)) {
                throw new ReservedUserNameException();
            }

            userAccount = new UserAccount();
            userAccount.userName = userName;
            userAccount.emailAddress = emailAddress;
            if (KnownUserAuthenticationObject.VALID_NEW_USER_NAME.equals(userName)) {
                userAccount.password = ONE_TIME_PASSWORD;
                userAccount.isOneTimePassword = true;

                emailSystem.sendPasswordEmail(userAccount, KindsOfEmail.NEW_ACCOUNT_EMAIL);
            } else {
                userAccount.password = VALID_PASSWORD;
                userAccount.isOneTimePassword = false;
            }
        } catch (UserAuthenticationException e) {
            presenter.showErrorMessage(e.errorCode.toString());

        }
    }

    @Override
    public void indicateForgotPassword(String userName) {
        try {
            presenter.showUserMessage(MessageCode.EMAIL_ABOUT_ONE_TIME_PASSWORD_HAS_BEEN_SEND.toString());
            if (!userName.equals(userAccount.userName)) {
                throw new NonExistentUserNameException();
            }
            userAccount.password = ONE_TIME_PASSWORD;
            userAccount.isOneTimePassword = true;

            emailSystem.sendPasswordEmail(userAccount, KindsOfEmail.FORGOT_PASSWORD_EMAIL);
        } catch (UserAuthenticationException e) {
            //ToDo Nincs mit írni a Presenter-be. Menjen a log-ba egy üzenet?
        }
    }

}
