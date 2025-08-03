package com.keyin.server.service;

import com.keyin.server.entity.Feedback;
import com.keyin.server.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public Feedback getFeedbackByID(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    public List<Feedback> getFeedbackByRepID(Long repID) {
        return feedbackRepository.findByRepID(repID);
    }

    public Double getAverageRatingByRepID(Long repID) {
        return feedbackRepository.findAverageRatingByRepID(repID);
    }

    public List<Feedback> getFeedbackByRating(int rating) {
        return feedbackRepository.findByRating(rating);
    }

    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback updateFeedback(Long id, Feedback feedback) {
        feedback.setID(id);
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}