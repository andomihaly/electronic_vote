package hu.am.vote.systemtest;

import hu.am.vote.systemtest.common.KnownVoteObject;
import io.cucumber.java.hu.Akkor;
import io.cucumber.java.hu.Amennyiben;

import static org.junit.Assert.assertTrue;

public class AuthenticationStepDef {
    private KnownVoteObject helper = new KnownVoteObject();

    @Amennyiben("megadom a helyes felhasználónév-jelszó párosom")
    public void iGiveMyRightUsernameAndPassword() {
        helper.authentication.login("Valid user name", "Valid password");
    }
    @Akkor("be vagyok jelentkezve a rendszerbe")
    public void iLoggedIntoTheSystem() {
        helper.userManagement.isLoggedIn(helper.validUser);
    }
    @Amennyiben("kártyaolvasóval beolvasom az eSzemélyim")
    public void cardReaderReadMyEIdentityCard() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Amennyiben("megadom a helyes PIN kódomat")
    public void iGiveMyRightPinCode() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Amennyiben("nem helyes felhasználónév-jelszó párost adok meg")
    public void iGiveIncorrectUsernameAndPassword() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Akkor("nem vagyok bejelentkezve a rendszerbe")
    public void iNotLoggedIntoTheSystem() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Akkor("értesítést kapok a sikertelen bejelentkezésről")
    public void iGetNotificationAboutUnsuccessfulLogin() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Amennyiben("nem sikerül azonosítanom magam eSzemélyivel")
    public void unsuccessfulAuthenticationWithEIdentificationCard() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Amennyiben("{int}-sz(.)r helytelen jelszót adok meg a felhasználónevemhez")
    public void iGiveIncorrectPasswordSeveralTimes(int numberOfTimes) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Akkor("{int} percig nem tudok bejelentkezni a helyes jelszóval sem")
    public void iCantLoginWithTheCorrectPasswordDuringGivenMinutes(int numberOfMinutes) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Akkor("értesítést kapok erről")
    public void iGetNotification() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Amennyiben("rövid időre le voltam tiltva")
    public void iWasBannedForShortTime() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Amennyiben("letelt a rövid idejű tiltás")
    public void afterShortTimeBanned() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
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
    public void iCantLoginWithTheCorrectPasswordUntilPersonalAuthentication() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
