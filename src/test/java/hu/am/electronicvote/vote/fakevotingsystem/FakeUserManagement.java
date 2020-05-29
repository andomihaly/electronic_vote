package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.entity.User;
import hu.am.electronicvote.vote.UserManagement;

import java.time.LocalDate;

public class FakeUserManagement implements UserManagement {
    public boolean isLoggedIn(String sessionId) {
        return sessionId.equals("Valid User SID");
    }

    public boolean hasRightToVote(User user) {
        if (user.birthDate.isAfter(LocalDate.now().minusYears(18))) return false;
        return true;
    }
}
