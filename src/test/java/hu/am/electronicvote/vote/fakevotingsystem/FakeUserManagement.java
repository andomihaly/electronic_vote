package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.entity.User;
import hu.am.electronicvote.vote.UserManagement;

import java.time.LocalDate;

public class FakeUserManagement implements UserManagement {
    public boolean isLoggedIn(User user) {
        return user.sessionId.equals("Valid User");
    }

    public boolean hasRightToVote(User user) {
        if (user.birthDate.isAfter(LocalDate.now().minusYears(18))) return false;
        return true;
    }
}
