package com.example.ytpractice.review;

import java.util.List;

public interface ReviewService {

	List<Review> findAllReviews(Long companyId);

	boolean createReview(Long companyId, Review review);


}
