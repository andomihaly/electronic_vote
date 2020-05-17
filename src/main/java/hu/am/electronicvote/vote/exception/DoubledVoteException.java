package hu.am.electronicvote.vote.exception;

public class DoubledVoteException extends VoteException {
    public DoubledVoteException() {
        super(ErrorCode.DOUBLED_VOTE);
    }
}
