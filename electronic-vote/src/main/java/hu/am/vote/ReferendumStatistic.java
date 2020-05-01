package hu.am.vote;

import hu.am.vote.entity.ReferendumResult;

public interface ReferendumStatistic {
    ReferendumResult getActualCumulativeResultByCountry(Election election);
    ReferendumResult getActualCumulativeResultByCounty(Election election, String county);
    ReferendumResult getActualCumulativeResultBySettlement(Election election, String settlement);
    ReferendumResult getActualCumulativeResultByDistrict(Election election, String district);
    ReferendumResult getActualCumulativeResultByArea(Election election, String areacode);
}
