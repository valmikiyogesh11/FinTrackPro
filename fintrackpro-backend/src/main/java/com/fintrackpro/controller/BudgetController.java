package com.fintrackpro.controller;

import com.fintrackpro.dto.BudgetRequest;
import com.fintrackpro.model.*;
import com.fintrackpro.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
@CrossOrigin
public class BudgetController {

    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public BudgetController(BudgetRepository budgetRepository,
                            UserRepository userRepository,
                            CategoryRepository categoryRepository) {
        this.budgetRepository = budgetRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Budget> getAll() {
        return budgetRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BudgetRequest req) {
        User user = userRepository.findById(req.getUserId()).orElse(null);
        Category category = categoryRepository.findById(req.getCategoryId()).orElse(null);
        if (user == null || category == null) {
            return ResponseEntity.badRequest().body("Invalid userId or categoryId");
        }
        Budget b = new Budget();
        b.setUser(user);
        b.setCategory(category);
        b.setMonth(req.getMonth());
        b.setYear(req.getYear());
        b.setLimitAmount(req.getLimitAmount());
        b.setUsedAmount(0.0);
        return ResponseEntity.ok(budgetRepository.save(b));
    }
}
