package hu.am.log.fakeloggingsystem;

import java.time.LocalDateTime;

import hu.am.logging.LogSystem;
import hu.am.logging.entity.LogLevel;
import hu.am.logging.entity.UserInfo;

public class FakeBusinessLogic {
    private final LogSystem logSystem;

    public FakeBusinessLogic(LogSystem logSystem) {
        this.logSystem = logSystem;
    }

    public void run(){
        UserInfo userInfo = new UserInfo("misi", "1001100");
    	logSystem.addLog(LogLevel.INFO, "Fake business logic's run method called", userInfo);

    }
    
    public void runWithParameter(String param1, String param2) {
    	logSystem.addLog(LogLevel.DEBUG, "Fake business logic's run method called with parameter ",
                new String []{param1,param2},null);
    }

    public void runWithException() {
    	try {
    		run();
    		int a = 10/0;
    	}
    	catch(Exception e) {

    			logSystem.addLog(LogLevel.ERROR, e.toString(), null, null);

    	}
    }
}
