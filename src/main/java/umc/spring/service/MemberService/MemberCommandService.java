package umc.spring.service.MemberService;

import umc.spring.domain.Member;
import umc.spring.web.dto.request.MemberRequestDTO;

import java.util.List;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
    boolean categoriesExist(List<Long> categoryIds);
}
