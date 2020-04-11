package hu.am.vote.systemtest;

import am.vote.entity.Answer;
import am.vote.entity.Question;
import hu.am.vote.systemtest.common.KnownVoteObject;
import io.cucumber.java.PendingException;
import io.cucumber.java.hu.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class VoteStepDef {
    KnownVoteObject helper = new KnownVoteObject();

    @Amennyiben("folyamatban van a választás")
    public void electionIsOngoing() {
        assertTrue(helper.election.isStarted());
    }

    @Amennyiben("elmegyek szavazni")
    public void iGoToVote() {

    }

    @És("sikeresen azonosítom magam")
    public void iIdentifyMyselfSuccessfully() {
        assertTrue(helper.authentication.isAuthenticated(helper.validUser));
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
        assertFalse(helper.authentication.isAuthenticated(helper.invalidUser));
    }

    @Akkor("nem tudok szavazni")
    public void iCantVote() {
        assertFalse(helper.election.isVoted(helper.invalidUser));
        helper.election.vote(helper.invalidUser, Arrays.asList(helper.validAnswer));
        assertFalse(helper.authentication.hasRightToVote(helper.invalidUser));
        assertFalse(helper.election.isVoted(helper.invalidUser));
        assertEquals("-2", helper.spyPresenter.lastErrorMessage);
    }

    @És("érvénytelen választ akarok leadni")
    public void iWantAddInvalidAnswer() {
        assertFalse(helper.election.isVoted(helper.validUser));

        Answer invalidAnswer = new Answer(new Question(), Answer.INVALID_ANSWER);
        helper.election.vote(helper.validUser, Arrays.asList(invalidAnswer));
    }

    @Akkor("érvénytelen választ adtam le")
    public void iAddedInvalidAnswer() {
        //FIXME: Szerintem nem szabadna tudni ki, milyen szavazatot adott le!
        List<Answer> vote = helper.election.getVote(helper.validUser);
        assertTrue(helper.election.isVoted(helper.validUser));
        assertTrue(
                vote.stream().anyMatch(answer ->
                        answer.choice == Answer.INVALID_ANSWER));
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
        assertEquals("-1", helper.spyPresenter.lastErrorMessage);
    }

    @Akkor("kérdésenként csak egyet választhatok")
    public void iCanChooseOnlyOnePerQuestion() {
        helper.election.vote(helper.validUser, Arrays.asList(helper.validAnswer, helper.validAnswer));
        assertEquals("-3", helper.spyPresenter.lastErrorMessage);
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
        throw new PendingException();
    }

    @Akkor("nem szavazhatok")
    public void iCannotVote() {
        throw new PendingException();
    }

}
