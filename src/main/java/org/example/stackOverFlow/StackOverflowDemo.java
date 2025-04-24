package org.example.stackOverFlow;

import org.example.stackOverFlow.entities.Question;
import org.example.stackOverFlow.entities.Tag;
import org.example.stackOverFlow.entities.User;
import org.example.stackOverFlow.entities.Vote;
import org.example.stackOverFlow.enums.VoteType;
import org.example.stackOverFlow.services.StackOverflow;

import java.util.Arrays;

public class StackOverflowDemo {
    public static void main(String[] args) {
        StackOverflow stackOverflow = new StackOverflow();


        User alice = new User("Alice");
        User bob = new User("Bob");

        Tag java = new Tag("Java");
        Tag spring = new Tag("spring");

        Question q1 = stackOverflow.postQuestion(alice,"What is spring?", "I want to learn all the annotation in sproing boot", Arrays.asList(java, spring));
        stackOverflow.postAnswer(bob, "autowired, configuration, slf4j, entity, etc", q1);

        q1.addVote(new Vote(bob, VoteType.UPVOTE));
        q1.getAnswers().get(0).addVote(new Vote(alice, VoteType.UPVOTE));


        System.out.println("Question: " + q1.getTitle());
        System.out.println("Votes: " + q1.getVoteCount());
        System.out.println("Answers: " + q1.getAnswers().size());
        System.out.println("Alice's reputation: " + alice.getReputation());
        System.out.println("Bob's reputation: " + bob.getReputation());
    }
}
