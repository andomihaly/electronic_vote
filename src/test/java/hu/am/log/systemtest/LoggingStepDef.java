package hu.am.log.systemtest;

import hu.am.log.fakeloggingsystem.FakeBusinessLogic;
import hu.am.log.fakeloggingsystem.SpyLoggingSystem;
import hu.am.logging.entity.CallerMode;
import hu.am.logging.entity.Log;
import hu.am.logging.entity.LogLevel;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;


public class LoggingStepDef {

    private SpyLoggingSystem logSystem = new SpyLoggingSystem();
    @When("the log system set to Silent")
    public void theLogSystemSetToSilent() {
        logSystem.setLogLevel(LogLevel.SILENT);
    }

    @When("the business logic called")
    public void theBusinessLogicCalled() {
        FakeBusinessLogic fbl= new FakeBusinessLogic(logSystem);
        fbl.run();
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
    	FakeBusinessLogic fbl= new FakeBusinessLogic(logSystem);
    	fbl.runWithException();
    }
    

    @Then("the log contains only the Error information")
    public void theLogContainsOnlyTheErrorInformation() {
    	Assert.assertTrue(containsOnlyErrorLog(logSystem.spyLogs));
    	Assert.assertFalse(logSystem.spyLogs.get(logSystem.spyLogs.size()-1).logText.isEmpty());
    }
    

    @Given("the log system set to Info")
    public void theLogSystemSetToInfo() {
    	logSystem.setLogLevel(LogLevel.INFO);
    }

    @Then("Log system should contains the business logic name and time")
    public void logSystemShouldContainsTheBusinessLogicNameAndTime() {
    	Log actualLog = logSystem.spyLogs.get(logSystem.spyLogs.size()-1);
    	Assert.assertEquals(LogLevel.INFO,actualLog.logLevel);
    	String[] parsedLogText = actualLog.logText.split("\\|");
    	Assert.assertEquals("Fake business logic's run method called", parsedLogText[0]);
    	String todayDate = LocalDate.now().toString();
    	Assert.assertTrue(parsedLogText[1].contains(todayDate));
    }

    @Given("the log system set to Debug")
    public void theLogSystemSetToDebug() {
    	logSystem.setLogLevel(LogLevel.DEBUG);
    }

    @Then("log system should contain the parameters' values which the business logic called")
    public void logSystemShouldContainTheParametersValuesWhichTheBusinessLogicCalled() {
    	FakeBusinessLogic fbl= new FakeBusinessLogic(logSystem);
    	fbl.runWithParameter("param1", "param2");
    	Assert.assertTrue(logSystem.spyLogs.get(logSystem.spyLogs.size()-1).logText.contains("param1, param2"));
    }

    @Given("the log system set to not Silent")
    public void theLogSystemSetToNotSilent() {
        Assert.assertFalse(logSystem.getLogLevel()!=LogLevel.SILENT);
    }

    @Given("caller mode is Anonym")
    public void callerModeIsAnonym() {
    	logSystem.setCallerMode(CallerMode.ANONYM);
    }

    @Then("the log system should not contain user and authorization information")
    public void theLogSystemShouldNotContainUserAndAuthorizationInformation() {
    	throw new io.cucumber.java.PendingException();
    }

    @Given("caller mode is Personal")
    public void callerModeIsPersonal() {
    	logSystem.setCallerMode(CallerMode.PERSONAL);
    }

    @Then("the log system should contain user and authorization information")
    public void theLogSystemShouldContainUserAndAuthorizationInformation() {
        throw new io.cucumber.java.PendingException();
    }
    
    private boolean containsOnlyErrorLog(List<Log> logs) {
    	boolean onlyErrorInTheLog = true;
    	for(int i=0; i<logs.size();i++) {
    		if (logs.get(i).logLevel!=LogLevel.ERROR) {
    			onlyErrorInTheLog = false;
    		}
    	}
    	return onlyErrorInTheLog;
    }
    
}
