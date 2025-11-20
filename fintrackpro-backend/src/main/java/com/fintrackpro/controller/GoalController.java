package com.fintrackpro.controller;

import com.fintrackpro.dto.GoalRequest;
import com.fintrackpro.model.Goal;
import com.fintrackpro.model.User;
import com.fintrackpro.repository.GoalRepository;
import com.fintrackpro.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin
public class GoalController {

    private final GoalRepository goalRepository;
    private final UserRepository userRepository;

    public GoalController(GoalRepository goalRepository,
                          UserRepository userRepository) {
        this.goalRepository = goalRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Goal> getAll() {
        return goalRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody GoalRequest req) {
        User user = userRepository.findById(req.getUserId()).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest().body("Invalid userId");
        }
        Goal g = new Goal();
        g.setUser(user);
        g.setName(req.getName());
        g.setTargetAmount(req.getTargetAmount());
        g.setCurrentAmount(0.0);
        g.setTargetDate(req.getTargetDate());
        g.setStatus("ACTIVE");
        return ResponseEntity.ok(goalRepository.save(g));
    }
}
