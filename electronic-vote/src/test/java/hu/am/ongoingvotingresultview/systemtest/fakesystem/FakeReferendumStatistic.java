package hu.am.ongoingvotingresultview.systemtest.fakesystem;

import hu.am.vote.Election;
import hu.am.vote.ReferendumStatistic;
import hu.am.vote.entity.ReferendumResult;

import java.math.BigDecimal;

public class FakeReferendumStatistic implements ReferendumStatistic {
    @Override
    public ReferendumResult getActualCumulativeResultByCountry(Election election) {
        return getFakeResult();
    }

    @Override
    public ReferendumResult getActualCumulativeResultByCounty(Election election, String county) {
        return getFakeResult();
    }

    @Override
    public ReferendumResult getActualCumulativeResultBySettlement(Election election, String settlement) {
        return getFakeResult();
    }

    private ReferendumResult getFakeResult() {
        ReferendumResult result = new ReferendumResult();
        result.voterTurnover = new BigDecimal("20.2");
        return result;
    }
}
