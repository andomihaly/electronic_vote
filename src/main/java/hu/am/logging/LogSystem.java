package hu.am.logging;

import hu.am.logging.entity.LogLevel;

public interface LogSystem {
    void setLogLevel(LogLevel logLevel);
    void addLog(LogLevel logLevel, String logText);
}
