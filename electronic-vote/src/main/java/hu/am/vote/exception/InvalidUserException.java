package hu.am.vote.exception;

public class InvalidUserException extends VoteException {
    public InvalidUserException() {
        super(ErrorCode.INVALID_USER);
    }
}
