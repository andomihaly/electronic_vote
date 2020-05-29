package hu.am.electronicvote.vote.systemtest;

import hu.am.electronicvote.vote.entity.User;
import hu.am.electronicvote.vote.systemtest.common.KnownVoteObject;
import io.cucumber.java.hu.Akkor;
import io.cucumber.java.hu.Amennyiben;

import static org.junit.Assert.assertTrue;

public class AuthenticationStepDef {
    private KnownVoteObject helper = new KnownVoteObject();
    private User user;

    @Amennyiben("megadom a helyes felhasználónév-jelszó párosom")
    public void iGiveMyRightUsernameAndPassword() {
        user = helper.authentication.loginWithPassword();
    }

    @Akkor("be vagyok jelentkezve a rendszerbe")
    public void iLoggedIntoTheSystem() {
        helper.userManagement.isLoggedIn(user);
    }

    @Amennyiben("kártyaolvasóval beolvasom az eSzemélyim")
    public void cardReaderReadMyEIdentityCard() {
        user = helper.authentication.loginWithEIdentityCard();
    }
    @Amennyiben("megadom a helyes PIN kódomat")
    public void iGiveMyRightPinCode() {

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
