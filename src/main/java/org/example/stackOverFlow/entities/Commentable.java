package org.example.stackOverFlow.entities;

import java.util.List;

public interface Commentable {
    void addComment(Comment comment);

    List<Comment> getComments();

}
