package hu.am.electronicvote.vote.exception;

public abstract class VoteException extends RuntimeException {
    public ErrorCode errorCode;
    public VoteException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
