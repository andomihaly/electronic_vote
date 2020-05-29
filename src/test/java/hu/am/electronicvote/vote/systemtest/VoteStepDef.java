package hu.am.electronicvote.vote.systemtest;

import hu.am.electronicvote.vote.entity.Answer;
import hu.am.electronicvote.vote.entity.Question;
import hu.am.electronicvote.vote.systemtest.common.KnownVoteObject;
import io.cucumber.java.hu.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class VoteStepDef {
    private KnownVoteObject helper = new KnownVoteObject();

    private List<Answer> voteWithInvalidAnswer;

    @Amennyiben("folyamatban van a választás")
    public void electionIsOngoing() {
        assertTrue(helper.election.isOngoing());
    }

    @Amennyiben("elmegyek szavazni")
    public void iGoToVote() {

    }

    @És("sikeresen azonosítom magam")
    public void iIdentifyMyselfSuccessfully() {
        assertTrue(helper.userManagement.isLoggedIn(helper.validUser.sessionId));
        assertTrue(helper.userManagement.hasRightToVote(helper.validUser));
    }

    @Majd("megkapom a körzetemnek megfelelő kérdőívet")
    public void iGetQuestionnaireRelatedToMyDistrict() {
        assertNotNull(helper.election.getQuestionnaire());
    }

    @Akkor("leadom a szavazatomat")
    public void iVote() {
        helper.election.vote(helper.validUser, Arrays.asList(helper.validAnswer));
        assertTrue(helper.election.isVoted(helper.validUser));
    }

    @De("nem tudom magam azonosítani")
    public void iCantIdentifyMyself() {
        assertFalse(helper.userManagement.isLoggedIn(helper.invalidUser.sessionId));
    }

    @Akkor("nem tudok szavazni")
    public void iCantVote() {
        assertFalse(helper.election.isVoted(helper.invalidUser));
        helper.election.vote(helper.invalidUser, Arrays.asList(helper.validAnswer));
        assertFalse(helper.userManagement.isLoggedIn(helper.invalidUser.sessionId));
        assertFalse(helper.election.isVoted(helper.invalidUser));
        assertEquals("INVALID_USER", helper.spyPresenter.lastErrorMessage);
    }

    @És("érvénytelen választ akarok leadni")
    public void iWantAddInvalidAnswer() {
        assertFalse(helper.election.isVoted(helper.validUser));
        Answer invalidAnswer = new Answer(new Question(), Answer.INVALID_ANSWER);
        voteWithInvalidAnswer = Arrays.asList(invalidAnswer, helper.validAnswer);
    }

    @Akkor("érvénytelen választ adtam le")
    public void iAddedInvalidAnswer() {
        assertFalse(helper.election.isVoted(helper.validUser));
        helper.election.vote(helper.validUser, voteWithInvalidAnswer);
        assertTrue(helper.election.isVoted(helper.validUser));
    }

    @Amennyiben("egyszer már szavaztam")
    public void iHaveAlreadyVoted() {
        assertFalse(helper.election.isVoted(helper.validUser));
        helper.election.vote(helper.validUser, Arrays.asList(helper.validAnswer));
        assertTrue(helper.election.isVoted(helper.validUser));
    }

    @Majd("elmegyek újra szavazni")
    public void iGoToVoteAgain() {

    }

    @Akkor("nem szavazhatok újra")
    public void iCantVoteAgain() {
        assertTrue(helper.election.isVoted(helper.validUser));
        helper.election.vote(helper.validUser, Arrays.asList(helper.validAnswer));
        assertEquals("DOUBLED_VOTE", helper.spyPresenter.lastErrorMessage);
    }

    @Akkor("kérdésenként csak egyet választhatok")
    public void iCanChooseOnlyOnePerQuestion() {
        helper.election.vote(helper.validUser, Arrays.asList(helper.validAnswer, helper.validAnswer));
        assertEquals("MULTIPLE_ANSWER", helper.spyPresenter.lastErrorMessage);
        assertFalse(helper.election.isVoted(helper.validUser));
    }

    @Majd("félbehagyom a szavazást")
    public void iMakeAnUnfinishedVoting() {

    }

    @Akkor("még szavazhatok")
    public void iCanStillVote() {
        assertFalse(helper.election.isVoted(helper.validUser));
    }

    @De("fiatal vagyok")
    public void iAmYoung() {
        helper.validUser.birthDate = LocalDate.now().minusYears(18).plusDays(1);
    }

    @Akkor("nem szavazhatok")
    public void iCannotVote() {
        assertFalse(helper.userManagement.hasRightToVote(helper.validUser));
    }

}
