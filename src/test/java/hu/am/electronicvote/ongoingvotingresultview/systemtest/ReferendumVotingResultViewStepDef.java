package hu.am.electronicvote.ongoingvotingresultview.systemtest;

import hu.am.electronicvote.ongoingvotingresultview.systemtest.common.KnownOngoingResultViewObject;
import hu.am.electronicvote.ongoingvotingresultview.systemtest.fakesystem.FakeElection;
import hu.am.electronicvote.ongoingvotingresultview.systemtest.fakesystem.FakeFinalResultProvider;
import hu.am.electronicvote.ongoingvotingresultview.systemtest.fakesystem.FakeReferendumStatistic;
import io.cucumber.java.Before;
import io.cucumber.java.hu.Akkor;
import io.cucumber.java.hu.Amennyiben;
import io.cucumber.java.hu.Amikor;

import static org.junit.Assert.assertTrue;

public class ReferendumVotingResultViewStepDef {

    @Before
    public void setUp() {
        KnownOngoingResultViewObject.election = new FakeElection();
        KnownOngoingResultViewObject.ongoingStatisticProvider = new FakeReferendumStatistic(KnownOngoingResultViewObject.election);
        KnownOngoingResultViewObject.finalResultProvider = new FakeFinalResultProvider(KnownOngoingResultViewObject.election);

        KnownOngoingResultViewObject.ongoingTurnoutStatistic = null;
        KnownOngoingResultViewObject.electionResult = null;
    }

    @Amennyiben("elindult a népszavazás")
    public void referendumStarted() {
        assertTrue(KnownOngoingResultViewObject.election.isOngoing());
    }

    @Amennyiben("még nem zárult le")
    public void referendumNotClosedYet() {
        assertTrue(KnownOngoingResultViewObject.election.isOngoing());
    }

    @Amikor("kiválasztom a megyét vagy a fővárost")
    public void iChooseTheCountyOrTheCapital() {
        KnownOngoingResultViewObject.ongoingTurnoutStatistic = KnownOngoingResultViewObject.ongoingStatisticProvider.getTurnoutByCounty("CSONGRAD_CSANAD");
        KnownOngoingResultViewObject.electionResult = KnownOngoingResultViewObject.finalResultProvider.getResultByCounty("CSONGRAD_CSANAD");
    }

    @Akkor("látom az aktuális összegzett részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResult() {
        ResultViewStepDefCommon.assertOngoingTurnOutStatisticIstGiven();
    }

    @Amikor("kiválasztok egy kerületet")
    public void iChooseADistrict() {
        KnownOngoingResultViewObject.ongoingTurnoutStatistic = KnownOngoingResultViewObject.ongoingStatisticProvider.getTurnoutByDistrict("XVII");
        KnownOngoingResultViewObject.electionResult = KnownOngoingResultViewObject.finalResultProvider.getResultByDistrict("XVII");
    }

    @Akkor("látom az aktuális összegzett kerületi részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultByDistrict() {
        ResultViewStepDefCommon.assertOngoingTurnOutStatisticIstGiven();
    }

}
