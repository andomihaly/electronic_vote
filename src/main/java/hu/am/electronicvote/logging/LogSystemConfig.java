package hu.am.electronicvote.logging;

import hu.am.electronicvote.logging.entity.CallerMode;
import hu.am.electronicvote.logging.entity.LogLevel;

public interface LogSystemConfig {
    void setLogLevel(LogLevel logLevel);

    void setCallerMode(CallerMode callerMode);

    void saveTempLogs();
}
