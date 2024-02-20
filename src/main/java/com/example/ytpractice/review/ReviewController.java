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

	// Add a new endpoint to get all reviews for a company
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> findAllReviews(@PathVariable Long companyId) {
		return ResponseEntity.ok(reviewService.findAllReviews(companyId));
	}

	// Add a new endpoint to create a review
	@PostMapping("/reviews")
	public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review) {
		boolean isReviewSaved = reviewService.createReview(companyId, review);
		if (isReviewSaved) {
			return ResponseEntity.ok("Review created successfully");
		}
		return ResponseEntity.badRequest().body("Company not found");
	}

	// Add a new endpoint to get a review by its ID
	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId) {
		Review review = reviewService.getReviewById(companyId, reviewId);
		if (review != null) {
			return ResponseEntity.ok(review);
		}
		return ResponseEntity.notFound().build();
	}

	// Add a new endpoint to update a review
	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
		boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId, review);
		if (isReviewUpdated) {
			return ResponseEntity.ok("Review updated successfully");
		}
		return ResponseEntity.badRequest().body("Review not found");
	}

	// Delete a review
	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
		boolean isReviewDeleted = reviewService.deleteReview(companyId, reviewId);
		if (isReviewDeleted) {
			return ResponseEntity.ok("Review deleted successfully");
		}
		return ResponseEntity.badRequest().body("Review not found");
	}
}
