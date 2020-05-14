package hu.am.logging.entity;

public class Log {
	
	public LogLevel logLevel;
	public String logText;
	
	public User username;
	
	public Log (LogLevel logLevel, String logText) {
		this.logLevel=logLevel;
		this.logText=logText;
	}
}
