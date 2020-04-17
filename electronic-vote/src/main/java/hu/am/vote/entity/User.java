package hu.am.vote.entity;

import java.time.LocalDate;

public class User {
    public String name;
    public LocalDate birthDate;

    public User(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
}
