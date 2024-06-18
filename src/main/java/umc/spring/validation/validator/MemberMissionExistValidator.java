package umc.spring.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.validation.annotation.ExistMemberMission;

@Component
@RequiredArgsConstructor
public class MemberMissionExistValidator implements ConstraintValidator<ExistMemberMission, Long> {

    private final MemberMissionCommandService memberMissionCommandService;

    @Override
    public void initialize(ExistMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        boolean isValid = memberMissionCommandService.memberMissionExist(missionId);

        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_EXISTS.toString()).addConstraintViolation();
        }

        return !isValid;
    }
}
