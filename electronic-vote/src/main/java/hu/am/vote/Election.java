package hu.am.vote;

import hu.am.vote.entity.Answer;
import hu.am.vote.entity.Questionnaire;
import hu.am.vote.entity.User;

import java.util.List;

public interface Election {
    boolean isOngoing();

    Questionnaire getQuestionnaire();

    void vote(User user, List<Answer> vote);

    boolean isVoted(User user);

}
