package hu.am.electronicvote.vote.systemtest.common;

import hu.am.electronicvote.vote.fakevotingsystem.*;
import hu.am.electronicvote.vote.Authorization;
import hu.am.electronicvote.vote.UserManagement;
import hu.am.electronicvote.vote.Election;
import hu.am.electronicvote.vote.entity.Answer;
import hu.am.electronicvote.vote.entity.Option;
import hu.am.electronicvote.vote.entity.Question;

public class KnownVoteObject {
    public static final String YOUNG_USER_SESSIONID = "Young Valid User SID";
    public static final String NOT_LOGGED_IN_USER_SESSIONID = "Not Logged In User SID";
    public static final String INVALID_USER_SESSIONID = "Invalid User SID";
    public static final String VALID_USER_SESSIONID = "Valid User SID";

    public SpyAuthorizationConnector spyAuthorizationConnector = new SpyAuthorizationConnector();
    public SpyVotePresenter spyPresenter = new SpyVotePresenter();
    public Election election = new FakeElection(spyPresenter);
    public UserManagement userManagement = new FakeUserManagement();
    public Authorization authorization = new FakeAuthorization(spyAuthorizationConnector);
    public Answer validAnswer = new Answer(new Question(), new Option());

}
