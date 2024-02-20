package com.example.ytpractice.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Long> {

	List<Review> findAllByCompanyId(Long companyId);

	Review findByIdAndCompanyId(Long reviewId, Long companyId);
}