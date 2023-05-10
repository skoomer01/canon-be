package codecrusaders.business.converters;

import codecrusaders.domain.core.ErrorMessage;
import codecrusaders.repository.entity.ErrorMessageEntity;

import java.util.Optional;

public class ErrorMessageConverter {
    public static ErrorMessage toDomain(ErrorMessageEntity entity) {
        if(entity == null){
            return null;
        }
        return ErrorMessage.builder()
                .id(entity.getId())
                .message(entity.getMessage())
                .testStepID(entity.getTestStepID())
                .build();
    }

    public static ErrorMessageEntity toEntity(ErrorMessage domain) {
        if(domain == null){
            return null;
        }
        ErrorMessageEntity entity = new ErrorMessageEntity();
        entity.setId(domain.getId());
        entity.setMessage(domain.getMessage());
        entity.setTestStepID(domain.getTestStepID());
        return entity;
    }
}

