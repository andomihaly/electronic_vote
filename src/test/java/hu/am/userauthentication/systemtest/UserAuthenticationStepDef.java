package hu.am.userauthentication.systemtest;

import hu.am.userauthentication.entity.KindsOfEmail;
import hu.am.userauthentication.exception.ErrorCode;
import hu.am.userauthentication.exception.MessageCode;
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
                helper.userAuthentication.addAccount(VALID_NEW_USER_NAME, VALID_EMAIL_ADDRESS);
                break;
            case "hibás email címmel":
                helper.userAuthentication.addAccount(VALID_NEW_USER_NAME, INVALID_EMAIL_ADDRESS);
                break;
            case "már létező felhasználónévvel":
                helper.userAuthentication.addAccount(RESERVED_USER_NAME, VALID_EMAIL_ADDRESS);
                break;
            default:
                Assert.fail();
        }
    }

    @Akkor("(a rendszer )a megadott email címre elküldi {} szóló emailt")
    public void theSystemSendsAnEmailToTheGivenAddress(String kindOfEmail) {
        Assert.assertEquals(VALID_EMAIL_ADDRESS, helper.spyEmailSystem.userAccount.emailAddress);
        switch (kindOfEmail) {
            case "az új fiók felvételéről":
                Assert.assertEquals(VALID_NEW_USER_NAME, helper.spyEmailSystem.userAccount.userName);
                Assert.assertEquals(KindsOfEmail.NEW_ACCOUNT_EMAIL, helper.spyEmailSystem.subject);
                break;
            case "az elfelejtett jelszó miatti jelszócseréről":
                Assert.assertEquals(VALID_USER_NAME, helper.spyEmailSystem.userAccount.userName);
                Assert.assertEquals(KindsOfEmail.FORGOT_PASSWORD_EMAIL, helper.spyEmailSystem.subject);
                break;
        }
    }

    @Akkor("benne egy új, egyszerhasználatos jelszót")
    public void isThereANewOneTimePasswordInIt() {
        Assert.assertEquals(FakeUserAuthentication.ONE_TIME_PASSWORD, helper.spyEmailSystem.userAccount.password);
        Assert.assertTrue(helper.spyEmailSystem.userAccount.isOneTimePassword);
    }

    @Akkor("a rendszer jelzést küld {}")
    public void theSystemSendAnAlert(String about) {
        switch (about) {
            case "a hibás email címről":
                Assert.assertEquals(ErrorCode.INVALID_EMAIL.toString(),
                        helper.spyPresenter.lastErrorMessage);
                break;
            case "a foglalt felhasználónévről":
                Assert.assertEquals(ErrorCode.RESERVED_USER_NAME.toString(),
                        helper.spyPresenter.lastErrorMessage);
                break;
            case "arról, hogy elküldi az emailt":
                Assert.assertEquals(MessageCode.EMAIL_ABOUT_ONE_TIME_PASSWORD_HAS_BEEN_SEND.toString(),
                        helper.spyPresenter.lastUserMessage);
                break;
            default:
                Assert.fail();
        }
    }

    @Amennyiben("jelzem a rendszernek, hogy elfelejtettem a jelszavamat")
    public void iIndicateIForgotMyPassword() {
        helper.userAuthentication.addAccount(VALID_USER_NAME, VALID_EMAIL_ADDRESS);
    }

    @És("megadom az érvényes felhasználónevemet")
    public void iEnterMyValidUserName() {
        helper.userAuthentication.indicateForgotPassword(VALID_USER_NAME);
    }

    @És("a bejelentkezéshez megadom a felhasználónevemet")
    public void iEnterMyUserNameForLogin() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @És("érvénytelen felhasználónevet adok meg")
    public void iEnterAnInvalidUserName() {
        helper.userAuthentication.indicateForgotPassword(NON_EXISTENT_USER_NAME);
    }

    @De("nem küld el semmilyen emailt")
    public void itSendNoEmail() {
        Assert.assertNull(helper.spyEmailSystem.subject);
        Assert.assertNull(helper.spyEmailSystem.userAccount);
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
