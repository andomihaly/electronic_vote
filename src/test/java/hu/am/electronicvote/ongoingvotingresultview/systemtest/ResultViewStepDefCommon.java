package hu.am.electronicvote.ongoingvotingresultview.systemtest;

import hu.am.electronicvote.ongoingvotingresultview.systemtest.common.KnownOngoingResultViewObject;
import io.cucumber.java.hu.Akkor;
import io.cucumber.java.hu.Amikor;

import static org.junit.Assert.*;

public class ResultViewStepDefCommon {


    @Amikor("kiválasztok egy települést")
    public void iChooseASettlement() {
        KnownOngoingResultViewObject.ongoingTurnoutStatistic = KnownOngoingResultViewObject.ongoingStatisticProvider.getTurnoutBySettlement("PECEL");
        KnownOngoingResultViewObject.electionResult = KnownOngoingResultViewObject.finalResultProvider.getResultBySettlement("PECEL");
    }

    @Amikor("megnézem a választási adatokat")
    public void iSeeReferendumResult() {
        KnownOngoingResultViewObject.ongoingTurnoutStatistic = KnownOngoingResultViewObject.ongoingStatisticProvider.getTurnoutByCountry("HUN");
        KnownOngoingResultViewObject.electionResult = KnownOngoingResultViewObject.finalResultProvider.getResultByCountry("HUN");
    }

    @Akkor("látom az aktuális összegzett országos részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultByCountry() {
        assertOngoingTurnOutStatisticIstGiven();
    }

    @Akkor("látom az aktuális összegzett települési részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultBySettlement() {
        assertOngoingTurnOutStatisticIstGiven();
    }

    @Akkor("nem látom az aktuális szavazási eredményeket")
    public void iCantSeeTheActualResult() {
        assertNull(KnownOngoingResultViewObject.electionResult);
    }

    @Amikor("kiválasztok egy körzetet")
    public void iChooseAnArea() {
        KnownOngoingResultViewObject.ongoingTurnoutStatistic = KnownOngoingResultViewObject.ongoingStatisticProvider.getTurnoutByArea("AREACODE_9");
        KnownOngoingResultViewObject.electionResult = KnownOngoingResultViewObject.finalResultProvider.getResultByArea("AREACODE_9");
    }

    @Akkor("látom az aktuális körzeti részvételi arányt")
    public void iSeeTheActualCumulativeVoterTurnoutResultByArea() {
        assertOngoingTurnOutStatisticIstGiven();
    }

    protected static void assertOngoingTurnOutStatisticIstGiven() {
        assertNotNull(KnownOngoingResultViewObject.ongoingTurnoutStatistic);
        assertNotEquals(-1, KnownOngoingResultViewObject.ongoingTurnoutStatistic.numberOfPotentialVoter);
        assertNotEquals(-1, KnownOngoingResultViewObject.ongoingTurnoutStatistic.numberOfVoterAlreadyVoted);
        assertNotEquals(-1, KnownOngoingResultViewObject.ongoingTurnoutStatistic.getTurnoutRate());
    }
}
