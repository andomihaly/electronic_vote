package hu.am.vote.fakevotingsystem;

import hu.am.vote.Authentication;
import hu.am.vote.entity.User;

import java.time.LocalDate;

public class FakeAuthentication implements Authentication {
    public boolean isAuthenticated(User user) {
        return user.name.equals("Valid User");
    }

    public boolean hasRightToVote(User user) {
        if (user.birthDate.isAfter(LocalDate.now().minusYears(18))) return false;
        return true;
    }

    public boolean login(String name, String password) {
        return true;
    }

}
