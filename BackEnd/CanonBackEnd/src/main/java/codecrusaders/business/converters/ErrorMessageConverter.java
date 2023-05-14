package codecrusaders.business.converters;

import codecrusaders.domain.nestedstructure.ErrorMessage;
import codecrusaders.domain.nestedstructure.TestStep;
import codecrusaders.repository.entity.ErrorMessageEntity;
import codecrusaders.repository.entity.TestStepEntity;

public class ErrorMessageConverter {
    public static ErrorMessage toDomain(ErrorMessageEntity entity) {
        if(entity == null){
            return null;
        }
        return ErrorMessage.builder()
                .id(entity.getId())
                .message(entity.getMessage())
                .build();
    }

    public static ErrorMessageEntity toEntity(ErrorMessage domain) {
        if(domain == null){
            return null;
        }
        ErrorMessageEntity entity = new ErrorMessageEntity();
        entity.setId(domain.getId());
        entity.setMessage(domain.getMessage());
        return entity;
    }
}

