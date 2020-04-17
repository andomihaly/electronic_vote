package hu.am.vote;

import hu.am.vote.entity.Answer;
import hu.am.vote.entity.Questionnaire;
import hu.am.vote.entity.User;

import java.util.List;

public interface Election {
    boolean isStarted();

    Questionnaire getQuestionnaire();

    void vote(User user, List<Answer> vote);

    List<Answer> getVote(User user);

    boolean isVoted(User user);

}
