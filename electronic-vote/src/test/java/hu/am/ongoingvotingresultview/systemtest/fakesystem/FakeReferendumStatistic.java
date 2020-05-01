package hu.am.ongoingvotingresultview.systemtest.fakesystem;

import hu.am.vote.Election;
import hu.am.vote.OngoingStatisticProvider;
import hu.am.vote.entity.OngoingTurnoutStatistic;

import java.math.BigDecimal;

public class FakeReferendumStatistic implements OngoingStatisticProvider {
    @Override
    public OngoingTurnoutStatistic getTurnoutByCountry(Election election, String countryCode) {
        return getFakeResult();
    }

    @Override
    public OngoingTurnoutStatistic getTurnoutByCounty(Election election, String countyCode) {
        return getFakeResult();
    }

    @Override
    public OngoingTurnoutStatistic getTurnoutBySettlement(Election election, String settlementCode) {
        return getFakeResult();
    }

    @Override
    public OngoingTurnoutStatistic getTurnoutByDistrict(Election election, String districtCode) {
        return getFakeResult();
    }

    @Override
    public OngoingTurnoutStatistic getTurnoutByArea(Election election, String areaCode) {
        return getFakeResult();
    }

    private OngoingTurnoutStatistic getFakeResult() {
        OngoingTurnoutStatistic result = new OngoingTurnoutStatistic();
        result.numberOfPotentialVoter = 100;
        result.numberOfVoterAlreadyVoted = 0;
        return result;
    }
}
