package hu.am.logging;

import hu.am.logging.entity.UserInfo;

public interface LogSystem {
    void addErrorLog(String logText, UserInfo userInfo);

    void addInfoLog(String logText, UserInfo userInfo);

    void addDebugLog(String logText, UserInfo userInfo, String[] parameters);
}
