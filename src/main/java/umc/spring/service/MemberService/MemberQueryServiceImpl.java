package umc.spring.service.MemberService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long MemberId, Integer page) {

        Member member = memberRepository.findById(MemberId).get();

        Page<Review> StorePage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return StorePage;
    }
}
