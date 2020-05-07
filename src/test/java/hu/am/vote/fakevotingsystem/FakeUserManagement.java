package hu.am.vote.fakevotingsystem;

import hu.am.vote.UserManagement;
import hu.am.vote.entity.User;

import java.time.LocalDate;

public class FakeUserManagement implements UserManagement {
    public boolean isLoggedIn(User user) {
        return user.name.equals("Valid User");
    }

    public boolean hasRightToVote(User user) {
        if (user.birthDate.isAfter(LocalDate.now().minusYears(18))) return false;
        return true;
    }
}
