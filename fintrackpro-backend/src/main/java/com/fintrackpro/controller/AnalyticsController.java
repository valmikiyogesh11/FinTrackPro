package com.fintrackpro.controller;

import com.fintrackpro.model.Transaction;
import com.fintrackpro.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin
public class AnalyticsController {

    private final TransactionRepository transactionRepository;

    public AnalyticsController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/summary/{userId}")
    public Map<String, Double> getSummary(@PathVariable Long userId) {
        List<Transaction> transactions = transactionRepository.findByUserId(userId);
        double income = 0.0;
        double expense = 0.0;
        for (Transaction t : transactions) {
            if ("INCOME".equalsIgnoreCase(t.getType())) {
                income += t.getAmount();
            } else if ("EXPENSE".equalsIgnoreCase(t.getType())) {
                expense += t.getAmount();
            }
        }
        Map<String, Double> result = new HashMap<>();
        result.put("totalIncome", income);
        result.put("totalExpense", expense);
        result.put("netSavings", income - expense);
        return result;
    }
}
