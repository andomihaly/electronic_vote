package hu.am.userauthentication.systemtest.common;

import hu.am.userauthentication.UserAuthentication;
import hu.am.userauthentication.fakeuserauthentication.FakeUserAuthentication;
import hu.am.userauthentication.fakeuserauthentication.SpyEmailSystem;
import hu.am.userauthentication.fakeuserauthentication.SpyUserAuthenticationPresenter;

public class KnownUserAuthenticationObject {
    public static final String UNIQUE_USER_NAME = "Unique User Name";
    public static final String VALID_EMAIL_ADDRESS = "Valid Email Address";
    public static final String INVALID_EMAIL_ADDRESS = "Invalid Email Address";

    public SpyEmailSystem spyEmailSystem = new SpyEmailSystem();
    public SpyUserAuthenticationPresenter spyPresenter = new SpyUserAuthenticationPresenter();
    public UserAuthentication userAuthentication = new FakeUserAuthentication(spyPresenter, spyEmailSystem);


}
