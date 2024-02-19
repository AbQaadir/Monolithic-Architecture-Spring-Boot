package com.example.ytpractice.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("companies/{companyId}")
public class ReviewController {

	private final ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> findAllReviews(@PathVariable Long companyId) {
		return ResponseEntity.ok(reviewService.findAllReviews(companyId));
	}

	@PostMapping("/reviews")
	public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review) {
		boolean isReviewSaved = reviewService.createReview(companyId, review);
		if (isReviewSaved) {
			return ResponseEntity.ok("Review created successfully");
		}
		return ResponseEntity.badRequest().body("Company not found");
	}
}
