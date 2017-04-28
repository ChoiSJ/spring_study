package kr.co.jhta.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.board.ReviewDao;
import kr.co.jhta.vo.Review;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	public void addReview(Review review) {
		reviewDao.addReview(review);
	}

	@Override
	public List<Review> getAllReviewByNo(int bno) {
		return reviewDao.getAllReviewByNo(bno);
	}

	@Override
	public Review getReviewByNo(int rno) {
		return reviewDao.getReviewByNo(rno);
	}

	@Override
	public void deleteReview(int rno) {
		reviewDao.deleteReview(rno);
		
	}
	
}
