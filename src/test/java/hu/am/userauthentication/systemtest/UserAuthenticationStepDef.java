package hu.am.userauthentication.systemtest;

import io.cucumber.java.hu.*;

import static org.junit.Assert.assertTrue;

public class UserAuthenticationStepDef {

    @Amennyiben("új felhasználói fiók felvételét indítom {}")
    public void iStartAddingNewUserAccountWithSomeKindOfInput(String kindOfInput) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Akkor("(a rendszer )a megadott email címre elküld egy új, egyszerhasználatos jelszót")
    public void theSystemSendsAnEmailToTheGivenAddressWithPasswordForOneUse() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Akkor("a rendszer jelzést küld {}")
    public void theSystemSendAnAlert(String about) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Amennyiben("jelzem a rendszernek, hogy elfelejtettem a jelszavamat")
    public void iIndicateIForgotMyPassword() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @És("megadom az érvényes felhasználónevemet")
    public void iEnterMyValidUserName() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @És("a bejelentkezéshez megadom a felhasználónevemet")
    public void iEnterMyUserNameForLogin() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @És("érvénytelen felhasználónevet adok meg")
    public void iEnterAnInvalidUserName() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @De("nem küld el semmilyen emailt")
    public void itSendNoEmail() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @De("kezdeményezek egy jelszócserét")
    public void iInitiateAPasswordChange() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @És("megadom a(z) {} jelszavamat")
    public void iEnterMyPassword(String kindOfPassword) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @És("megadom kétszer ugyanazt az új jelszót, amely {int} hosszú")
    public void iEnterTwiceTheSameNewPasswordWithTheGivenLength(int length) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @És("érvénytelen aktuális jelszót adok meg")
    public void iEnterInvalidActualPassword() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @És("sikeres lesz az azonosítás")
    public void authenticationIsSuccessful() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @És("sikertelen lesz az azonosítás")
    public void authenticationIsUnsuccessful() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
