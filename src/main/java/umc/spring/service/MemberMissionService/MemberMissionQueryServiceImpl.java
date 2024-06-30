package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.response.MemberMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<Mission> getMissionListByMemberAndStatus(Long memberId, MissionStatus status, Integer page) {
        Page<MemberMission> memberMissionPage = memberMissionRepository.findAllByMemberIdAndStatus(memberId, status, PageRequest.of(page, 10));

        List<Mission> missionList = memberMissionPage.getContent().stream()
                .map(MemberMission::getMission)
                .collect(Collectors.toList());

        return new PageImpl<>(missionList, memberMissionPage.getPageable(), memberMissionPage.getTotalElements());
    }

}
