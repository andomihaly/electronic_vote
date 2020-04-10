package hu.am.vote.systemtest.common;

import am.vote.Authentication;
import am.vote.Election;
import am.vote.entity.User;
import hu.am.fakevotingsystem.FakeAuthentication;
import hu.am.fakevotingsystem.FakeElection;
import hu.am.fakevotingsystem.SpyPresenter;

public class KnownVoteObject {
    public SpyPresenter spyPresenter = new SpyPresenter();
    public Election election = new FakeElection(spyPresenter);
    public Authentication authentication = new FakeAuthentication();
    public User validUser = new User("Valid User");
    public User invalidUser = new User("Invalid User");
}
