package hu.am.vote.systemtest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "src/test/java/hu/am/vote/systemtest",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = "progress",
        monochrome = true
)

public class VoteTest {
}
