package hu.am.authentication.systemtest.common;

import hu.am.authentication.fakeauthenticationsystem.FakeAuthentication;
import hu.am.vote.Authentication;
import hu.am.vote.UserManagement;
import hu.am.vote.entity.User;
import hu.am.vote.fakevotingsystem.FakeUserManagement;

import java.time.LocalDate;

public class KnownAuthenticationObject {
    public Authentication authentication = new FakeAuthentication();

}
