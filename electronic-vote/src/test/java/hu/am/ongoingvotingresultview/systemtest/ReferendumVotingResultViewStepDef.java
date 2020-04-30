package hu.am.ongoingvotingresultview.systemtest;

import hu.am.ongoingvotingresultview.systemtest.fakesystem.FakeElection;
import hu.am.ongoingvotingresultview.systemtest.fakesystem.FakeReferendumStatistic;
import hu.am.vote.Election;
import hu.am.vote.ReferendumStatistic;
import hu.am.vote.entity.ReferendumResult;
import io.cucumber.java.hu.Akkor;
import io.cucumber.java.hu.Amennyiben;
import io.cucumber.java.hu.Amikor;

import static org.junit.Assert.*;

public class ReferendumVotingResultViewStepDef {

    private Election election = new FakeElection();
    private ReferendumStatistic referendumStatistic = new FakeReferendumStatistic();

    @Amennyiben("elindult a népszavazás")
    public void referendumStarted() {
        assertTrue(election.isOngoing());
    }

    @Amennyiben("még nem zárult le")
    public void referendumNotClosedYet() {
        assertTrue(election.isOngoing());
    }

    @Amikor("megnézem a választási adatokat")
    public void iSeeReferendumResult() {

    }

    @Akkor("látom az aktuális összegzett országos részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultByCountry() {
        ReferendumResult result = referendumStatistic.getActualCumulativeResultByCountry(election);
        assertNotNull(result.voterTurnover);
    }

    @Akkor("nem látom az aktuális szavazási eredményeket")
    public void iCantSeeTheActualResult() {
        ReferendumResult result = referendumStatistic.getActualCumulativeResultByCountry(election);
        assertNull(result.votingResult);
    }

    @Amikor("kiválasztom a megyét vagy a fővárost")
    public void iChooseTheCountyOrTheCapital() {

    }

    @Akkor("látom az aktuális összegzett részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResult() {
        ReferendumResult result = referendumStatistic.getActualCumulativeResultByCounty(election,"Budapest");
        assertNotNull(result.voterTurnover);
    }

    @Amikor("kiválasztok egy települést")
    public void iChooseASettlement() {
        ReferendumResult result = referendumStatistic.getActualCumulativeResultBySettlement(election,"Budapest");
        assertNotNull(result.voterTurnover);
    }

    @Akkor("látom az aktuális összegzett települési részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultBySettlement() {
        ReferendumResult result = referendumStatistic.getActualCumulativeResultBySettlement(election,"Budapest");
        assertNull(result.votingResult);
    }

    @Amikor("kiválasztok egy kerületet")
    public void iChooseADistrict() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Akkor("látom az aktuális összegzett kerületi részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultByDistrict() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Amikor("kiválasztok egy körzetet")
    public void iChooseAnArea() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Akkor("látom az aktuális körzeti részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultByArea() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
