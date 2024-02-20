package com.example.ytpractice.review.impl;

import com.example.ytpractice.company.Company;
import com.example.ytpractice.company.CompanyService;
import com.example.ytpractice.review.ReviewRepository;
import org.springframework.stereotype.Service;

import com.example.ytpractice.review.Review;
import com.example.ytpractice.review.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepository reviewRepository;
	private final CompanyService companyService;

	public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
		this.reviewRepository = reviewRepository;
		this.companyService = companyService;
	}

	@Override
	public List<Review> findAllReviews(Long companyId) {
		return reviewRepository.findAllByCompanyId(companyId);
	}

	@Override
	public boolean createReview(Long companyId, Review review) {
		Company company = companyService.getCompanyById(companyId);

		if (company != null) {
			review.setCompany(company);
			reviewRepository.save(review);
			return true;
		}

		return false;
	}

	@Override
	public Review getReviewById(Long companyId, Long reviewId) {
		return reviewRepository.findByIdAndCompanyId(reviewId, companyId);
	}
}
