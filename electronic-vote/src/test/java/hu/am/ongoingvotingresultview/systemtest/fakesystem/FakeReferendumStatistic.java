package hu.am.ongoingvotingresultview.systemtest.fakesystem;

import hu.am.vote.Election;
import hu.am.vote.OngoingStatisticProvider;
import hu.am.vote.entity.OngoingTurnoutStatistic;

public class FakeReferendumStatistic implements OngoingStatisticProvider {
    public FakeReferendumStatistic(Election election) {
    }

    @Override
    public OngoingTurnoutStatistic getTurnoutByCountry(String countryCode) {
        return getFakeResult();
    }

    @Override
    public OngoingTurnoutStatistic getTurnoutByCounty(String countyCode) {
        return getFakeResult();
    }

    @Override
    public OngoingTurnoutStatistic getTurnoutBySettlement(String settlementCode) {
        return getFakeResult();
    }

    @Override
    public OngoingTurnoutStatistic getTurnoutByDistrict(String districtCode) {
        return getFakeResult();
    }

    @Override
    public OngoingTurnoutStatistic getTurnoutByArea(String areaCode) {
        return getFakeResult();
    }

    private OngoingTurnoutStatistic getFakeResult() {
        OngoingTurnoutStatistic result = new OngoingTurnoutStatistic();
        result.numberOfPotentialVoter = 100;
        result.numberOfVoterAlreadyVoted = 0;
        return result;
    }
}
