package am.vote;

import am.vote.entity.Answer;
import am.vote.entity.Questionnaire;
import am.vote.entity.User;

public interface Election {
    boolean isStarted();

    Questionnaire getQuestionnaire();

    void vote(Answer answer);

    boolean isVoted(User user);
}
