package hu.am.electronicvote.vote;

import hu.am.electronicvote.vote.entity.OngoingTurnoutStatistic;

public interface OngoingStatisticProvider {
    OngoingTurnoutStatistic getTurnoutByCountry(String countryCode);
    OngoingTurnoutStatistic getTurnoutByCounty(String countyCode);
    OngoingTurnoutStatistic getTurnoutBySettlement(String settlementCode);
    OngoingTurnoutStatistic getTurnoutByDistrict(String districtCode);
    OngoingTurnoutStatistic getTurnoutByArea(String areaCode);
}
