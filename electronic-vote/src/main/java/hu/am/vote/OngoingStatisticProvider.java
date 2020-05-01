package hu.am.vote;

import hu.am.vote.entity.OngoingTurnoutStatistic;

public interface OngoingStatisticProvider {
    OngoingTurnoutStatistic getTurnoutByCountry(Election election, String countryCode);
    OngoingTurnoutStatistic getTurnoutByCounty(Election election, String countyCode);
    OngoingTurnoutStatistic getTurnoutBySettlement(Election election, String settlementCode);
    OngoingTurnoutStatistic getTurnoutByDistrict(Election election, String districtCode);
    OngoingTurnoutStatistic getTurnoutByArea(Election election, String areaCode);
}
