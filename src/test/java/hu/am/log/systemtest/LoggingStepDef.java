package hu.am.log.systemtest;

import hu.am.log.fakeloggingsystem.FakeBusinessLogic;
import hu.am.log.fakeloggingsystem.SpyLoggingSystem;
import hu.am.logging.LogSystem;
import hu.am.logging.entity.CallerMode;
import hu.am.logging.entity.Log;
import hu.am.logging.entity.LogLevel;
import io.cucumber.java.en.*;

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
        throw new io.cucumber.java.PendingException();
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

    @Given("a fully working log system")
    public void aFullyWorkingLogSystem() {
        throw new io.cucumber.java.PendingException();
    }

    @When("persistence problem occurred")
    public void persistenceProblemOccurred() {
        
        throw new io.cucumber.java.PendingException();
    }

    @Then("operation engineer has notified")
    public void operationEngineerHasNotified() {
        
        throw new io.cucumber.java.PendingException();
    }

    @Then("the log system continuously collects the logs")
    public void theLogSystemContinuouslyCollectsTheLogs() {
        
        throw new io.cucumber.java.PendingException();
    }

    @Given("a limited working log system")
    public void aLimitedWorkingLogSystem() {
        
        throw new io.cucumber.java.PendingException();
    }

    @Given("we have log which is not stored in a persistent way")
    public void weHaveLogWhichIsNotStoredInAPersistentWay() {
        
        throw new io.cucumber.java.PendingException();
    }

    @When("a given time has come")
    public void aGivenTimeHasCome() {
        
        throw new io.cucumber.java.PendingException();
    }

    @Then("the log system tries to store the logs in a persistent way")
    public void theLogSystemTriesToStoreTheLogsInAPersistentWay() {
        
        throw new io.cucumber.java.PendingException();
    }

    @Given("the persistent problem already solved")
    public void thePersistentProblemAlreadySolved() {
       
    }

    @Then("the unsaved logs successfully saved in a persistent way")
    public void theUnsavedLogsSuccessfullySavedInAPersistentWay() {
        
        throw new io.cucumber.java.PendingException();
    }

    @Given("the persistent problem still present")
    public void thePersistentProblemStillPresent() {
        
        throw new io.cucumber.java.PendingException();
    }

    @Then("the unsaved logs are not saved in a persistent way")
    public void theUnsavedLogsAreNotSavedInAPersistentWay() {
        
        throw new io.cucumber.java.PendingException();
    }

    @Then("it still available in unsaved logs")
    public void itStillAvailableInUnsavedLogs() {
        
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
