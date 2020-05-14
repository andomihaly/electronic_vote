package hu.am.log.systemtest;
import hu.am.log.fakeloggingsystem.FakeBusinessLogic;
import hu.am.log.fakeloggingsystem.SpyLoggingSystemWithPersistentIssue;
import io.cucumber.java.en.*;

import org.junit.Assert;
public class LoggingPersistenceStepDef {
    private SpyLoggingSystemWithPersistentIssue logSystem = new SpyLoggingSystemWithPersistentIssue();
    private FakeBusinessLogic fakeBusinessLogic = new FakeBusinessLogic(logSystem);
    private int persistentLogSize;
    private int persistentTempLogSize;

    @Given("a fully working log system")
    public void aFullyWorkingLogSystem() {
        fakeBusinessLogic.run();
    }

    @When("persistence problem occurred")
    public void persistenceProblemOccurred() {
        logSystem.setPersistentIssue(true);
        fakeBusinessLogic.run();
    }

    @Then("operation engineer has notified")
    public void operationEngineerHasNotified() {
        Assert.assertFalse(logSystem.lastNotification.isEmpty());
    }

    @Then("the log system continuously collects the logs")
    public void theLogSystemContinuouslyCollectsTheLogs() {
        Assert.assertEquals(1,logSystem.spyTempLogs.size());
    }

    @Given("a limited working log system")
    public void aLimitedWorkingLogSystem() {
        fakeBusinessLogic.run();
        logSystem.setPersistentIssue(true);
        fakeBusinessLogic.run();
    }

    @Given("we have log which is not stored in a persistent way")
    public void weHaveLogWhichIsNotStoredInAPersistentWay() {
        Assert.assertNotEquals(0, logSystem.spyTempLogs.size());
    }

    @When("a given time has come")
    public void aGivenTimeHasCome() {
        persistentLogSize = logSystem.spyLogs.size();
        persistentTempLogSize = logSystem.spyTempLogs.size();
        Assert.assertNotEquals(0, persistentTempLogSize);
        logSystem.giveTimeIsCome();
    }

    @Then("the log system tries to store the logs in a persistent way")
    public void theLogSystemTriesToStoreTheLogsInAPersistentWay() {
        Assert.assertEquals(1, logSystem.spyNumberOfTempLogsTryToSave);
    }

    @Given("the persistent problem already solved")
    public void thePersistentProblemAlreadySolved() {
        logSystem.setPersistentIssue(false);
    }

    @Then("the unsaved logs successfully saved in a persistent way")
    public void theUnsavedLogsSuccessfullySavedInAPersistentWay() {
        Assert.assertEquals(persistentLogSize+persistentTempLogSize, logSystem.spyLogs.size());
    }

    @Given("the persistent problem still present")
    public void thePersistentProblemStillPresent() {
        logSystem.setPersistentIssue(true);
    }

    @Then("the unsaved logs are not saved in a persistent way")
    public void theUnsavedLogsAreNotSavedInAPersistentWay() {
        Assert.assertNotEquals(0, persistentTempLogSize);
        logSystem.giveTimeIsCome();
        Assert.assertEquals(persistentLogSize, logSystem.spyLogs.size());
        Assert.assertEquals(persistentTempLogSize, logSystem.spyTempLogs.size());
    }

    @Then("it still available in unsaved logs")
    public void itStillAvailableInUnsavedLogs() {
        int persistentTempLogSize = logSystem.spyTempLogs.size();
        Assert.assertNotEquals(0, persistentTempLogSize);
        fakeBusinessLogic.run();
        Assert.assertEquals(persistentTempLogSize+1, logSystem.spyTempLogs.size());
    }
}
