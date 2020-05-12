package hu.am.log.fakeloggingsystem;

import hu.am.logging.LogSystem;
import hu.am.logging.entity.LogLevel;

import java.util.ArrayList;
import java.util.List;

public class SpyLoggingSystem implements LogSystem {
    public List<String> spyLogs = new ArrayList<String>();
    @Override
    public void setLogLevel(LogLevel logLevel) {

    }

    @Override
    public void addLog(LogLevel logLevel, String logText) {
        spyLogs.add(logText);
    }
}
