package hu.am.log.fakeloggingsystem;

import hu.am.logging.AdminsitratorNotificator;
import hu.am.logging.entity.Log;
import hu.am.logging.entity.LogLevel;

import java.util.ArrayList;
import java.util.List;

public class SpyLoggingSystemWithPersistentIssue extends SpyLoggingSystem implements AdminsitratorNotificator {
    public String lastNotification = "";
    public int spyNumberOfTempLogsTryToSave = 0;
    public List<Log> spyTempLogs = new ArrayList<Log>();

    private boolean persistentIssue = false;

    @Override
    public void addLog(LogLevel messageLogLevel, String logText) {
        if (persistentIssue) {
            notifiedAdminsitrationAboutPersistentLogSystemIssue();
            spyTempLogs.add(new Log(messageLogLevel, logText));
        }
        else
            super.addLog(messageLogLevel, logText);
    }

    @Override
    public void saveTempLogs() {
        spyNumberOfTempLogsTryToSave++;
        if (!persistentIssue)
        {
            spyLogs.addAll(spyTempLogs);
            spyTempLogs.clear();
            spyNumberOfTempLogsTryToSave = 0;
        }
    }

    @Override
    public void notifiedAdminsitrationAboutPersistentLogSystemIssue() {
        lastNotification = "PersistentProblemOccured";
    }

    @Override
    public void notifiedAdminsitrationAboutPersistentLogSystemIssue(Error error) {
        lastNotification = "PersistentProblemOccured|" + error.getMessage();
    }


    public void setPersistentIssue(boolean persistentIssue) {
        this.persistentIssue = persistentIssue;
    }

    public void giveTimeIsCome(){
        saveTempLogs();
    }
}
