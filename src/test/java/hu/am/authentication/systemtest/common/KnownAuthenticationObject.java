package hu.am.authentication.systemtest.common;

import hu.am.authentication.fakeauthenticationsystem.FakeAuthentication;
import hu.am.authentication.Authentication;

public class KnownAuthenticationObject {
    public Authentication authentication = new FakeAuthentication();

}
