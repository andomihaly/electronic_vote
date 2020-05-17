package hu.am.electronicvote.logging;

public interface AdminsitratorNotificator {
    void notifiedAdminsitrationAboutPersistentLogSystemIssue();

    void notifiedAdminsitrationAboutPersistentLogSystemIssue(Error error);
}
