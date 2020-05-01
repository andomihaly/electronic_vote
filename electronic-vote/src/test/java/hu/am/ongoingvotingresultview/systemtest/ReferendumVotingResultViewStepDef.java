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
    private ReferendumResult result;

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
        result = referendumStatistic.getActualCumulativeResultByCountry(election);
    }

    @Akkor("látom az aktuális összegzett országos részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultByCountry() {
        assertNotNull(result.voterTurnover);
    }

    @Akkor("nem látom az aktuális szavazási eredményeket")
    public void iCantSeeTheActualResult() {
        assertNull(result.votingResult);
    }

    @Amikor("kiválasztom a megyét vagy a fővárost")
    public void iChooseTheCountyOrTheCapital() {
        result = referendumStatistic.getActualCumulativeResultByCounty(election,"Budapest");
    }

    @Akkor("látom az aktuális összegzett részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResult() {
        assertNotNull(result.voterTurnover);
    }

    @Amikor("kiválasztok egy települést")
    public void iChooseASettlement() {
        result = referendumStatistic.getActualCumulativeResultBySettlement(election,"Pécel");
    }

    @Akkor("látom az aktuális összegzett települési részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultBySettlement() {
        assertNull(result.votingResult);
    }

    @Amikor("kiválasztok egy kerületet")
    public void iChooseADistrict() {
        result = referendumStatistic.getActualCumulativeResultByDistrict(election,"XVII");
    }

    @Akkor("látom az aktuális összegzett kerületi részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultByDistrict() {
        assertNotNull(result.voterTurnover);
    }


    @Amikor("kiválasztok egy körzetet")
    public void iChooseAnArea() {
        result = referendumStatistic.getActualCumulativeResultByArea(election,"AREACODE_9");
    }

    @Akkor("látom az aktuális körzeti részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultByArea() {
        assertNotNull(result.voterTurnover);
    }

}
