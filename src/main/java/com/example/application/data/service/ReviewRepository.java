package com.example.application.data.service;

import com.example.application.data.entity.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProductId(Long productId); // Assuming you want to implement this
}
