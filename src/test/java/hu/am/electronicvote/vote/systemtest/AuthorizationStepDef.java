package hu.am.electronicvote.vote.systemtest;

import hu.am.electronicvote.vote.fakevotingsystem.FakeAuthorizationInvalidUser;
import hu.am.electronicvote.vote.fakevotingsystem.FakeTimeAuthorization;
import hu.am.electronicvote.vote.systemtest.common.KnownVoteObject;
import io.cucumber.java.hu.Akkor;
import io.cucumber.java.hu.Amennyiben;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class AuthorizationStepDef {
    private KnownVoteObject helper = new KnownVoteObject();

    @Amennyiben("megadom a helyes felhasználónév-jelszó párosom")
    public void iGiveMyRightUsernameAndPassword() {
        helper.authorization.loginWithPassword();
    }

    @Akkor("be vagyok jelentkezve a rendszerbe")
    public void iLoggedIntoTheSystem() {
        String sessionId = helper.spyAuthorizationConnector.sessionId;
        Assert.assertTrue(helper.userManagement.isLoggedIn(sessionId));
    }

    @Amennyiben("kártyaolvasóval beolvasom az eSzemélyim")
    public void cardReaderReadMyEIdentityCard() {
        helper.authorization.loginWithEIdentityCard();
    }

    @Amennyiben("megadom a helyes PIN kódomat")
    public void iGiveMyRightPinCode() {

    }

    @Amennyiben("nem helyes felhasználónév-jelszó párost adok meg")
    public void iGiveIncorrectUsernameAndPassword() {
        helper.authorization = new FakeAuthorizationInvalidUser(helper.spyAuthorizationConnector);
        helper.authorization.loginWithPassword();
    }

    @Akkor("nem vagyok bejelentkezve a rendszerbe")
    public void iNotLoggedIntoTheSystem() {
        String sessionId = helper.spyAuthorizationConnector.sessionId;
        Assert.assertFalse(helper.userManagement.isLoggedIn(sessionId));
    }

    @Akkor("értesítést kapok a sikertelen bejelentkezésről")
    public void iGetNotificationAboutUnsuccessfulLogin() {
        assertTrue(helper.spyAuthorizationConnector.lastErrorMessage.contains("NOT_LOGGED_IN_USER"));
    }

    @Amennyiben("nem sikerül azonosítanom magam eSzemélyivel")
    public void unsuccessfulAuthorizationWithEIdentificationCard() {
        helper.authorization = new FakeAuthorizationInvalidUser(helper.spyAuthorizationConnector);
        helper.authorization.loginWithEIdentityCard();
    }

    @Amennyiben("3-szor helytelen jelszót adok meg a felhasználónevemhez")
    public void iGiveIncorrectPasswordThreeTimes() {
        helper.authorization = new FakeTimeAuthorization(helper.spyAuthorizationConnector);
        for (int i = 0; i < 3; i++) {
            helper.authorization.loginWithPassword();
            Assert.assertTrue(helper.spyAuthorizationConnector.lastErrorMessage.contains("NOT_LOGGED_IN_USER"));
        }
    }

    @Amennyiben("4-szer helytelen jelszót adok meg a felhasználónevemhez")
    public void iGiveIncorrectPasswordFourTimes() {
        ((FakeTimeAuthorization) helper.authorization).lockingTriesLimit += 4;
        for (int i = 0; i < 4; i++) {
            helper.authorization.loginWithPassword();
            Assert.assertTrue(helper.spyAuthorizationConnector.lastErrorMessage.contains("NOT_LOGGED_IN_USER"));
        }
    }

    @Akkor("10 percig nem tudok bejelentkezni a helyes jelszóval sem")
    public void iCantLoginWithTheCorrectPasswordDuringGivenMinutes() {
        helper.authorization.loginWithPassword();
    }

    @Akkor("értesítést kapok, hogy 10 percig nem jelentkezhetek be")
    public void iGetNotification10MinutesMessage() {
        Assert.assertTrue(helper.spyAuthorizationConnector.lastErrorMessage.contains("NOT_LOGGED_IN_USER_BECAUSE_OF_USER_LOCK_FOR_SHORT_TIME"));
    }

    @Amennyiben("rövid időre le voltam tiltva")
    public void iWasBannedForShortTime() {
        iGiveIncorrectPasswordThreeTimes();
    }

    @Amennyiben("letelt a rövid idejű tiltás")
    public void afterShortTimeBanned() {
        FakeTimeAuthorization faiu = (FakeTimeAuthorization) helper.authorization;
        faiu.lockingTime = faiu.lockingTime.minusMinutes(20);
    }

    @Akkor("2 óráig nem tudok bejelentkezni a helyes jelszóval sem")
    public void iCantLoginWithTheCorrectPasswordDuringGivenHours() {
        helper.authorization.loginWithPassword();
    }

    @Akkor("értesítést kapok, hogy 2 óráig nem jelentkezhetek be")
    public void iGetNotification2HoursMessage() {
        Assert.assertTrue(helper.spyAuthorizationConnector.lastErrorMessage.contains("NOT_LOGGED_IN_USER_BECAUSE_OF_USER_LOCK_FOR_LONG_TIME"));
    }

    @Amennyiben("hosszú időre le voltam tiltva")
    public void iWasBannedForLongTime() {
        iGiveIncorrectPasswordThreeTimes();
        iGiveIncorrectPasswordFourTimes();
    }

    @Amennyiben("letelt a hosszú idejű tiltás")
    public void afterLongTimeBanned() {
        FakeTimeAuthorization faiu = (FakeTimeAuthorization) helper.authorization;
        faiu.lockingTime = faiu.lockingTime.minusHours(2);
    }

    @Akkor("személyes azonosításig nem tudok bejelentkezni a helyes jelszóval sem")
    public void iCantLoginWithTheCorrectPasswordUntilPersonalAuthorization() {
        helper.authorization.loginWithPassword();
    }

    @Akkor("értesítést kapok, hogy személyes azonosításig nem jelentkezhetek be")
    public void iGetNotificationPersonalAuthenticationMessage() {
        Assert.assertTrue(helper.spyAuthorizationConnector.lastErrorMessage.contains("NOT_LOGGED_IN_USER_BECAUSE_OF_USER_LOCK_FOR_PERSONAL_AUTHENTICATION"));
    }
}
