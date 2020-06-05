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

public class MayorVotingResultViewStepDef {

    @Before
    public void setUp() {
        KnownOngoingResultViewObject.election = new FakeElection();
        KnownOngoingResultViewObject.ongoingStatisticProvider = new FakeReferendumStatistic(KnownOngoingResultViewObject.election);
        KnownOngoingResultViewObject.finalResultProvider = new FakeFinalResultProvider(KnownOngoingResultViewObject.election);

        KnownOngoingResultViewObject.ongoingTurnoutStatistic = null;
        KnownOngoingResultViewObject.electionResult = null;
    }

    @Amennyiben("elindult az önkormányzati választás")
    public void mayorVotingStarted() {
        assertTrue(KnownOngoingResultViewObject.election.isOngoing());
    }

    @Amikor("kiválasztom a fővárost")
    public void iChooseTheCapital() {
        KnownOngoingResultViewObject.ongoingTurnoutStatistic = KnownOngoingResultViewObject.ongoingStatisticProvider.getTurnoutBySettlement("BUDAPEST");
        KnownOngoingResultViewObject.electionResult = KnownOngoingResultViewObject.finalResultProvider.getResultBySettlement("BUDAPEST");
    }

    @Akkor("látom az aktuális összegzett fővárosi részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultByCapital() {
        ResultViewStepDefCommon.assertOngoingTurnOutStatisticIstGiven();
    }


}
