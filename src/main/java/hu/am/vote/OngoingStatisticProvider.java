package hu.am.vote;

import hu.am.vote.entity.OngoingTurnoutStatistic;

public interface OngoingStatisticProvider {
    OngoingTurnoutStatistic getTurnoutByCountry(String countryCode);
    OngoingTurnoutStatistic getTurnoutByCounty(String countyCode);
    OngoingTurnoutStatistic getTurnoutBySettlement(String settlementCode);
    OngoingTurnoutStatistic getTurnoutByDistrict(String districtCode);
    OngoingTurnoutStatistic getTurnoutByArea(String areaCode);
}
