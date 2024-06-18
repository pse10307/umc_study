package umc.spring.repository;

import org.springframework.data.repository.CrudRepository;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionRepository extends CrudRepository<MemberMission, Long> {
    boolean existsByMissionId(Long missionId);
}
