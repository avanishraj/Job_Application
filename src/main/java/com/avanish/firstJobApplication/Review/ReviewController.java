package com.avanish.firstJobApplication.Review;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/companies/{companiesId}")
public class ReviewController {
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    final private ReviewService reviewService;
    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@RequestBody ReviewEntity review, @PathVariable Long companiesId){
        boolean isReviewSaved = reviewService.addReview(review, companiesId);
        if(isReviewSaved) {
            return new ResponseEntity<>("Review added Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review Not saved", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public ResponseEntity<List<ReviewEntity>> getAllReviews(@PathVariable Long companiesId){
        return new ResponseEntity<>(reviewService.getAllReviews(companiesId), HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<ReviewEntity> getReview(@PathVariable Long companiesId, @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companiesId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companiesId, @PathVariable Long reviewId, @RequestBody ReviewEntity review){
        boolean isReviewUpdated = reviewService.updateReview(companiesId, reviewId, review);
        if(isReviewUpdated) return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        else return new ResponseEntity<>("Review not updated", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companiesId, @PathVariable Long reviewId){
        boolean isDeleted = reviewService.deleteReview(companiesId, reviewId);
        if(isDeleted) return ResponseEntity.ok("Review Deleted Successfully");
        else return new ResponseEntity<>("Review not deleted", HttpStatus.NO_CONTENT);
    }
}
