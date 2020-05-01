package hu.am.vote;

import hu.am.vote.entity.ElectionResult;

public interface FinalResultProvider {
    ElectionResult getResultByCountry(String countryCode);
}
