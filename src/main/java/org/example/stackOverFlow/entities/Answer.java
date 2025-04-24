package org.example.stackOverFlow.entities;

import java.util.ArrayList;
import java.util.List;

public class Answer implements Votable, Commentable{

    private final String content;
    private final User author;
    private final List<Vote> votes;
    private final List<Comment> comments;


    public Answer(String content, User author) {
        this.content=content;
        this.author=author;
        this.votes=new ArrayList<>();
        this.comments=new ArrayList<>();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);

    }

    @Override
    public List<Comment> getComments() {
        return this.comments;
    }

    @Override
    public void addVote(Vote vote) {
        votes.add(vote);
        author.updateReputation(vote.getVoteValue()*10);

    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getVoteValue).sum();
    }

    public User getAuthor(){
        return this.author;
    }

    public String getContent() {
        return this.content;
    }
}
