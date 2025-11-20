package com.fintrackpro.controller;

import com.fintrackpro.dto.TransactionRequest;
import com.fintrackpro.model.*;
import com.fintrackpro.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public TransactionController(TransactionRepository transactionRepository,
                                 UserRepository userRepository,
                                 CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<Transaction> getByUser(@PathVariable Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TransactionRequest req) {
        User user = userRepository.findById(req.getUserId()).orElse(null);
        Category category = categoryRepository.findById(req.getCategoryId()).orElse(null);
        if (user == null || category == null) {
            return ResponseEntity.badRequest().body("Invalid userId or categoryId");
        }
        Transaction t = new Transaction();
        t.setUser(user);
        t.setCategory(category);
        t.setType(req.getType());
        t.setAmount(req.getAmount());
        t.setPaymentMode(req.getPaymentMode());
        t.setDate(req.getDate());
        t.setNote(req.getNote());
        return ResponseEntity.ok(transactionRepository.save(t));
    }
}
