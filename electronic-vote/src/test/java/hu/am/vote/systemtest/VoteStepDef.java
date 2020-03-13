package hu.am.vote.systemtest;

import am.vote.entity.Answer;
import hu.am.vote.systemtest.common.KnownVoteObject;
import io.cucumber.java.PendingException;
import io.cucumber.java.hu.*;

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
        helper.election.vote(new Answer());
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

    @És("érvénytelen szavazatot akarok leadni")
    public void iWantAddInvalidVote() {
        throw new PendingException();
    }

    @Akkor("érvénytelen szavazatot adtam le")
    public void iAddedInvalidVote() {
        throw new PendingException();
    }

    @Amennyiben("egyszer már szavaztam")
    public void iHaveAlreadyVoted() {
        throw new PendingException();
    }

    @Majd("elmegyek újra szavazni")
    public void iGoToVoteAgain() {
        throw new PendingException();
    }

    @Akkor("nem szavazhatok újra")
    public void iCantVoteAgain() {
        throw new PendingException();
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
