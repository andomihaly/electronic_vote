package hu.am.electronicvote.vote.entity;

public class OngoingTurnoutStatistic {
    public int numberOfPotentialVoter = -1;
    public int numberOfVoterAlreadyVoted = -1;

    public double getTurnoutRate() {
        if(numberOfPotentialVoter <= 0 || numberOfVoterAlreadyVoted < 0){
            return -1;
        }
        return ((double) numberOfVoterAlreadyVoted) / ((double) numberOfPotentialVoter);
    }
}
