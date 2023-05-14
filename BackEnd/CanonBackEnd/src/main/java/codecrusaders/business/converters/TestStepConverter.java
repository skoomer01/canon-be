package codecrusaders.business.converters;

import codecrusaders.domain.nestedstructure.SubTest;
import codecrusaders.domain.nestedstructure.TestStep;
import codecrusaders.repository.entity.SubTestEntity;
import codecrusaders.repository.entity.TestStepEntity;

public class TestStepConverter {
    public static TestStep toDomain(TestStepEntity entity) {
        if(entity == null){
            return null;
        }
        return TestStep.builder()
                .id(entity.getId())
                .name(entity.getName())
                .subTest(
                        SubTest.builder()
                                .id(entity.getSubTest().getId())
                                .name(entity.getSubTest().getName())
                                .build()
                )
                .description(entity.getDescription())
                .message(ErrorMessageConverter.toDomain(entity.getMessage()))
                .build();
    }

    public static TestStepEntity toEntity(TestStep domain) {
        if(domain == null){
            return null;
        }
        TestStepEntity entity = new TestStepEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setSubTest(
                SubTestEntity.builder()
                        .id(domain.getSubTest().getId())
                        .name(domain.getSubTest().getName())
                        .build());
        entity.setDescription(domain.getDescription());
        entity.setMessage(ErrorMessageConverter.toEntity(domain.getMessage()));
        return entity;
    }
}
