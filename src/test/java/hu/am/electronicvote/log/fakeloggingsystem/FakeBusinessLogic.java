package hu.am.electronicvote.log.fakeloggingsystem;

import hu.am.electronicvote.logging.LogSystem;
import hu.am.electronicvote.logging.entity.UserInfo;

public class FakeBusinessLogic {
    private final LogSystem logSystem;

    public FakeBusinessLogic(LogSystem logSystem) {
        this.logSystem = logSystem;
    }

    public void run() {
        UserInfo userInfo = new UserInfo("misi", "1001100");
        logSystem.addInfoLog("Fake business logic's run method called", userInfo);

    }

    public void runWithParameter(String param1, String param2) {
        logSystem.addDebugLog("Fake business logic's run method called with parameter ",
                null, new String[]{param1, param2});
    }

    public void runWithException() {
        try {
            run();
            int a = 10 / 0;
        } catch (Exception e) {

            logSystem.addErrorLog(e.toString(), null);

        }
    }
}
