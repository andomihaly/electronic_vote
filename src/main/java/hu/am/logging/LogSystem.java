package hu.am.logging;

import hu.am.logging.entity.LogLevel;
import hu.am.logging.entity.CallerMode;
import hu.am.logging.entity.UserInfo;

public interface LogSystem {
    void setLogLevel(LogLevel logLevel);
    void setCallerMode(CallerMode callerMode);
    void addLog(LogLevel logLevel, String logText, UserInfo userInfo);
    void addLog(LogLevel logLevel, String logText, String[] parameters, UserInfo userInfo);
    void saveTempLogs();

}
