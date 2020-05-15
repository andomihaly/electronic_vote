package hu.am.electronicvote.logging;

import hu.am.electronicvote.logging.entity.UserInfo;

public interface LogSystem {
    void addErrorLog(String logText, UserInfo userInfo);

    void addInfoLog(String logText, UserInfo userInfo);

    void addDebugLog(String logText, UserInfo userInfo, String[] parameters);
}
