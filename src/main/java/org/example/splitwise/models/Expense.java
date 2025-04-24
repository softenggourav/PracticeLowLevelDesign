package org.example.splitwise.models;

import org.example.splitwise.enums.ExpenseType;

import java.util.List;

public class Expense {
    private final String id;
    private final double amount;
    private final User paidBy;
    private final ExpenseType expenseType;
    private final List<Split> splits;

    public Expense(String id, double amount, User paidBy, ExpenseType expenseType, List<Split> splits) {
        this.id = id;
        this.amount = amount;
        this.paidBy = paidBy;
        this.expenseType = expenseType;
        this.splits = splits;
    }

    public double getAmount() {
        return this.amount;
    }

    public User getPaidBy() {
        return this.paidBy;
    }

    public List<Split> getSplits() {
        return this.splits;
    }

    public ExpenseType getExpenseType() {
        return this.expenseType;
    }


}
