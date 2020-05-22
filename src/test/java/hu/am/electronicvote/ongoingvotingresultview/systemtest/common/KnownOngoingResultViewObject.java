package hu.am.electronicvote.ongoingvotingresultview.systemtest.common;

import hu.am.electronicvote.vote.Election;
import hu.am.electronicvote.vote.FinalResultProvider;
import hu.am.electronicvote.vote.OngoingStatisticProvider;
import hu.am.electronicvote.vote.entity.ElectionResult;
import hu.am.electronicvote.vote.entity.OngoingTurnoutStatistic;

public class KnownOngoingResultViewObject {
    public static Election election;
    public static OngoingStatisticProvider ongoingStatisticProvider;
    public static FinalResultProvider finalResultProvider;

    public static OngoingTurnoutStatistic ongoingTurnoutStatistic;
    public static ElectionResult electionResult;
}
