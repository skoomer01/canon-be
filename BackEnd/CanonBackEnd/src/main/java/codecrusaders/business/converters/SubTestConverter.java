package codecrusaders.business.converters;

import codecrusaders.domain.nestedstructure.RegressionTest;
import codecrusaders.domain.nestedstructure.SubTest;
import codecrusaders.repository.entity.RegressionTestEntity;
import codecrusaders.repository.entity.SubTestEntity;
import codecrusaders.repository.entity.TestSetEntity;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubTestConverter {
    public static SubTest toDomain(SubTestEntity entity) {
        if(entity == null){
            return null;
        }
        return SubTest.builder()
                .id(entity.getId())
                .name(entity.getName())
                .regressionTest(
                        RegressionTest.builder()
                                .id(entity.getRegressionTest().getId())
                                .name(entity.getRegressionTest().getName())
                                .build()
                )
                .testSteps(Optional.ofNullable(entity.getTestSteps())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(TestStepConverter::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }
    public static SubTestEntity toEntity(SubTest domain) {
        if(domain == null){
            return null;
        }
        return SubTestEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .regressionTest(
                        RegressionTestEntity.builder()
                        .id(domain.getRegressionTest().getId())
                        .name(domain.getRegressionTest().getName())
                        .build())
                .testSteps(Optional.ofNullable(domain.getTestSteps())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(TestStepConverter::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

}
