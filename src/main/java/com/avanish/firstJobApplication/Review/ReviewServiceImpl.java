package com.avanish.firstJobApplication.Review;
import com.avanish.firstJobApplication.company.CompanyEntity;
import com.avanish.firstJobApplication.company.CompanyServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements  ReviewService{
    private final ReviewRepository reviewRepository;
    private final CompanyServices company;
    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyServices company) {
        this.reviewRepository = reviewRepository;
        this.company = company;
    }

    @Override
    public boolean addReview(ReviewEntity review, Long companiesId) {
        CompanyEntity companyEntity = company.getCompanyById(companiesId);
        if(companyEntity != null) {
            review.setCompany(companyEntity);
            reviewRepository.save(review);
        }
        return false;
    }

    @Override
    public List<ReviewEntity> getAllReviews(Long companiesId) {
        return reviewRepository.findByCompanyId(companiesId);
    }

    @Override
    public ReviewEntity getReview(Long companiesId, Long reviewId) {
        List<ReviewEntity> reviews = reviewRepository.findByCompanyId(companiesId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companiesId, Long reviewId, ReviewEntity updatedReview) {
        if(company.getCompanyById(companiesId) != null){
            updatedReview.setId(reviewId);
            updatedReview.setCompany(company.getCompanyById(companiesId));
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(company.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)){
            ReviewEntity review = reviewRepository.findById(reviewId).orElse(null);
            assert review != null;
            CompanyEntity companyEntity = review.getCompany();
            companyEntity.getReview().remove(review);
            review.setCompany(null);
            company.updateCompanyById(companyId, companyEntity);
            reviewRepository.deleteById(reviewId);
            return  true;
        }
        return  false;
    }
}
