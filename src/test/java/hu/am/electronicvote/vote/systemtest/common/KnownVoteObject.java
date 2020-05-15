package hu.am.electronicvote.vote.systemtest.common;

import hu.am.electronicvote.vote.entity.User;
import hu.am.electronicvote.vote.fakevotingsystem.FakeAuthentication;
import hu.am.electronicvote.vote.fakevotingsystem.FakeElection;
import hu.am.electronicvote.vote.fakevotingsystem.FakeUserManagement;
import hu.am.electronicvote.vote.Authentication;
import hu.am.electronicvote.vote.UserManagement;
import hu.am.electronicvote.vote.Election;
import hu.am.electronicvote.vote.entity.Answer;
import hu.am.electronicvote.vote.entity.Option;
import hu.am.electronicvote.vote.entity.Question;
import hu.am.electronicvote.vote.fakevotingsystem.SpyPresenter;

import java.time.LocalDate;

public class KnownVoteObject {
    public SpyPresenter spyPresenter = new SpyPresenter();
    public Election election = new FakeElection(spyPresenter);
    public UserManagement userManagement = new FakeUserManagement();
    public Authentication authentication = new FakeAuthentication();
    public User validUser = new User("Valid User", LocalDate.now().minusYears(18));
    public User invalidUser = new User("Invalid User", LocalDate.now().minusYears(18));
    public Answer validAnswer = new Answer(new Question(), new Option());
}
