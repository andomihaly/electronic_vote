package hu.am.ongoingvotingresultview.systemtest;

import hu.am.ongoingvotingresultview.systemtest.fakesystem.FakeElection;
import hu.am.ongoingvotingresultview.systemtest.fakesystem.FakeFinalResultProvider;
import hu.am.ongoingvotingresultview.systemtest.fakesystem.FakeReferendumStatistic;
import hu.am.vote.Election;
import hu.am.vote.FinalResultProvider;
import hu.am.vote.OngoingStatisticProvider;
import hu.am.vote.entity.ElectionResult;
import hu.am.vote.entity.OngoingTurnoutStatistic;
import io.cucumber.java.hu.Akkor;
import io.cucumber.java.hu.Amennyiben;
import io.cucumber.java.hu.Amikor;

import static org.junit.Assert.*;

public class ReferendumVotingResultViewStepDef {

    private Election election = new FakeElection();
    private OngoingStatisticProvider ongoingStatisticProvider = new FakeReferendumStatistic();
    private OngoingTurnoutStatistic ongoingTurnoutStatistic;
    private FinalResultProvider finalResultProvider = new FakeFinalResultProvider(election);
    private ElectionResult electionResult;

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
        ongoingTurnoutStatistic = ongoingStatisticProvider.getTurnoutByCountry(election, "HUN");
        electionResult = finalResultProvider.getResultByCountry("HUN");
    }

    @Akkor("látom az aktuális összegzett országos részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultByCountry() {
        assertNotNull(ongoingTurnoutStatistic);
        assertNotEquals(-1, ongoingTurnoutStatistic.numberOfPotentialVoter);
        assertNotEquals(-1, ongoingTurnoutStatistic.numberOfVoterAlreadyVoted);
        assertNotEquals(-1, ongoingTurnoutStatistic.getTurnoutRate());
    }

    @Akkor("nem látom az aktuális szavazási eredményeket")
    public void iCantSeeTheActualResult() {
        assertNull(electionResult);
    }

    @Amikor("kiválasztom a megyét vagy a fővárost")
    public void iChooseTheCountyOrTheCapital() {
        ongoingTurnoutStatistic = ongoingStatisticProvider.getTurnoutByCounty(election,"Budapest");
    }

    @Akkor("látom az aktuális összegzett részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResult() {
        //assertNotNull(ongoingTurnoutStatistic.voterTurnOut);
    }

    @Amikor("kiválasztok egy települést")
    public void iChooseASettlement() {
        ongoingTurnoutStatistic = ongoingStatisticProvider.getTurnoutBySettlement(election,"Pécel");
    }

    @Akkor("látom az aktuális összegzett települési részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultBySettlement() {
        //assertNull(ongoingTurnoutStatistic.votingResult);
    }

    @Amikor("kiválasztok egy kerületet")
    public void iChooseADistrict() {
        ongoingTurnoutStatistic = ongoingStatisticProvider.getTurnoutByDistrict(election,"XVII");
    }

    @Akkor("látom az aktuális összegzett kerületi részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultByDistrict() {
        //assertNotNull(ongoingTurnoutStatistic.voterTurnOut);
    }


    @Amikor("kiválasztok egy körzetet")
    public void iChooseAnArea() {
        ongoingTurnoutStatistic = ongoingStatisticProvider.getTurnoutByArea(election,"AREACODE_9");
    }

    @Akkor("látom az aktuális körzeti részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultByArea() {
        //assertNotNull(ongoingTurnoutStatistic.voterTurnOut);
    }

}
