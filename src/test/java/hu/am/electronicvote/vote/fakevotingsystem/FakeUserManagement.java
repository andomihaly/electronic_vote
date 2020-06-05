package hu.am.electronicvote.vote.fakevotingsystem;

import hu.am.electronicvote.vote.UserManagement;
import hu.am.electronicvote.vote.systemtest.common.KnownVoteObject;

import java.time.LocalDate;

public class FakeUserManagement implements UserManagement {
    public boolean isLoggedIn(String userSessionId) {
        return userSessionId.equals("Valid User SID");
    }

    private LocalDate getBirthDate(String userSessionId) {
        if (KnownVoteObject.YOUNG_USER_SESSIONID.equals(userSessionId)) {
            return LocalDate.now().minusYears(18).plusDays(1);
        }
        return LocalDate.now().minusYears(20);
    }

    public boolean hasRightToVote(String userSessionId) {
        return !getBirthDate(userSessionId).isAfter(LocalDate.now().minusYears(18));
    }

    @Override
    public String getUserIdBySessionId(String userSessionId) {
        return userSessionId.replace("SID", "ID");
    }
}
