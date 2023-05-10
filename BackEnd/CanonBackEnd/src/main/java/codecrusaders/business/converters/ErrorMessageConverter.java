package codecrusaders.business.converters;

import codecrusaders.domain.core.ErrorMessage;
import codecrusaders.repository.entity.ErrorMessageEntity;

public class ErrorMessageConverter {
    public static ErrorMessage toDomain(ErrorMessageEntity entity) {
        return ErrorMessage.builder()
                .id(entity.getId())
                .message(entity.getMessage())
                .testStepID(entity.getTestStepID())
                .build();
    }

    public static ErrorMessageEntity toEntity(ErrorMessage domain) {
        ErrorMessageEntity entity = new ErrorMessageEntity();
        entity.setId(domain.getId());
        entity.setMessage(domain.getMessage());
        entity.setTestStepID(domain.getTestStepID());
        return entity;
    }
}

