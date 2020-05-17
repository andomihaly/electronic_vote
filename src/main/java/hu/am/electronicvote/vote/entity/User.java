package hu.am.electronicvote.vote.entity;

import java.time.LocalDate;

public class User {
    public String sessionId;
    public LocalDate birthDate;

    public User(String sessionId, LocalDate birthDate) {
        this.sessionId = sessionId;
        this.birthDate = birthDate;
    }
}
