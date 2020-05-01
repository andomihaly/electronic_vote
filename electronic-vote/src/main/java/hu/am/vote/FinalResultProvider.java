package hu.am.vote;

import hu.am.vote.entity.ElectionResult;

public interface FinalResultProvider {
    ElectionResult getResultByCountry(String countryCode);
    ElectionResult getResultByCounty(String countyCode);
    ElectionResult getResultBySettlement(String settlementCode);
    ElectionResult getResultByDistrict(String districtCode);
    ElectionResult getResultByArea(String areaCode);
}
