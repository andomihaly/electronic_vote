package hu.am.electronicvote.log.fakeloggingsystem;

import hu.am.electronicvote.logging.LogSystem;
import hu.am.electronicvote.logging.LogSystemConfig;
import hu.am.electronicvote.logging.entity.CallerMode;
import hu.am.electronicvote.logging.entity.Log;
import hu.am.electronicvote.logging.entity.LogLevel;
import hu.am.electronicvote.logging.entity.UserInfo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SpyLoggingSystem implements LogSystem, LogSystemConfig {
    public List<Log> spyLogs = new ArrayList<Log>();
    protected LogLevel logLevel = LogLevel.INFO;
    protected CallerMode callerMode = CallerMode.ANONYM;

    @Override
    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void setCallerMode(CallerMode callerMode) {
        this.callerMode = callerMode;
    }

    public void addLog(LogLevel logLevel, String logText, UserInfo userInfo) {
        addLog(logLevel, logText, new String[]{}, userInfo);
    }

    public void addLog(LogLevel messageLogLevel, String logText, String[] parameters, UserInfo userInfo) {
        if (logLevel.ordinal() >= messageLogLevel.ordinal()) {
            if (LogLevel.INFO.ordinal() <= logLevel.ordinal()) {
                logText += "|" + LocalDateTime.now();
            }
            if (LogLevel.DEBUG.ordinal() <= logLevel.ordinal()) {
                logText += "|";
                if (parameters != null) {
                    for (String parameter : parameters) {
                        logText += parameter + "#";
                    }
                }
            }
            if (callerMode == CallerMode.ANONYM) {
                userInfo = null;
            }
            spyLogs.add(new Log(messageLogLevel, logText, userInfo));
        }
    }

    @Override
    public void saveTempLogs() {

    }

    @Override
    public void addErrorLog(String logText, UserInfo userInfo) {
        addLog(LogLevel.ERROR, logText, userInfo);
    }

    @Override
    public void addInfoLog(String logText, UserInfo userInfo) {
        addLog(LogLevel.INFO, logText, userInfo);
    }

    @Override
    public void addDebugLog(String logText, UserInfo userInfo, String[] parameters) {
        addLog(LogLevel.DEBUG, logText, parameters, userInfo);
    }
}
