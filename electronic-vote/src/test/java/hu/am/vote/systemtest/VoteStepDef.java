package hu.am.vote.systemtest;

import am.vote.entity.Answer;
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
        helper.election.vote(Arrays.asList(new Answer()));
        assertTrue(helper.election.isVoted(helper.validUser));
    }

    @De("nem tudom magam azonosítani")
    public void iCantIdentifyMyself() {
        assertFalse(helper.authentication.isAuthenticated(helper.invalidUser));
    }

    @Akkor("nem tudok szavazni")
    public void iCantVote() {
        assertFalse(helper.authentication.canVoted(helper.invalidUser));
    }

    @És("érvénytelen választ akarok leadni")
    public void iWantAddInvalidAnswer() {
        Answer invalidAnswer = new Answer();
        invalidAnswer.answer = Answer.INVALID_ANSWER;
        helper.election.vote(Arrays.asList(invalidAnswer));
    }

    @Akkor("érvénytelen választ adtam le")
    public void iAddedInvalidAnswer() {
        List<Answer> vote = helper.election.getVote(helper.validUser);
        assertTrue(helper.election.isVoted(helper.validUser));
        assertTrue(
            vote.stream().anyMatch(answer ->
                    answer.answer.equalsIgnoreCase(Answer.INVALID_ANSWER)));
    }

    @Amennyiben("egyszer már szavaztam")
    public void iHaveAlreadyVoted() {
        assertTrue(helper.election.isVoted(helper.validUser));
    }

    @Majd("elmegyek újra szavazni")
    public void iGoToVoteAgain() {
    	
    }

    @Akkor("nem szavazhatok újra")
    public void iCantVoteAgain() {
        assertFalse(helper.authentication.canVoted(helper.validUser));
    }

    @Akkor("kérdésenként csak egyet választhatok")
    public void iCanChooseOnlyOnePerQuestion() {
        throw new PendingException();
    }

    @Majd("félbehagyom a szavazást")
    public void iMakeAnUnfinishedVoting() {
        throw new PendingException();
    }

    @Akkor("még szavazhatok")
    public void iCanStillVote() {
        throw new PendingException();
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
