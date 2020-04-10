package am.vote;

import am.vote.entity.Answer;
import am.vote.entity.Questionnaire;
import am.vote.entity.User;

import java.util.List;

public interface Election {
    boolean isStarted();

    Questionnaire getQuestionnaire();

    void vote(User user, List<Answer> vote);

    List<Answer> getVote(User user);

    boolean isVoted(User user);
}
