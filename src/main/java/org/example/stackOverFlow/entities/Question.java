package org.example.stackOverFlow.entities;

import java.util.ArrayList;
import java.util.List;

public class Question implements Votable, Commentable{
    private final String title;
    private final String content;
    private final User author;
    private final List<Tag> tags;
    private final List<Vote> votes;
    private final List<Answer> answers;
    private final List<Comment>  comments;

    public Question(String title, String content, User author, List<Tag> tags){
        this.title=title;
        this.content=content;
        this.author=author;
        this.tags=tags;
        this.votes=new ArrayList<>();
        this.answers=new ArrayList<>();
        this.comments=new ArrayList<>();
    }

    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return this.comments;
    }

    @Override
    public void addVote(Vote vote) {
        this.votes.add(vote);
        this.author.updateReputation(vote.getVoteValue()*5);

    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getVoteValue).sum();
    }

    public void addAnswers(Answer answer) {
        this.answers.add(answer);
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
    
}
