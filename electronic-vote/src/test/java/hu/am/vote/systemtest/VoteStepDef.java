package hu.am.vote.systemtest;

import io.cucumber.java.PendingException;
import io.cucumber.java.hu.*;

public class VoteStepDef {
    @Amennyiben("folyamatban van a választás")
    public void votingIsOngoing() {
        throw new PendingException();
    }

    @Amennyiben("elmegyek szavazni")
    public void iGoToVote() {
        throw new PendingException();
    }

    @És("sikeresen azonosítom magam")
    public void iIdentifyMyselfSuccessfully() {
        throw new PendingException();
    }

    @Majd("megkapom a körzetemnek megfelelő kérdőívet")
    public void iGetQuestionnaireRelatedToMyDistrict() {
        throw new PendingException();
    }

    @Akkor("leadom a szavazatomat")
    public void iVote() {
        throw new PendingException();
    }

    @De("nem tudom magam azonosítani")
    public void iCantIdentifyMyself() {
        throw new PendingException();
    }

    @Akkor("nem tudok szavazni")
    public void iCantVote() {
        throw new PendingException();
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
}
