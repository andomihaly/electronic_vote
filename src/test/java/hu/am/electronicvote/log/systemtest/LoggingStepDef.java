package hu.am.electronicvote.log.systemtest;

import hu.am.electronicvote.log.fakeloggingsystem.FakeBusinessLogic;
import hu.am.electronicvote.log.fakeloggingsystem.SpyLoggingSystem;
import hu.am.electronicvote.logging.entity.CallerMode;
import hu.am.electronicvote.logging.entity.Log;
import hu.am.electronicvote.logging.entity.LogLevel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.LocalDate;
import java.util.List;


public class LoggingStepDef {

    private SpyLoggingSystem logSystem = new SpyLoggingSystem();
    private final FakeBusinessLogic fakeBusinessLogic = new FakeBusinessLogic(logSystem);

    @When("the log system set to Silent")
    public void theLogSystemSetToSilent() {
        logSystem.setLogLevel(LogLevel.SILENT);
    }

    @When("the business logic called")
    public void theBusinessLogicCalled() {
        fakeBusinessLogic.run();
    }

    @Then("Log should be empty")
    public void logShouldBeEmpty() {
        Assert.assertEquals(0, logSystem.spyLogs.size());
    }

    @Given("the log system set to Error")
    public void theLogSystemSetToError() {
        logSystem.setLogLevel(LogLevel.ERROR);
    }

    @When("an error occurred in the system")
    public void anErrorOccurredInTheSystem() {
        fakeBusinessLogic.runWithException();
    }

    @Then("the log contains only the Error information")
    public void theLogContainsOnlyTheErrorInformation() {
        Assert.assertTrue(containsOnlyErrorLog(logSystem.spyLogs));
        Assert.assertFalse(logSystem.spyLogs.get(logSystem.spyLogs.size() - 1).logText.isEmpty());
    }

    @Given("the log system set to Info")
    public void theLogSystemSetToInfo() {
        logSystem.setLogLevel(LogLevel.INFO);
    }

    @Then("Log system should contains the business logic name and time")
    public void logSystemShouldContainsTheBusinessLogicNameAndTime() {
        Log lastInfoLog = getLastLogByType(LogLevel.INFO, logSystem.spyLogs);
        Assert.assertNotNull(lastInfoLog);
        Assert.assertEquals(LogLevel.INFO, lastInfoLog.logLevel);
        String[] parsedLogText = lastInfoLog.logText.split("\\|");
        Assert.assertEquals("Fake business logic's run method called", parsedLogText[0]);
        String todayDate = LocalDate.now().toString();
        Assert.assertTrue(parsedLogText[1].contains(todayDate));
    }

    @Then("the log contains error information too")
    public void theLogContainsErrorInformationToo() {
        Log lastErrorLog = getLastLogByType(LogLevel.ERROR, logSystem.spyLogs);
        Assert.assertNotNull(lastErrorLog);
        Assert.assertEquals(LogLevel.ERROR, lastErrorLog.logLevel);
    }

    @Given("the log system set to Debug")
    public void theLogSystemSetToDebug() {
        logSystem.setLogLevel(LogLevel.DEBUG);
    }

    @Then("log system should contain the parameters' values which the business logic called")
    public void logSystemShouldContainTheParametersValuesWhichTheBusinessLogicCalled() {
        fakeBusinessLogic.runWithParameter("param1", "param2");
        Assert.assertTrue(logSystem.spyLogs.get(logSystem.spyLogs.size() - 1).logText.contains("param1#param2#"));
    }

    @Given("the log system set to not Silent")
    public void theLogSystemSetToNotSilent() {
        logSystem.setLogLevel(LogLevel.INFO);
    }

    @Given("caller mode is Anonym")
    public void callerModeIsAnonym() {
        logSystem.setCallerMode(CallerMode.ANONYM);
    }

    @Then("the log system should not contain user and authorization information")
    public void theLogSystemShouldNotContainUserAndAuthorizationInformation() {
        Log lastInfoLog = getLastLogByType(LogLevel.INFO, logSystem.spyLogs);
        Assert.assertNotNull(lastInfoLog);
        Assert.assertNull(lastInfoLog.userInfo);
    }

    @Given("caller mode is Personal")
    public void callerModeIsPersonal() {
        logSystem.setCallerMode(CallerMode.PERSONAL);
    }

    @Then("the log system should contain user and authorization information")
    public void theLogSystemShouldContainUserAndAuthorizationInformation() {
        Log lastInfoLog = getLastLogByType(LogLevel.INFO, logSystem.spyLogs);
        Assert.assertNotNull(lastInfoLog);
        Assert.assertNotNull(lastInfoLog.userInfo);
    }

    private boolean containsOnlyErrorLog(List<Log> logs) {
        boolean onlyErrorInTheLog = true;
        for (int i = 0; i < logs.size(); i++) {
            if (logs.get(i).logLevel != LogLevel.ERROR) {
                onlyErrorInTheLog = false;
            }
        }
        return onlyErrorInTheLog;
    }


    private Log getLastLogByType(LogLevel logtype, List<Log> logs) {
        for (int i = logs.size(); i > 0; i--) {
            if (logs.get(i - 1).logLevel == logtype) {
                return logs.get(i - 1);
            }
        }
        return null;
    }

}
