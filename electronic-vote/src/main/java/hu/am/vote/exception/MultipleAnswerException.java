package hu.am.vote.exception;

public class MultipleAnswerException extends VoteException {
    public MultipleAnswerException() {
        super(ErrorCode.MULTIPLE_ANSWER);
    }
}
