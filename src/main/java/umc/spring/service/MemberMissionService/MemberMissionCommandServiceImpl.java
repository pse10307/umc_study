package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.request.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public MemberMission createMemberMission(Long memberId, Long MissionId, MemberMissionRequestDTO.MemberMissionDTO request) {
        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request);
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(memberId).orElseThrow(()-> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        newMemberMission.setMember(member);
        newMemberMission.setMission(mission);
        return memberMissionRepository.save(newMemberMission);
    }

    @Override
    public boolean memberMissionExist(Long missionId){return memberMissionRepository.existsByMissionId(missionId);}
}
