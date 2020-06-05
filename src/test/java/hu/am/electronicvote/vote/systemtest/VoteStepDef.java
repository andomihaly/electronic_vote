package hu.am.electronicvote.vote.systemtest;

import hu.am.electronicvote.vote.entity.Answer;
import hu.am.electronicvote.vote.entity.Question;
import hu.am.electronicvote.vote.systemtest.common.KnownVoteObject;
import io.cucumber.java.hu.*;

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
        assertTrue(helper.userManagement.isLoggedIn(KnownVoteObject.VALID_USER_SESSIONID));
        assertTrue(helper.userManagement.hasRightToVote(KnownVoteObject.VALID_USER_SESSIONID));
    }

    @Majd("megkapom a körzetemnek megfelelő kérdőívet")
    public void iGetQuestionnaireRelatedToMyDistrict() {
        assertNotNull(helper.election.getQuestionnaire());
    }

    @Akkor("leadom a szavazatomat")
    public void iVote() {
        String validUserId = helper.userManagement.getUserIdBySessionId(KnownVoteObject.VALID_USER_SESSIONID);
        helper.election.vote(validUserId, Arrays.asList(helper.validAnswer));
        assertTrue(helper.election.isVoted(validUserId));
    }

    @De("nem tudom magam azonosítani")
    public void iCantIdentifyMyself() {
        assertFalse(helper.userManagement.isLoggedIn(KnownVoteObject.INVALID_USER_SESSIONID));
    }

    @Akkor("nem tudok szavazni")
    public void iCantVote() {
        String invalidUserId = helper.userManagement.getUserIdBySessionId(KnownVoteObject.INVALID_USER_SESSIONID);
        assertFalse(helper.election.isVoted(invalidUserId));
        helper.election.vote(invalidUserId, Arrays.asList(helper.validAnswer));
        assertFalse(helper.userManagement.isLoggedIn(KnownVoteObject.INVALID_USER_SESSIONID));
        assertFalse(helper.election.isVoted(KnownVoteObject.INVALID_USER_SESSIONID));
        assertEquals("INVALID_USER", helper.spyPresenter.lastErrorMessage);
    }

    @És("érvénytelen választ akarok leadni")
    public void iWantAddInvalidAnswer() {
        String validUserId = helper.userManagement.getUserIdBySessionId(KnownVoteObject.VALID_USER_SESSIONID);
        assertFalse(helper.election.isVoted(validUserId));
        Answer invalidAnswer = new Answer(new Question(), Answer.INVALID_ANSWER);
        voteWithInvalidAnswer = Arrays.asList(invalidAnswer, helper.validAnswer);
    }

    @Akkor("érvénytelen választ adtam le")
    public void iAddedInvalidAnswer() {
        String validUserId = helper.userManagement.getUserIdBySessionId(KnownVoteObject.VALID_USER_SESSIONID);
        assertFalse(helper.election.isVoted(validUserId));
        helper.election.vote(validUserId, voteWithInvalidAnswer);
        assertTrue(helper.election.isVoted(validUserId));
    }

    @Amennyiben("egyszer már szavaztam")
    public void iHaveAlreadyVoted() {
        String validUserId = helper.userManagement.getUserIdBySessionId(KnownVoteObject.VALID_USER_SESSIONID);
        assertFalse(helper.election.isVoted(validUserId));
        helper.election.vote(validUserId, Arrays.asList(helper.validAnswer));
        assertTrue(helper.election.isVoted(validUserId));
    }

    @Majd("elmegyek újra szavazni")
    public void iGoToVoteAgain() {

    }

    @Akkor("nem szavazhatok újra")
    public void iCantVoteAgain() {
        String validUserId = helper.userManagement.getUserIdBySessionId(KnownVoteObject.VALID_USER_SESSIONID);
        assertTrue(helper.election.isVoted(validUserId));
        helper.election.vote(validUserId, Arrays.asList(helper.validAnswer));
        assertEquals("DOUBLED_VOTE", helper.spyPresenter.lastErrorMessage);
    }

    @Akkor("kérdésenként csak egyet választhatok")
    public void iCanChooseOnlyOnePerQuestion() {
        String validUserId = helper.userManagement.getUserIdBySessionId(KnownVoteObject.VALID_USER_SESSIONID);
        helper.election.vote(validUserId, Arrays.asList(helper.validAnswer, helper.validAnswer));
        assertEquals("MULTIPLE_ANSWER", helper.spyPresenter.lastErrorMessage);
        assertFalse(helper.election.isVoted(validUserId));
    }

    @Majd("félbehagyom a szavazást")
    public void iMakeAnUnfinishedVoting() {

    }

    @Akkor("még szavazhatok")
    public void iCanStillVote() {
        String validUserId = helper.userManagement.getUserIdBySessionId(KnownVoteObject.VALID_USER_SESSIONID);
        assertFalse(helper.election.isVoted(validUserId));
    }

    @De("fiatal vagyok")
    public void iAmYoung() {
    }

    @Akkor("nem szavazhatok")
    public void iCannotVote() {
        assertFalse(helper.userManagement.hasRightToVote(KnownVoteObject.YOUNG_USER_SESSIONID));
    }

}
