package hu.am.logging;

import hu.am.logging.entity.CallerMode;
import hu.am.logging.entity.LogLevel;

public interface LogSystemConfig {
    void setLogLevel(LogLevel logLevel);

    void setCallerMode(CallerMode callerMode);

    void saveTempLogs();
}
