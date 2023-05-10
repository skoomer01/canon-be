package codecrusaders.business.converters;

import codecrusaders.domain.core.TestStep;
import codecrusaders.repository.entity.ErrorMessageEntity;
import codecrusaders.repository.entity.SubTestEntity;
import codecrusaders.repository.entity.TestStepEntity;

import javax.persistence.*;

public class TestStepConverter {
    public static TestStep toDomain(TestStepEntity entity) {
        return TestStep.builder()
                .id(entity.getId())
                .subTestId(entity.getSubTestId())
                .description(entity.getDescription())
                .message(ErrorMessageConverter.toDomain(entity.getMessage()))
                .build();
    }

    public static TestStepEntity toEntity(TestStep domain) {
        TestStepEntity entity = new TestStepEntity();
        entity.setId(domain.getId());
        entity.setSubTestId(domain.getSubTestId());
        entity.setDescription(domain.getDescription());
        entity.setMessage(ErrorMessageConverter.toEntity(domain.getMessage()));
        return entity;
    }
}
