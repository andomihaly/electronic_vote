package hu.am.electronicvote.vote;

import hu.am.electronicvote.vote.entity.Answer;
import hu.am.electronicvote.vote.entity.Questionnaire;

import java.util.List;

public interface Election {
    boolean isOngoing();

    Questionnaire getQuestionnaire();

    void vote(String userId, List<Answer> vote);

    boolean isVoted(String userId);

}
