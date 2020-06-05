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

    @Amennyiben("{int}-sz(.)r helytelen jelszót adok meg a felhasználónevemhez")
    public void iGiveIncorrectPasswordSeveralTimes(int numberOfTimes) {
        helper.authorization = new FakeTimeAuthorization(helper.spyAuthorizationConnector);
        for (int i = 0; i < numberOfTimes; i++) {
            helper.authorization.loginWithPassword();
            Assert.assertTrue(helper.spyAuthorizationConnector.lastErrorMessage.contains("NOT_LOGGED_IN_USER"));
        }
    }

    @Akkor("{int} percig nem tudok bejelentkezni a helyes jelszóval sem")
    public void iCantLoginWithTheCorrectPasswordDuringGivenMinutes(int numberOfMinutes) {
        helper.authorization.loginWithPassword();
    }

    @Akkor("értesítést kapok erről")
    public void iGetNotification() {
        Assert.assertTrue(helper.spyAuthorizationConnector.lastErrorMessage.contains("NOT_LOGGED_IN_USER_BECAUSE_OF_USER_LOCK"));
    }

    @Amennyiben("rövid időre le voltam tiltva")
    public void iWasBannedForShortTime() {
        iGiveIncorrectPasswordSeveralTimes(3);
    }

    @Amennyiben("letelt a rövid idejű tiltás")
    public void afterShortTimeBanned() {
        FakeTimeAuthorization faiu = (FakeTimeAuthorization) helper.authorization;
        faiu.lockingTime = faiu.lockingTime.minusMinutes(20);
    }

    @Akkor("{int} óráig nem tudok bejelentkezni a helyes jelszóval sem")
    public void iCantLoginWithTheCorrectPasswordDuringGivenHours(int numberOfHours) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Amennyiben("hosszú időre le voltam tiltva")
    public void iWasBannedForLongTime() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Amennyiben("letelt a hosszú idejű tiltás")
    public void afterLongTimeBanned() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Akkor("személyes azonosításig nem tudok bejelentkezni a helyes jelszóval sem")
    public void iCantLoginWithTheCorrectPasswordUntilPersonalAuthorization() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
