package hu.am.logging;

import hu.am.logging.entity.LogLevel;
import hu.am.logging.entity.CallerMode;

public interface LogSystem {
    void setLogLevel(LogLevel logLevel);
    void addLog(LogLevel logLevel, String logText);
  //  void addLog(LogLevel logLevel, String logText, userinfo->username,mode);
    
    LogLevel getLogLevel();
    void setCallerMode(CallerMode callerMode);
    CallerMode getCallerMode();
}
