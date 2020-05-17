package hu.am.electronicvote.ongoingvotingresultview.systemtest.fakesystem;

import hu.am.electronicvote.vote.Election;
import hu.am.electronicvote.vote.FinalResultProvider;
import hu.am.electronicvote.vote.entity.ElectionResult;

public class FakeFinalResultProvider implements FinalResultProvider {
    private final Election election;

    public FakeFinalResultProvider(Election election) {
        this.election = election;
    }

    @Override
    public ElectionResult getResultByCountry(String countryCode) {
        return null;
    }

    @Override
    public ElectionResult getResultByCounty(String countyCode) {
        return null;
    }

    @Override
    public ElectionResult getResultBySettlement(String settlementCode) {
        return null;
    }

    @Override
    public ElectionResult getResultByDistrict(String districtCode) {
        return null;
    }

    @Override
    public ElectionResult getResultByArea(String areaCode) {
        return null;
    }
}
