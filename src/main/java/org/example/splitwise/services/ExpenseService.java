package org.example.splitwise.services;

import org.example.splitwise.models.Expense;
import org.example.splitwise.models.PercentSplit;
import org.example.splitwise.models.Split;
import org.example.splitwise.models.User;

import java.util.HashMap;
import java.util.Map;

public class ExpenseService {
    private final Map<String, Map<String, Double>> balances = new HashMap<>();

    public void addExpense(Expense expense) {
        User paidBy = expense.getPaidBy();
        double totalAmount = expense.getAmount();
        switch (expense.getExpenseType()) {
            case EQUAL -> {
                int totalUsers = expense.getSplits().size();
                double share = totalAmount / totalUsers;
                for (Split split : expense.getSplits()) {
                    split.setAmount(share);
                }
            }
            case PERCENTAGE -> {
                for (Split split : expense.getSplits()) {
                    PercentSplit percentSplit = (PercentSplit) split;
                    double share = totalAmount * percentSplit.getPercent() / 100;
                    split.setAmount(share);
                }
            }
            case EXACT -> {

            }
        }

        for (Split split : expense.getSplits()) {
            String paidById = paidBy.getId();
            String owedById = split.getUser().getId();
            double owedAmount = split.getAmount();

            if (!paidById.equals(owedById)) {
                balances.putIfAbsent(owedById, new HashMap<>());
                balances.get(owedById).put(paidById, balances.get(owedById).getOrDefault(paidById, 0.0) + owedAmount);

                balances.putIfAbsent(paidById, new HashMap<>());
                balances.get(owedById).put(owedById, balances.get(paidById).getOrDefault(owedById, 0.0) - owedAmount);
            }
        }

    }


//    public void settleBalance() {
//        Map<String, Double> netBalances = new HashMap<>();
//
//        for(Map.Entry<String, Map<String, Double>> entry: balances.entrySet()) {
//
//        }
//    }

    public void showBalances() {
        for (Map.Entry<String, Map<String, Double>> entry : balances.entrySet()) {
            for (Map.Entry<String, Double> balance : entry.getValue().entrySet()) {
                if (balance.getValue() > 0) {
                    System.out.printf("%s owes %s: %2f\n", entry.getKey(), balance.getKey(), balance.getValue());
                }
            }
        }
    }

    static class UserBalance {
        String userId;
        double amount;

        public UserBalance(String userId, double amount) {
            this.userId = userId;
            this.amount = amount;
        }
    }
}
