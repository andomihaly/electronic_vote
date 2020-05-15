package hu.am.logging;

public interface AdminsitratorNotificator {
    void notifiedAdminsitrationAboutPersistentLogSystemIssue();

    void notifiedAdminsitrationAboutPersistentLogSystemIssue(Error error);
}
