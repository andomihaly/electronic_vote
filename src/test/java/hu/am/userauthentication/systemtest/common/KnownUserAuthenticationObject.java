package hu.am.userauthentication.systemtest.common;

import hu.am.userauthentication.UserAuthentication;
import hu.am.userauthentication.fakeuserauthentication.FakeUserAuthentication;
import hu.am.userauthentication.fakeuserauthentication.SpyEmailSystem;
import hu.am.userauthentication.fakeuserauthentication.SpyUserAuthenticationPresenter;

public class KnownUserAuthenticationObject {
    public static final String VALID_NEW_USER_NAME = "Valid new User Name";
    public static final String VALID_USER_NAME = "Valid User Name";
    public static final String RESERVED_USER_NAME = "Existing User Name";
    public static final String NON_EXISTENT_USER_NAME = "Non-existent User Name";
    public static final String VALID_EMAIL_ADDRESS = "Valid Email Address";
    public static final String INVALID_EMAIL_ADDRESS = "Invalid Email Address";

    public SpyEmailSystem spyEmailSystem = new SpyEmailSystem();
    public SpyUserAuthenticationPresenter spyPresenter = new SpyUserAuthenticationPresenter();
    public UserAuthentication userAuthentication = new FakeUserAuthentication(spyPresenter, spyEmailSystem);


}
