package org.example.stackOverFlow.services;

import org.example.stackOverFlow.entities.Answer;
import org.example.stackOverFlow.entities.Question;
import org.example.stackOverFlow.entities.Tag;
import org.example.stackOverFlow.entities.User;

import java.util.ArrayList;
import java.util.List;

public class StackOverflow {
    private final List<Question> questions;

    public StackOverflow(){
        this.questions=new ArrayList<>();
    }

    public Question postQuestion(User author, String title, String content, List<Tag> tags){
        Question q = new Question(title, content, author, tags);
        questions.add(q);
        return q;
    }

    public Answer postAnswer(User author, String content, Question question) {
        Answer answer = new Answer(content, author);
        question.addAnswers(answer);
        return answer;
    }

    public List<Question> searchByTags(String tagName) {
        List<Question> result = new ArrayList<>();
        for(Question q: questions){
            for(Tag t: q.getTags()){
                if(t.getName().equalsIgnoreCase(tagName)){
                    result.add(q);
                    break;
                }
            }
        }
        return result;
    }

}
