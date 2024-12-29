package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);

    //void getReviewList(Long storeId, Integer page);

    Page<Review> getReviewList(Long StoreId, Integer page);

    Page<Review> getMyReviewList(Long memberId, Integer page);
}