package com.example.application.data.service;

import com.example.application.data.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAllReviews() {
        return reviewRepository.findAll(); // Use JpaRepository's built-in method
    }

    public List<Review> findReviewsByProductId(Long productId) {
        return reviewRepository.findByProductId(productId); // Custom method, ensure it's implemented in the repository
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id); // Use JpaRepository's built-in method
    }
}
