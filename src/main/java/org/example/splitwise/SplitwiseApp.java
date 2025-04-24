package org.example.splitwise;

import org.example.splitwise.enums.ExpenseType;
import org.example.splitwise.models.*;
import org.example.splitwise.services.ExpenseService;

import java.util.List;

public class SplitwiseApp {
    public static void main(String[] args) {
        User u1 = new User("u1", "Alice", "alice@gmail.com", "111");
        User u2 = new User("u2", "Bob", "bob@gmail.com", "222");
        User u3 = new User("u3", "charlie", "charlie@gmail.com", "333");


        ExpenseService expenseService = new ExpenseService();

        Expense e1 = new Expense("e1", 300, u1, ExpenseType.EQUAL,
                List.of(new EqualSplit(u1), new EqualSplit(u2), new EqualSplit(u3)));
        expenseService.addExpense(e1);

        Expense e2 = new Expense("e2", 300, u2, ExpenseType.EXACT,
                List.of(new ExactSplit(u1, 150), new ExactSplit(u2, 50), new ExactSplit(u3, 100)));
        expenseService.addExpense(e2);

        Expense e3 = new Expense("e3", 300, u3, ExpenseType.PERCENTAGE,
                List.of(new PercentSplit(u1, 50), new PercentSplit(u2, 25), new PercentSplit(u3, 25)));
        expenseService.addExpense(e3);

        expenseService.showBalances();


    }
}
