package hu.am.vote.systemtest.common;

import hu.am.vote.Authentication;
import hu.am.vote.Election;
import hu.am.vote.entity.Answer;
import hu.am.vote.entity.Optional;
import hu.am.vote.entity.Question;
import hu.am.vote.entity.User;
import hu.am.vote.fakevotingsystem.FakeAuthentication;
import hu.am.vote.fakevotingsystem.FakeElection;
import hu.am.vote.fakevotingsystem.SpyPresenter;

import java.time.LocalDate;

public class KnownVoteObject {
    public SpyPresenter spyPresenter = new SpyPresenter();
    public Election election = new FakeElection(spyPresenter);
    public Authentication authentication = new FakeAuthentication();
    public User validUser = new User("Valid User", LocalDate.now().minusYears(18));
    public User invalidUser = new User("Invalid User", LocalDate.now().minusYears(18));
    public Answer validAnswer = new Answer(new Question(), new Optional());
}
