package com.keyin.server.controller;

import com.keyin.server.entity.Feedback;
import com.keyin.server.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    // CREATE
    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    // READ
    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/rep/{repID}")
    public List<Feedback> getFeedbackByRepID(@PathVariable Long repID) {
        return feedbackService.getFeedbackByRepID(repID);
    }

    @GetMapping("/rep/{repID}/average-rating")
    public Double getAverageRatingByRepId(@PathVariable Long repID) {
        return feedbackService.getAverageRatingByRepID(repID);
    }

    @GetMapping("/filter")
    public List<Feedback> getFeedbackByRating(@RequestParam int rating) {
        return feedbackService.getFeedbackByRating(rating);
    }

    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackByID(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Feedback updateFeedback(@PathVariable Long id, @RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(id, feedback);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }
}