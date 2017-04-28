package kr.co.jhta.dao.board;

import java.util.List;

import kr.co.jhta.vo.Review;

public interface ReviewDao {

	void addReview(Review review);

	List<Review> getAllReviewByNo(int bno);

	Review getReviewByNo(int rno);

	void deleteReview(int rno);

}