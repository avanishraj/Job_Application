package com.avanish.firstJobApplication.Review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/review")
public class ReviewController {
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    final private ReviewService reviewService;
    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody ReviewEntity review){
        reviewService.addReview(review);
        return new ResponseEntity<>("Review added Successfully", HttpStatus.OK);
    }

}
