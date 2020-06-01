package hu.am.userauthentication.systemtest;

import hu.am.userauthentication.entity.KindsOfEmail;
import hu.am.userauthentication.exception.ErrorCode;
import hu.am.userauthentication.fakeuserauthentication.FakeUserAuthentication;
import hu.am.userauthentication.systemtest.common.KnownUserAuthenticationObject;
import io.cucumber.java.hu.Akkor;
import io.cucumber.java.hu.Amennyiben;
import io.cucumber.java.hu.De;
import io.cucumber.java.hu.És;
import org.junit.Assert;

import static hu.am.userauthentication.systemtest.common.KnownUserAuthenticationObject.*;

public class UserAuthenticationStepDef {

    private KnownUserAuthenticationObject helper = new KnownUserAuthenticationObject();

    @Amennyiben("új felhasználói fiók felvételét indítom {}")
    public void iStartAddingNewUserAccountWithSomeKindOfInput(String kindOfInput) {
        switch (kindOfInput) {
            case "egy megfelelő email cím és egy egyedi felhasználónév megadásával":
                helper.userAuthentication.addAccount(UNIQUE_USER_NAME, VALID_EMAIL_ADDRESS);
                break;
            case "hibás email címmel":
                helper.userAuthentication.addAccount(UNIQUE_USER_NAME, INVALID_EMAIL_ADDRESS);
                break;
            case "már létező felhasználónévvel":
                // helper.userAuthentication.addAccount(UNIQUE_USER_NAME, VALID_EMAIL_ADDRESS);
            default:
                Assert.fail();
        }
    }

    @Akkor("(a rendszer )a megadott email címre elküld egy új, egyszerhasználatos jelszót")
    public void theSystemSendsAnEmailToTheGivenAddressWithPasswordForOneUse() {
        Assert.assertEquals(UNIQUE_USER_NAME, helper.spyEmailSystem.userAccount.userName);
        Assert.assertEquals(VALID_EMAIL_ADDRESS, helper.spyEmailSystem.userAccount.emailAddress);
        Assert.assertEquals(FakeUserAuthentication.ONE_TIME_PASSWORD, helper.spyEmailSystem.userAccount.password);
        Assert.assertTrue(helper.spyEmailSystem.userAccount.oneTimePassword);
        Assert.assertEquals(KindsOfEmail.NEW_ACCOUNT, helper.spyEmailSystem.subject);
    }

    @Akkor("a rendszer jelzést küld {}")
    public void theSystemSendAnAlert(String about) {
        switch (about) {
            case "a hibás email címről":
                Assert.assertEquals(ErrorCode.INVALID_EMAIL.toString(), helper.spyPresenter.lastErrorMessage);
                break;
            case "":
                // Assert.assertEquals(ErrorCode.INVALID_EMAIL.toString(), helper.spyPresenter.lastErrorMessage);
                break;
            default:
                Assert.fail();
        }
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
