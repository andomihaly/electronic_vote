package hu.am.ongoingvotingresultview.systemtest;

import io.cucumber.java.hu.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "src/test/java/hu/am/ongoingvotingresultview/systemtest/referendumvotingresultview.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"progress", "json:target/executable-specification/cucumber.json"},
        monochrome = true
)
public class ReferendumVotingResultViewTest {

}
