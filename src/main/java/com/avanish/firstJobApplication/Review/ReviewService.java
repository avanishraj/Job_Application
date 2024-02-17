package com.avanish.firstJobApplication.Review;

import java.util.List;

public interface ReviewService {
    boolean addReview(ReviewEntity review, Long companiesId);

    List<ReviewEntity> getAllReviews(Long companiesId);

    ReviewEntity getReview(Long companiesId, Long reviewId);

    boolean updateReview(Long companiesId, Long reviewId, ReviewEntity updatedReview);

    boolean deleteReview(Long companyId, Long reviewId);
}
