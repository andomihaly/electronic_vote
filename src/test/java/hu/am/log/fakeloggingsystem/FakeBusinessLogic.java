package hu.am.log.fakeloggingsystem;

import java.time.LocalDateTime;

import hu.am.logging.LogSystem;
import hu.am.logging.entity.LogLevel;

public class FakeBusinessLogic {
    private final LogSystem logSystem;

    public FakeBusinessLogic(LogSystem logSystem) {
        this.logSystem = logSystem;
    }

    public void run(){
    	logSystem.addLog(LogLevel.INFO, "Fake business logic's run method called|"+LocalDateTime.now());

    }
    
    public void runWithException() {
    	try {
    		run();
    		int a = 10/0;
    	}
    	catch(Exception e) {
    		logSystem.addLog(LogLevel.ERROR, e.toString());
    	}
    }
}
