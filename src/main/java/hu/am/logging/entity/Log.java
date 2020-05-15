package hu.am.logging.entity;

public class Log {

    public LogLevel logLevel;
    public String logText;
    public UserInfo userInfo;

    public Log(LogLevel logLevel, String logText) {
        this.logLevel = logLevel;
        this.logText = logText;
    }

    public Log(LogLevel logLevel, String logText, UserInfo userInfo) {
        this.logLevel = logLevel;
        this.logText = logText;
        this.userInfo = userInfo;
    }
}
