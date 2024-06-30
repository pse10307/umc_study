package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import umc.spring.domain.Member;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMissionId(Long missionId);

    @Query("SELECT mm FROM MemberMission mm WHERE mm.member.id = :memberId AND mm.status = :status")
    Page<MemberMission> findAllByMemberIdAndStatus(Long memberId, MissionStatus status,PageRequest pageRequest);
}
