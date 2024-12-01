package umc.study.service.ReviewService;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.converter.ReviewConverter;
@Service
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    public ReviewCommandServiceImpl(StoreRepository storeRepository, MemberRepository memberRepository, ReviewRepository reviewRepository) {
        this.storeRepository = storeRepository;
        this.memberRepository = memberRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO request) {
        Review review = ReviewConverter.toReview(request, storeRepository, memberRepository);
        return reviewRepository.save(review);
    }
}
