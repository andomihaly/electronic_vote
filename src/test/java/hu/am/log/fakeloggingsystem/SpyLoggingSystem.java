package hu.am.log.fakeloggingsystem;

import hu.am.logging.LogSystem;
import hu.am.logging.entity.LogLevel;
import hu.am.logging.entity.CallerMode;
import hu.am.logging.entity.Log;

import java.util.ArrayList;
import java.util.List;

public class SpyLoggingSystem implements LogSystem {
    public List<Log> spyLogs = new ArrayList<Log>();
    private LogLevel logLevel;
    @Override
    public void setLogLevel(LogLevel logLevel) {
    	this.logLevel = logLevel;
    }
    
    @Override
    public void setCallerMode(CallerMode callerMode) {
    	
    }
    

    @Override
    public void addLog(LogLevel messageLogLevel, String logText) {
    	if (logLevel.ordinal() >= messageLogLevel.ordinal()) {
    		spyLogs.add(new Log(messageLogLevel, logText));
    	}
    }
    

	@Override
	public LogLevel getLogLevel() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public CallerMode getCallerMode() {
		// TODO Auto-generated method stub
		return null;
	}
}
