package org.example.stackOverFlow.entities;

import org.example.stackOverFlow.enums.VoteType;

public class Vote {
    private final User voter;
    private final VoteType voteType;

    public Vote(User voter, VoteType voteType) {
        this.voter = voter;
        this.voteType = voteType;
    }

    public int getVoteValue() {
        return voteType == VoteType.UPVOTE ? 1 : -1;
    }

    public User getVoter(){
        return this.voter;
    }


}
