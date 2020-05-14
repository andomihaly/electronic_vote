package hu.am.log.fakeloggingsystem;

import hu.am.logging.LogSystem;
import hu.am.logging.entity.LogLevel;
import hu.am.logging.entity.CallerMode;
import hu.am.logging.entity.Log;
import hu.am.logging.entity.UserInfo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SpyLoggingSystem implements LogSystem {
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

    @Override
    public void addLog(LogLevel logLevel, String logText, UserInfo userInfo) {
        addLog(logLevel, logText, new String[]{}, userInfo);
    }


    @Override
    public void addLog(LogLevel messageLogLevel, String logText, String[] parameters, UserInfo userInfo) {
        if (logLevel.ordinal() >= messageLogLevel.ordinal()) {
            if (LogLevel.INFO.ordinal() <= logLevel.ordinal()) {
                logText += "|" + LocalDateTime.now();
            }
            if (LogLevel.DEBUG.ordinal() <= logLevel.ordinal()) {
                logText += "|";
                if (parameters!=null) {
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
}
