package hu.am.electronicvote.vote.systemtest.common;

import hu.am.electronicvote.vote.entity.User;
import hu.am.electronicvote.vote.fakevotingsystem.*;
import hu.am.electronicvote.vote.Authentication;
import hu.am.electronicvote.vote.UserManagement;
import hu.am.electronicvote.vote.Election;
import hu.am.electronicvote.vote.entity.Answer;
import hu.am.electronicvote.vote.entity.Option;
import hu.am.electronicvote.vote.entity.Question;

import java.time.LocalDate;

public class KnownVoteObject {
    public SpyAuthenticationConnector spyAuthenticationConnector = new SpyAuthenticationConnector();
    public SpyVotePresenter spyPresenter = new SpyVotePresenter();
    public Election election = new FakeElection(spyPresenter);
    public UserManagement userManagement = new FakeUserManagement();
    public Authentication authentication = new FakeAuthentication(spyAuthenticationConnector);
    public User validUser = new User("Valid User SID", LocalDate.now().minusYears(18));
    public User invalidUser = new User("Invalid User SID", LocalDate.now().minusYears(18));
    public User notLoggedInUser = new User("Not Logged In User SID", LocalDate.now().minusYears(18));
    public Answer validAnswer = new Answer(new Question(), new Option());

}
