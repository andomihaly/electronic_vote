package hu.am.log.fakeloggingsystem;

import hu.am.logging.LogSystem;
import hu.am.logging.entity.LogLevel;
import hu.am.logging.entity.CallerMode;
import hu.am.logging.entity.Log;

import java.util.ArrayList;
import java.util.List;

public class SpyLoggingSystem implements LogSystem {
    public List<Log> spyLogs = new ArrayList<Log>();
    protected LogLevel logLevel = LogLevel.INFO;
    protected CallerMode callerMode = CallerMode.PERSONAL;

    @Override
    public void setLogLevel(LogLevel logLevel) {
    	this.logLevel = logLevel;
    }
    
    @Override
    public void setCallerMode(CallerMode callerMode) {
    	this.callerMode = callerMode;
    }
    

    @Override
    public void addLog(LogLevel messageLogLevel, String logText) {
    	if (logLevel.ordinal() >= messageLogLevel.ordinal()) {
    		spyLogs.add(new Log(messageLogLevel, logText));
    	}
    }

	@Override
	public void saveTempLogs() {

	}

	@Override
	public LogLevel getLogLevel() {
		return null;
	}

	@Override
	public CallerMode getCallerMode() {
		return null;
	}
}
