package com.avanish.firstJobApplication.Review;

import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements  ReviewService{
    private ReviewRepository reviewRepository;
    @Override
    public void addReview(ReviewEntity review) {
        reviewRepository.save(review);
    }
}
